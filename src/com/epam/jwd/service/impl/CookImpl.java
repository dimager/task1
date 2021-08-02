package com.epam.jwd.service.impl;

import com.epam.jwd.dao.DaoException;
import com.epam.jwd.dao.SaladDressingDao;
import com.epam.jwd.dao.VegetableDao;
import com.epam.jwd.dao.impl.SaladDressingDaoImpl;
import com.epam.jwd.dao.impl.VegetableDaoImpl;
import com.epam.jwd.domain.Food;
import com.epam.jwd.domain.Salad;
import com.epam.jwd.domain.SaladDressing;
import com.epam.jwd.domain.SaladDressingIngredient;
import com.epam.jwd.domain.SaladDressingType;
import com.epam.jwd.domain.Vegetable;
import com.epam.jwd.domain.VegetableIngredient;
import com.epam.jwd.domain.VegetableType;
import com.epam.jwd.service.Cook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class CookImpl implements Cook {
    private final VegetableDao vegetableDao = new VegetableDaoImpl();
    private final SaladDressingDao saladDressingDao = new SaladDressingDaoImpl();
    private Salad salad;
    private Scanner scanner = new Scanner(System.in);

    @Override
    public Salad doSalad(String saladName) {
        this.salad = new Salad(saladName, getVegetablesForSalad(), getSaladDressingsForSalad());
        return salad;
    }

    @Override
    public List<Vegetable> getAllVegetables() {
        try {
            return vegetableDao.findAll();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<SaladDressing> getAllSaladDressings() {
        try {
            return saladDressingDao.findAll();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Vegetable> getVegetablesByType(VegetableType type) {
        List<Vegetable> vegetables = new ArrayList();
        try {
            vegetables = vegetableDao.findByType(type);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return vegetables;
    }

    @Override
    public List<SaladDressing> getSaladDressingsByType(SaladDressingType type) {
        List<SaladDressing> saladDressings = new ArrayList();
        try {
            saladDressings = saladDressingDao.findByType(type);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return saladDressings;
    }

    @Override
    public List<SaladDressing> getSaladDressingsById(int id) {
        List<SaladDressing> saladDressing = null;
        try {
            saladDressing = saladDressingDao.findById(id);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return saladDressing;
    }

    @Override
    public List<Vegetable> getVegetableById(int id) {
        List<Vegetable> vegetable = null;
        try {
            vegetable = vegetableDao.findById(id);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return vegetable;
    }

    //для пропуска выбора овощей через консоль
   /* private List<VegetableIngredient> getVegetablesForSalad() {
        //имитация выбора ингридиентов
        List<VegetableIngredient> ingredients = new ArrayList();
        getVegetableById(25).stream()
                .forEach(x -> ingredients.add(new VegetableIngredient(x, 300)));
        getVegetableById(24).stream()
                .forEach(x -> ingredients.add(new VegetableIngredient(x, 250)));
        getVegetableById(26).stream()
                .forEach(x -> ingredients.add(new VegetableIngredient(x, 150)));
        return ingredients;
    }*/

    //для  выбора овощей через консоль
    private List<VegetableIngredient> getVegetablesForSalad() {
        List<Vegetable> vegetableList;
        VegetableDao vegetableDao = new VegetableDaoImpl();
        List<VegetableIngredient> vegetableIngredientList = new ArrayList<>();
        while (true) {
            try {
                System.out.println("Choose vegetables for salad\nList of vegatable types:");
                Arrays.stream(VegetableType.values()).map(x -> x.ordinal()+1 + ". " + x.name()).forEach(System.out::println);
                vegetableList = vegetableDao.findByType(VegetableType.values()[getTypeFromConsole() - 1]);
                vegetableList.stream().map(x -> x.getId() + ". " + x.getName()).forEach(System.out::println);
                List<Vegetable> vegetables = vegetableDao.findById(getIdFromConsole());
                vegetables.stream().forEach(x -> vegetableIngredientList.add(new VegetableIngredient(x, getWeightFromConsole())));
                if (doDecisionExitOrNext())
                    return vegetableIngredientList;
            } catch (DaoException e) {
                e.printStackTrace();
            }
        }
    }

    //для пропуска выбора заправки через консоль
   /* private List<SaladDressingIngredient> getSaladDressingsForSalad() {
        List<SaladDressingIngredient> saladDressings = new ArrayList();
        getSaladDressingsById(1).stream()
                .forEach(x -> saladDressings.add(new SaladDressingIngredient(x, 30)));
        getSaladDressingsById(5).stream()
                .forEach(x -> saladDressings.add(new SaladDressingIngredient(x, 30)));
        return saladDressings;
    }*/


    //для выбора заправки через консоль
    private List<SaladDressingIngredient> getSaladDressingsForSalad() {
        List<SaladDressing> saladDressings;
        SaladDressingDao saladDressingDao = new SaladDressingDaoImpl();
        List<SaladDressingIngredient> saladDressingIngredientList = new ArrayList();
        try {
            int saladDressingId = selectSaladDressingType();
            switch (saladDressingId) {
                case 1:
                    while (true) {
                        saladDressings = saladDressingDao.findByType(SaladDressingType.values()[saladDressingId - 1]);
                        saladDressings.stream()
                                .map(x -> x.getId() + " " + x.getName())
                                .forEach(System.out::println);
                        List<SaladDressing> saladDressing = saladDressingDao.findById(getIdFromConsole());
                        saladDressing.stream()
                                .forEach(x -> saladDressingIngredientList.add(new SaladDressingIngredient(x, getWeightFromConsole())));
                        if (doDecisionExitOrNext())
                            return saladDressingIngredientList;
                    }
                case 2:
                    saladDressings = saladDressingDao.findByType(SaladDressingType.values()[saladDressingId - 1]);
                    saladDressings.stream()
                            .map(x -> x.getId() + " " + x.getName())
                            .forEach(System.out::println);
                    List<SaladDressing> sd = saladDressingDao.findById(getIdFromConsole());
                    sd.stream()
                            .forEach(x -> saladDressingIngredientList.add(new SaladDressingIngredient(x, getWeightFromConsole())));
                    return saladDressingIngredientList;
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return saladDressingIngredientList;
    }

    @Override
    public double calculateSaladEnergy(Salad salad) {
        if (salad != null) {
            double energy = salad.getSaladDressingIngredientList().stream()
                    .mapToDouble(Food::getEnergy)
                    .sum() +
                    salad.getVegetableIngredientList().stream()
                            .mapToDouble(Food::getEnergy)
                            .sum();
            return energy;
        }
        return 0;
    }

    @Override
    public void sortVegetablesByCarb(List<VegetableIngredient> v) {
        if (!v.isEmpty()) {
            System.out.println("\nVegetable salad ingredients are sorted by carbs");
            salad.getVegetableIngredientList()
                    .stream()
                    .sorted(Comparator.comparingDouble(Food::getCarbs))
                    .filter((x) -> x.getCarbs() >= 0)
                    .forEach((p) -> System.out.println(p.getName() + " " + p.getCarbs()));
        }
    }

    @Override
    public void findVegetablesByEnergy(List<VegetableIngredient> v, double lowerLimit, double upperLimit) {
        if (!v.isEmpty()) {
            System.out.println("\nTotal energy of each vegetable in salad (from " + lowerLimit + "kcal to " + upperLimit + "kcal):");
            this.salad.getVegetableIngredientList()
                    .stream()
                    .sorted(Comparator.comparingDouble(Food::getEnergy))
                    .filter((x) -> x.getEnergy() >= lowerLimit && x.getEnergy() <= upperLimit)
                    .forEach((p) -> System.out.println(p.getName() + " " + p.getEnergy()));
        }
    }

    private int getWeightFromConsole() {
        System.out.print("Enter weight: ");
        return scanner.nextInt();
    }

    private int getIdFromConsole() {
        System.out.print("Select id: ");
        return scanner.nextInt();
    }

    private int getTypeFromConsole() {
        System.out.print("Select type of vegetables: ");
        return scanner.nextInt();
    }

    private int selectSaladDressingType() {
        System.out.println("Choose salad dressing for salad\nList of salad dressing types: ");
        int typeid;
        do {
            Arrays.stream(SaladDressingType.values())
                    .map(x -> x.ordinal()+1 + ". " + x.name())
                    .forEach(System.out::println);
            System.out.print("Select type of salad dressing: ");
            typeid = scanner.nextInt();
        }
        while (typeid == 0 & typeid == 1);
        return typeid;
    }

    private boolean doDecisionExitOrNext() {
        Scanner scanner = new Scanner(System.in);
        int next;
        do {
            System.out.println("1. Select next\n" +
                    "0. Exit");
            next = scanner.nextInt();
        } while (next == 0 & next == 1);
        if (next == 0) {
            return true;
        }
        return false;
    }
}

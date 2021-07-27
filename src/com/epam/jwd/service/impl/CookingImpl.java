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
import com.epam.jwd.service.Cooking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class CookingImpl implements Cooking {
    private final VegetableDao vegetableDao = new VegetableDaoImpl();
    private final SaladDressingDao saladDressingDao = new SaladDressingDaoImpl();
    private Salad salad;
    private List<Vegetable> vegetableList = new ArrayList();
    private List<SaladDressing> saladDressingList = new ArrayList();
    private List<VegetableIngredient> vegetableIngredients = null;
    private List<SaladDressingIngredient> saladDressingIngredients = null;
    private Scanner scanner = new Scanner(System.in);

    public CookingImpl() {
        try {
            this.vegetableList = vegetableDao.findAll();
            this.saladDressingList = saladDressingDao.findAll();
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Salad doSalad(String saladName) {
        this.vegetableIngredients = getVegetablesForSalad();
        this.saladDressingIngredients = getSaladDressingsForSalad();
        this.salad = new Salad(saladName, this.vegetableIngredients, this.saladDressingIngredients);
        return this.salad;
    }

    @Override
    public List<Vegetable> getAllVegetables() {
        return vegetableList;
    }

    @Override
    public List<SaladDressing> getAllSaladDressings() {
        return saladDressingList;
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
    /*
    private List<VegetableIngredient> getVegetablesForSalad() {
        //имитация выбора ингридиентов
        List<VegetableIngredient> ingredients = new ArrayList();
        try {
        ingredients.add(new VegetableIngredient(vegetableDao.findById(25), 300));
        ingredients.add(new VegetableIngredient(vegetableDao.findById(24), 200));
        ingredients.add(new VegetableIngredient((vegetableDao.findById(26)), 150));
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return ingredients;
    }*/

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

    //для  выбора овощей через консоль
    private List<VegetableIngredient> getVegetablesForSalad() {
        List<Vegetable> vegetableList;
        VegetableDao vegetableDao = new VegetableDaoImpl();
        List<VegetableIngredient> vegetableIngredientList = new ArrayList<>();
        boolean state = true;
        while (state) {
            try {
                System.out.println("Choose vegetables for salad\nList of vegatable types:");
                Arrays.stream(VegetableType.values()).map(v -> v.getId() + ". " + v.name()).forEach(System.out::println);
                vegetableList = vegetableDao.findByType(VegetableType.values()[getTypeFromConsole() - 1]);
                vegetableList.stream().map(v -> v.getId() + " " + v.getName()).forEach(System.out::println);
                List<Vegetable> vegetables = vegetableDao.findById(getIdFromConsole());
                vegetables.stream().forEach(x -> vegetableIngredientList.add(new VegetableIngredient(x, getWeightFromConsole())));
                if (doDecisionExitOrNext())
                    return vegetableIngredientList;
            } catch (DaoException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    //для пропуска выбора заправки через консоль
      /* private List<SaladDressingIngredient> getSaladDressingsForSalad() {

        List<SaladDressingIngredient> saladDressings = new ArrayList();
        try {
            saladDressings.add(new SaladDressingIngredient(saladDressingDao.findById(1), 30));
            saladDressings.add(new SaladDressingIngredient(saladDressingDao.findById(5), 40));
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return saladDressings;
     }*/

    //для выбора заправки через консоль
    private List<SaladDressingIngredient> getSaladDressingsForSalad() {
        Scanner scanner = new Scanner(System.in);
        List<SaladDressing> saladDressings;
        SaladDressingDao saladDressingDao = new SaladDressingDaoImpl();
        List<SaladDressingIngredient> saladDressingIngredientList = new ArrayList();
        try {
            int saladDressingId = selectSaladDressingType();
            switch (saladDressingId) {
                case 1:
                    while (true) {
                        saladDressings = saladDressingDao.findByType(SaladDressingType.values()[saladDressingId - 1]);
                        saladDressings.stream().map(v -> v.getId() + " " + v.getName()).forEach(System.out::println);
                        List<SaladDressing> sd = saladDressingDao.findById(getIdFromConsole());
                        sd.stream().forEach(x -> saladDressingIngredientList.add(new SaladDressingIngredient(x, getWeightFromConsole())));
                        if (doDecisionExitOrNext())
                            return saladDressingIngredientList;
                    }
                case 2:
                    saladDressings = saladDressingDao.findByType(SaladDressingType.values()[saladDressingId - 1]);
                    saladDressings.stream().map(v -> v.getId() + " " + v.getName()).forEach(System.out::println);
                    List<SaladDressing> sd = saladDressingDao.findById(getIdFromConsole());
                    sd.stream().forEach(i -> saladDressingIngredientList.add(new SaladDressingIngredient(i, getWeightFromConsole())));
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
        System.out.println("Enter weight:");
        return scanner.nextInt();
    }

    private int getIdFromConsole() {
        System.out.println("Select id");
        return scanner.nextInt();
    }

    private int getTypeFromConsole() {
        System.out.println("Select type of vegetables:");
        return scanner.nextInt();
    }

    private int selectSaladDressingType() {
        System.out.println("Choose salad dressing for salad\nList of salad dressing types:");
        int typeid;
        do {
            Arrays.stream(SaladDressingType.values()).map(v -> v.getId() + ". " + v.name()).forEach(System.out::println);
            System.out.println("Select type of salad dressing:");
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

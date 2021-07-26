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
import com.epam.jwd.domain.SaladDressingTypes;
import com.epam.jwd.domain.Vegetable;
import com.epam.jwd.domain.VegetableIngredient;
import com.epam.jwd.domain.VegetableTypes;
import com.epam.jwd.service.Cooking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class CookingImpl implements Cooking {
    private Salad salad;
    private VegetableDao vegetableDao = new VegetableDaoImpl();
    private List<Vegetable> vegetableList = new ArrayList();
    private SaladDressingDao saladDressingDao = new SaladDressingDaoImpl();
    private List<SaladDressing> saladDressingList = new ArrayList();
    private List<VegetableIngredient> vegetableIngredients = null;
    private List<SaladDressingIngredient> saladDressingIngredients = null;

    public CookingImpl() {
        try {
            this.vegetableList = vegetableDao.findAll();
            this.saladDressingList = saladDressingDao.findAll();
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Salad doSalad() {
        this.vegetableIngredients = getVegetablesForSalad();
        this.saladDressingIngredients = getSaladDressingsForSalad();
        this.salad = new Salad("Salad Name", this.vegetableIngredients, this.saladDressingIngredients);
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
    public List<Vegetable> getVegetablesByType(VegetableTypes type) {
        List<Vegetable> vegetables = new ArrayList();
        try {
            vegetables = vegetableDao.findByType(type);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return vegetables;
    }

    @Override
    public List<SaladDressing> getSaladDressingsByType(SaladDressingTypes type) {
        List<SaladDressing> saladDressings = new ArrayList();
        try {
            saladDressings = saladDressingDao.findByType(type);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return saladDressings;
    }

    @Override
    public Vegetable getVegetableById(int id) {
        Vegetable vegetable = null;
        try {
            vegetable = vegetableDao.findById(id);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return vegetable;
    }

    @Override
    public SaladDressing getSaladDressingsById(int id) {
        SaladDressing saladDressing = null;
        try {
            saladDressing = saladDressingDao.findById(id);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return saladDressing;
    }

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

    private List<VegetableIngredient> getVegetablesForSalad() {
        Scanner sc = new Scanner(System.in);
        List<Vegetable> vegetableList;
        VegetableDao vegetableDao = new VegetableDaoImpl();
        List<VegetableIngredient> vegetableIngredientList = new ArrayList<>();
        boolean state = true;
        while (state) {
            try {
                System.out.println("Choose vegetables for salad");
                System.out.println("List of vegatable types:");
                Arrays.stream(VegetableTypes.values()).map(v -> v.getId() + ". " + v.name()).forEach(System.out::println);
                System.out.println("Choose type of vegetables:");
                int typeId = sc.nextInt();
                vegetableList = vegetableDao.findByType(VegetableTypes.values()[typeId - 1]);
                vegetableList.stream().map(v -> v.getId() + " " + v.getName()).forEach(System.out::println);
                System.out.println("Select id:");
                int id = sc.nextInt();
                Vegetable v = null;
                v = vegetableDao.findById(id);
                System.out.println("Enter weight:");
                int weight = sc.nextInt();
                VegetableIngredient vi = new VegetableIngredient(v, weight);
                vegetableIngredientList.add(vi);
                System.out.println(vi);
                int next;
                do {
                    System.out.println("1. Select next vegetable\n" +
                            "0. Exit");
                    next = sc.nextInt();
                } while (next == 0 & next == 1);
                if (next == 0) {
                    return vegetableIngredientList;
                }
            } catch (DaoException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

      /*private List<SaladDressingIngredient> getSaladDressingsForSalad() {

        List<SaladDressingIngredient> saladDressings = new ArrayList();
        try {
            saladDressings.add(new SaladDressingIngredient(saladDressingDao.findById(1), 30));
            saladDressings.add(new SaladDressingIngredient(saladDressingDao.findById(5), 40));
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return saladDressings;
     }*/

    private List<SaladDressingIngredient> getSaladDressingsForSalad() {
        //имитация выбора заправки
        Scanner sc = new Scanner(System.in);
        List<SaladDressing> saladDressings;
        SaladDressingDao saladDressingDao = new SaladDressingDaoImpl();
        List<SaladDressingIngredient> saladDressingIngredientList = new ArrayList();
        try {
            System.out.println("Choose salad dressing for salad");
            System.out.println("List of salad dressing types:");
            int typeid;
            do {
                Arrays.stream(SaladDressingTypes.values()).map(v -> v.getId() + ". " + v.name()).forEach(System.out::println);
                System.out.println("Choose type of salad dressing:");
                typeid = sc.nextInt();
            }
            while (typeid == 0 & typeid == 1);
            switch (typeid) {
                case 1:
                    boolean state = true;
                    while (state) {
                        saladDressings = saladDressingDao.findByType(SaladDressingTypes.values()[typeid - 1]);
                        saladDressings.stream().map(v -> v.getId() + " " + v.getName()).forEach(System.out::println);
                        System.out.println("Select id:");
                        int id = sc.nextInt();
                        SaladDressing sd = saladDressingDao.findById(id);
                        System.out.println("Enter weight:");
                        int weight = sc.nextInt();
                        SaladDressingIngredient si = new SaladDressingIngredient(sd, weight);
                        saladDressingIngredientList.add(si);
                        int next;
                        do {
                            System.out.println("1. Select next SIMPLE salad dressing\n" +
                                    "0. Exit");
                            next = sc.nextInt();
                        }
                        while (next == 0 & next == 1);
                        if (next == 0)
                            return saladDressingIngredientList;
                    }
                    break;
                case 2:
                    saladDressings = saladDressingDao.findByType(SaladDressingTypes.values()[typeid - 1]);
                    saladDressings.stream().map(v -> v.getId() + " " + v.getName()).forEach(System.out::println);
                    System.out.println("Select id:");
                    int id = sc.nextInt();
                    SaladDressing sd = saladDressingDao.findById(id);
                    System.out.println("Enter weight:");
                    int weight = sc.nextInt();
                    SaladDressingIngredient si = new SaladDressingIngredient(sd, weight);
                    saladDressingIngredientList.add(si);
                    break;
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return saladDressingIngredientList;
    }

    @Override
    public void calculateSaladEnergy(Salad salad) {
        if (salad != null) {
            double energy = salad.getSaladDressingIngredientList().stream()
                    .mapToDouble(Food::getEnergy)
                    .sum() +
                    salad.getVegetableIngredientList().stream()
                            .mapToDouble(Food::getEnergy)
                            .sum();
            System.out.println("Salad energy = " + energy + "kcal");
        }
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
    public void findVegetablesByEnergy(List<VegetableIngredient> v, double l, double h) {
        if (!v.isEmpty()) {
            System.out.println("\nTotal energy of each vegetable in salad (from " + l + "kcal to " + h + "kcal):");
            this.salad.getVegetableIngredientList()
                    .stream()
                    .sorted(Comparator.comparingDouble(Food::getEnergy))
                    .filter((x) -> x.getEnergy() >= l && x.getEnergy() <= h)
                    .forEach((p) -> System.out.println(p.getName() + " " + p.getEnergy()));
        }
    }
}

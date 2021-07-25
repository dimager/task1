

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
import com.epam.jwd.domain.Vegetable;
import com.epam.jwd.domain.VegetableIngredient;
import com.epam.jwd.service.Cooking;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CookingImpl implements Cooking {
    private Salad salad;
    private VegetableDao vegetableDao = new VegetableDaoImpl();
    private List<Vegetable> vegetableList = new ArrayList();
    private SaladDressingDao saladDressing = new SaladDressingDaoImpl();
    private List<SaladDressing> saladDressingList = new ArrayList();
    private List<VegetableIngredient> vegetableIngredients = null;
    private List<SaladDressingIngredient> saladDressingIngredients = null;

    public CookingImpl() {
        try {
            this.vegetableList = vegetableDao.findAll();
            this.saladDressingList = saladDressing.findAll();
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    public Salad doSalad() {
        this.vegetableIngredients = getVegetablesForSalad();
        this.saladDressingIngredients = getSaladDressingsForSalad();
        this.salad = new Salad("Salad Name", this.vegetableIngredients, this.saladDressingIngredients);
        return this.salad;
    }

    private List<VegetableIngredient> getVegetablesForSalad() {
        List<VegetableIngredient> ingredients = new ArrayList();
        try {
        ingredients.add(new VegetableIngredient(vegetableDao.findById(25), 300));
        ingredients.add(new VegetableIngredient(vegetableDao.findById(24), 200));
        ingredients.add(new VegetableIngredient((vegetableDao.findById(26)), 150));
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return ingredients;
    }

    private List<SaladDressingIngredient> getSaladDressingsForSalad() {
        List<SaladDressingIngredient> saladDressings = new ArrayList();
        try {
            saladDressings.add(new SaladDressingIngredient(saladDressing.findById(1), 30));
            saladDressings.add(new SaladDressingIngredient(saladDressing.findById(5), 40));
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return saladDressings;
    }

    public void calculateSaladEnergy(Salad salad) {
        if (salad != null) {
            double d = salad.getSaladDressingIngredientList().stream().mapToDouble(Food::getEnergy).sum() + salad.getVegetableIngredientList().stream().mapToDouble(Food::getEnergy).sum();
            System.out.println("Salad energy = " + d + "kcal");
        }

    }

    public void sortVegetablesByCarb(List<VegetableIngredient> v) {
        if (!v.isEmpty()) {
            System.out.println("\nVegetable salad ingredients are sorted by carbs");
            this.salad.getVegetableIngredientList().stream().sorted(Comparator.comparingDouble(Food::getCarbs)).filter((x) -> {
                return x.getCarbs() >= 0.0D;
            }).forEach((p) -> {
                System.out.println(p.getName() + " " + p.getCarbs());
            });
        }

    }

    public void findVegetablesByEnergy(List<VegetableIngredient> v, double l, double h) {
        if (!v.isEmpty()) {
            System.out.println("\nTotal energy of each vegetable in salad (from " + l + "kcal to " + h + "kcal):");
            this.salad.getVegetableIngredientList().stream().sorted(Comparator.comparingDouble(Food::getEnergy)).filter((x) -> {
                return x.getEnergy() >= l && x.getEnergy() <= h;
            }).forEach((p) -> {
                System.out.println(p.getName() + " " + p.getEnergy());
            });
        }

    }
}

package com.epam.jwd;

import com.epam.jwd.domain.Salad;
import com.epam.jwd.domain.SaladDressingType;
import com.epam.jwd.domain.VegetableType;
import com.epam.jwd.service.Cooking;
import com.epam.jwd.service.impl.CookingImpl;

public class Main {
    public static void main(String[] args) {
        Cooking cooking = new CookingImpl();
        Salad newSalad = cooking.doSalad("delicious salad");
        System.out.println(newSalad.toString());
        System.out.println("Salad total energy: " + cooking.calculateSaladEnergy(newSalad));
        cooking.sortVegetablesByCarb(newSalad.getVegetableIngredientList());
        cooking.findVegetablesByEnergy(newSalad.getVegetableIngredientList(), 30, 300);
        System.out.println(cooking.getAllVegetables());
        System.out.println(cooking.getAllSaladDressings());
        System.out.println(cooking.getVegetablesByType(VegetableType.FLOWER));
        System.out.println(cooking.getSaladDressingsByType(SaladDressingType.COMPOUND));
        System.out.println(cooking.getVegetableById(1));
        System.out.println(cooking.getSaladDressingsById(2));
    }
}

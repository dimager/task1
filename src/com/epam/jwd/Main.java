package com.epam.jwd;

import com.epam.jwd.domain.Salad;
import com.epam.jwd.domain.SaladDressingTypes;
import com.epam.jwd.domain.Vegetable;
import com.epam.jwd.domain.VegetableTypes;
import com.epam.jwd.service.Cooking;
import com.epam.jwd.service.impl.CookingImpl;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Cooking cooking = new CookingImpl();
        Salad newSalad = cooking.doSalad();
        System.out.println(newSalad.toString());
        cooking.calculateSaladEnergy(newSalad);
        cooking.sortVegetablesByCarb(newSalad.getVegetableIngredientList());
        cooking.findVegetablesByEnergy(newSalad.getVegetableIngredientList(), 30, 300);

        System.out.println(cooking.getAllVegetables());
        System.out.println(cooking.getAllSaladDressings());
        System.out.println(cooking.getVegetablesByType(VegetableTypes.FLOWER));
        System.out.println(cooking.getSaladDressingsByType(SaladDressingTypes.COMPAUND));
        System.out.println(cooking.getVegetableById(1));
        System.out.println(cooking.getSaladDressingsById(2));

    }
}

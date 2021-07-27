package com.epam.jwd;

import com.epam.jwd.domain.Salad;
import com.epam.jwd.domain.SaladDressingType;
import com.epam.jwd.domain.VegetableType;
import com.epam.jwd.service.Cook;
import com.epam.jwd.service.impl.CookImpl;

public class Main {
    public static void main(String[] args) {
        Cook cook = new CookImpl();
        Salad newSalad = cook.doSalad("delicious salad");
        System.out.println(newSalad.toString());
        System.out.println("Salad total energy: " + cook.calculateSaladEnergy(newSalad));
        cook.sortVegetablesByCarb(newSalad.getVegetableIngredientList());
        cook.findVegetablesByEnergy(newSalad.getVegetableIngredientList(), 30, 300);
        System.out.println(cook.getAllVegetables());
        System.out.println(cook.getAllSaladDressings());
        System.out.println(cook.getVegetablesByType(VegetableType.FLOWER));
        System.out.println(cook.getSaladDressingsByType(SaladDressingType.COMPOUND));
        System.out.println(cook.getVegetableById(1));
        System.out.println(cook.getSaladDressingsById(2));
    }
}

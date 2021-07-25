package com.epam.jwd;

import com.epam.jwd.domain.Salad;
import com.epam.jwd.service.Cooking;
import com.epam.jwd.service.impl.CookingImpl;

public class Main {
      public static void main(String[] args) {
        Cooking cooking = new CookingImpl();
        Salad newSalad = cooking.doSalad();
        System.out.println(newSalad.toString());
        cooking.calculateSaladEnergy(newSalad);
        cooking.sortVegetablesByCarb(newSalad.getVegetableIngredientList());
        cooking.findVegetablesByEnergy(newSalad.getVegetableIngredientList(), 30, 300);
    }
}

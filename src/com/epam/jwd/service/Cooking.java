package com.epam.jwd.service;

import com.epam.jwd.domain.*;

import java.util.List;

public interface Cooking {
    Salad doSalad();
    List<Vegetable> getAllVegetables();
    List<SaladDressing> getAllSaladDressings();
    List<Vegetable> getVegetablesByType(VegetableTypes type);
    List<SaladDressing> getSaladDressingsByType(SaladDressingTypes type);
    Vegetable getVegetableById(int id);
    SaladDressing getSaladDressingsById(int id);
    void calculateSaladEnergy(Salad salad);
    void sortVegetablesByCarb(List<VegetableIngredient> vegetableIngredients);
    void findVegetablesByEnergy(List<VegetableIngredient> vegetableIngredients, double l, double h);
}

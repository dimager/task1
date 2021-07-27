package com.epam.jwd.service;

import com.epam.jwd.domain.*;

import java.util.List;

public interface Cook {
    Salad doSalad(String saladName);
    List<Vegetable> getAllVegetables();
    List<SaladDressing> getAllSaladDressings();
    List<Vegetable> getVegetablesByType(VegetableType type);
    List<SaladDressing> getSaladDressingsByType(SaladDressingType type);
    List<Vegetable> getVegetableById(int id);
    List<SaladDressing> getSaladDressingsById(int id);
    //Посчитать калорийность.
    double calculateSaladEnergy(Salad salad);
    //Провести сортировку овощей для салата на основе одного из параметров(по углеводам).
    void sortVegetablesByCarb(List<VegetableIngredient> vegetableIngredients);
    //Найти овощи в салате, соответствующие заданному диапазону калорийности (по общей каллорийности овоща в салате).
    void findVegetablesByEnergy(List<VegetableIngredient> vegetableIngredients, double lowerLimit, double upperLimit);
}

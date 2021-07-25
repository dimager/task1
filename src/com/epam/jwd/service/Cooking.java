
package com.epam.jwd.service;

import com.epam.jwd.domain.Salad;
import com.epam.jwd.domain.VegetableIngredient;
import java.util.List;

public interface Cooking {
    Salad doSalad();

    void calculateSaladEnergy(Salad salad);

    void sortVegetablesByCarb(List<VegetableIngredient> vegetableIngredients);

    void findVegetablesByEnergy(List<VegetableIngredient> vegetableIngredients, double l, double h);
}

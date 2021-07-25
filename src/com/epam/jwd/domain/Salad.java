package com.epam.jwd.domain;

import java.util.List;

public class Salad extends Food {
    private String name;
    private List<VegetableIngredient> vegetableIngredientList;
    private List<SaladDressingIngredient> saladDressingIngredientList;
    private double fibre;

    public Salad(String name, List<VegetableIngredient> vegetableIngredientList, List<SaladDressingIngredient> saladDressingList) {
        this.name = name;
        this.vegetableIngredientList = vegetableIngredientList;
        this.saladDressingIngredientList = saladDressingList;
        this.setEnergy(this.getVegetableIngredientList().stream().mapToDouble(Food::getEnergy).sum()
                + this.getSaladDressingIngredientList().stream().mapToDouble(Food::getEnergy).sum());
        this.setProteins(this.getVegetableIngredientList().stream().mapToDouble(Food::getProteins).sum()
                + this.getSaladDressingIngredientList().stream().mapToDouble(Food::getProteins).sum());
        this.setFats(this.getVegetableIngredientList().stream().mapToDouble(Food::getFats).sum()
                + this.getSaladDressingIngredientList().stream().mapToDouble(Food::getFats).sum());
        this.setCarbs(this.getVegetableIngredientList().stream().mapToDouble(Food::getCarbs).sum()
                + this.getSaladDressingIngredientList().stream().mapToDouble(Food::getCarbs).sum());
        this.setFibre(this.getVegetableIngredientList().stream().mapToDouble(Vegetable::getFibre).sum());
    }

    public double getFibre() {
        return this.fibre;
    }

    public void setFibre(double fibre) {
        this.fibre = fibre;
    }

    public List<VegetableIngredient> getVegetableIngredientList() {
        return this.vegetableIngredientList;
    }

    public List<SaladDressingIngredient> getSaladDressingIngredientList() {
        return this.saladDressingIngredientList;
    }

    public String toString() {
        return "Salad{name='" + this.name + '\'' +
                ", proteins=" + this.proteins +
                ", fats=" + this.fats +
                ", carbs=" + this.carbs +
                ", energy=" + this.energy +
                ", fibre=" + this.fibre + '}';
    }
}

package com.epam.jwd.domain;


import java.util.List;
import java.util.stream.Collectors;

public class Salad extends Food {
    private String name;
    private List<VegetableIngredient> vegetableIngredientList;
    private List<SaladDressingIngredient> saladDressingIngredientList;
    private double fibre;
    private double weight;

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
        this.setWeight(this.getVegetableIngredientList().stream().mapToDouble(VegetableIngredient::getWeight).sum()
                + this.getSaladDressingIngredientList().stream().mapToDouble(SaladDressingIngredient::getWeight).sum());

    }

    public List<VegetableIngredient> getVegetableIngredientList() {
        return this.vegetableIngredientList;
    }

    public List<SaladDressingIngredient> getSaladDressingIngredientList() {
        return this.saladDressingIngredientList;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getFibre() {
        return this.fibre;
    }

    public void setFibre(double fibre) {
        this.fibre = fibre;
    }


    public String toString() {
        return "Salad\n" +
                "name = " + name + "\n" +
                "weight = " + String.format("%.2f",weight) + "g\n" +
                "Total: " +
                "proteins = " + String.format("%.2f",proteins) + "g\n" +
                "fats = " + String.format("%.2f",fats) + "g\n" +
                "carbs = " + String.format("%.2f",carbs) + "g\n"+
                "energy = " + String.format("%.2f",energy) +  "kcal\n"+
                "fibre = " + String.format("%.2f",fibre)  + "g\n\n" +
                "Per 100 gramm:\n"+
                "proteins = " + String.format("%.2f",convertTo100(proteins,weight)) + "g\n" +
                "fats = " + String.format("%.2f",convertTo100(fats,weight)) + "g\n" +
                "carbs = " + String.format("%.2f",convertTo100(carbs,weight)) + "g\n"+
                "energy = " + String.format("%.2f",convertTo100(energy,weight)) +  "kcal\n"+
                "fibre = " + String.format("%.2f",convertTo100(fibre,weight))  + "g\n\n" +
                "Salad Ingredients\n " +
                "-Vegetable:\n" +
                getVegetableIngredientList().stream()
                        .map(p -> p.getName() + " " + p.getWeight()+"g.\n" )
                        .collect(Collectors.joining())+
                "-Salad Dressing:\n" +
                getSaladDressingIngredientList().stream()
                        .map(p -> p.getName() + " " + p.getWeight()+"g.\n" )
                        .collect(Collectors.joining());
    }
    private double convertTo100(double param, double weight){
        return param*100/weight;
    }

}

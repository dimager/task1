

package com.epam.jwd.domain;

public class Vegetable extends Food {
    private int id;
    private String name;
    private VegetableTypes vegetableType;
    private Double fibre;

    public Vegetable() {
    }

    public Vegetable(double proteins, double fats, double carbs, double fibre, String name, VegetableTypes vegetableType) {
        super(proteins, fats, carbs);
        this.name = name;
        this.vegetableType = vegetableType;
        this.fibre = fibre;
    }

    public Vegetable(double proteins, double fats, double carbs, double energy, double fibre, String name, VegetableTypes vegetableType) {
        super(proteins, fats, carbs, energy);
        this.name = name;
        this.vegetableType = vegetableType;
        this.fibre = fibre;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VegetableTypes getVegetableType() {
        return this.vegetableType;
    }

    public void setVegetableType(VegetableTypes vegetableTypes) {
        this.vegetableType = vegetableTypes;
    }

    public Double getFibre() {
        return this.fibre;
    }

    public void setFibre(Double fibre) {
        this.fibre = fibre;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString() {
        return " id = " + this.id +
                ", name = '" + this.name + '\'' +
                ", type = " + this.vegetableType +
                ", proteins = " + String.format("%.2f",getProteins()) +
                ", fats = " + String.format("%.2f",getFats()) +
                ", carbs = " + String.format("%.2f",getCarbs()) +
                ", energy = " + String.format("%.2f",getEnergy()) +
                ", fibre = " + String.format("%.2f",getFibre())+"\n";
    }


}

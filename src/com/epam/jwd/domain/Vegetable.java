

package com.epam.jwd.domain;

public class Vegetable extends Food {
    private int id;
    private String name;
    private VegetableTypes vegetableTypes;
    private Double fibre;

    public Vegetable() {
    }

    public Vegetable(double proteins, double fats, double carbs, double fibre, String name, VegetableTypes vegetableTypes) {
        super(proteins, fats, carbs);
        this.name = name;
        this.vegetableTypes = vegetableTypes;
        this.fibre = fibre;
    }

    public Vegetable(double proteins, double fats, double carbs, double energy, double fibre, String name, VegetableTypes vegetableTypes) {
        super(proteins, fats, carbs, energy);
        this.name = name;
        this.vegetableTypes = vegetableTypes;
        this.fibre = fibre;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VegetableTypes getVegetableTypes() {
        return this.vegetableTypes;
    }

    public void setVegetableTypes(VegetableTypes vegetableTypes) {
        this.vegetableTypes = vegetableTypes;
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
        return "Vegetable{id=" + this.id +
                " name='" + this.name + '\'' +
                " proteins=" + this.proteins +
                " vegetableTypes=" + this.vegetableTypes +
                " fats=" + this.fats + " carbs=" + this.carbs +
                " energy=" + this.energy +
                " fibre=" + this.fibre + '}' + "\n";
    }


}

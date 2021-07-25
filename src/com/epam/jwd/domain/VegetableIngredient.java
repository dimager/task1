//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.epam.jwd.domain;

public class VegetableIngredient extends Vegetable {
    private double weight;

    public VegetableIngredient(Vegetable v, double weight) {
        this.weight = weight;
        this.setName(v.getName());
        this.setId(v.getId());
        this.setVegetableType(v.getVegetableType());
        this.setProteins(calculateWithWeight(v.getProteins(), weight));
        this.setFats(calculateWithWeight(v.getFats(), weight));
        this.setCarbs(calculateWithWeight(v.getCarbs(), weight));
        this.setEnergy(calculateWithWeight(v.getEnergy(), weight));
        this.setFibre(calculateWithWeight(v.getFibre(), weight));
    }

    public double getWeight() {
        return weight;
    }

    public String toString() {
        return super.toString() + " weight = " + this.weight;
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}

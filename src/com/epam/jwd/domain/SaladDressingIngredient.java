

package com.epam.jwd.domain;

public class SaladDressingIngredient extends SaladDressing {
    private double weight;

    public SaladDressingIngredient(SaladDressing saladDressing, double weight) {
        this.setWeight(weight);
        this.setName(saladDressing.getName());
        this.setEnergy(calculateWithWeight(saladDressing.getEnergy(), weight));
        this.setCarbs(calculateWithWeight(saladDressing.getCarbs(), weight));
        this.setFats(calculateWithWeight(saladDressing.getFats(), weight));
        this.setProteins(calculateWithWeight(saladDressing.getProteins(), weight));
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String toString() {
        return super.toString() + "weight=" + this.weight;
    }
}

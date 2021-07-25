

package com.epam.jwd.domain;

public class SaladDressingIngredient extends SaladDressing {
    private double weight;

    public SaladDressingIngredient(SaladDressing s, double weight) {
        this.weight = weight;
        this.setEnergy(calculateWithWeight(s.energy, weight));
        this.setCarbs(calculateWithWeight(s.carbs, weight));
        this.setFats(calculateWithWeight(s.fats, weight));
        this.setProteins(calculateWithWeight(s.proteins, weight));
    }

    public String toString() {
        return super.toString() + "weight=" + this.weight;
    }
}

package com.epam.jwd.domain;

import com.epam.jwd.service.Calculator;

public class VegetableIngredient extends Vegetable {
    private double weight;

    public VegetableIngredient(Vegetable v, double weight) {
        this.weight = weight;
        this.setName(v.getName());
        this.setId(v.getId());
        this.setVegetableType(v.getVegetableType());
        this.setProteins(Calculator.calculateWithWeight(v.getProteins(), weight));
        this.setFats(Calculator.calculateWithWeight(v.getFats(), weight));
        this.setCarbs(Calculator.calculateWithWeight(v.getCarbs(), weight));
        this.setEnergy(Calculator.calculateWithWeight(v.getEnergy(), weight));
        this.setFibre(Calculator.calculateWithWeight(v.getFibre(), weight));
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        VegetableIngredient that = (VegetableIngredient) o;
        return Double.compare(that.weight, weight) == 0;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(weight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + " weight = " + this.weight;
    }
}

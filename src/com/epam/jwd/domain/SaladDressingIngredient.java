package com.epam.jwd.domain;

import com.epam.jwd.service.Calculator;
import com.epam.jwd.service.Dao;

public class SaladDressingIngredient extends SaladDressing {
    private double weight;

    public SaladDressingIngredient(SaladDressing saladDressing, double weight) {
        this.setWeight(weight);
        this.setName(saladDressing.getName());
        this.setEnergy(Calculator.calculateWithWeight(saladDressing.getEnergy(), weight));
        this.setCarbs(Calculator.calculateWithWeight(saladDressing.getCarbs(), weight));
        this.setFats(Calculator.calculateWithWeight(saladDressing.getFats(), weight));
        this.setProteins(Calculator.calculateWithWeight(saladDressing.getProteins(), weight));
    }


    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return super.toString() + "weight=" + this.weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SaladDressingIngredient that = (SaladDressingIngredient) o;
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
}

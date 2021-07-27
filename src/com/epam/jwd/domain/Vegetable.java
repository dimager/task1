package com.epam.jwd.domain;

public class Vegetable extends Food {
    private int id;
    private VegetableType vegetableType;
    private Double fibre;

    public void setVegetableType(VegetableType vegetableType) {
        this.vegetableType = vegetableType;
    }

    public VegetableType getVegetableType() {
        return this.vegetableType;
    }

    public void setFibre(Double fibre) {
        this.fibre = fibre;
    }

    public Double getFibre() {
        return this.fibre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return " id = " + this.id +
                ", name = '" + getName() + '\'' +
                ", type = " + this.vegetableType +
                ", proteins = " + String.format("%.2f",getProteins()) +
                ", fats = " + String.format("%.2f",getFats()) +
                ", carbs = " + String.format("%.2f",getCarbs()) +
                ", energy = " + String.format("%.2f",getEnergy()) +
                ", fibre = " + String.format("%.2f",getFibre())+"\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Vegetable vegetable = (Vegetable) o;
        if (id != vegetable.id) return false;
        if (vegetableType != vegetable.vegetableType) return false;
        return fibre.equals(vegetable.fibre);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + id;
        result = 31 * result + vegetableType.hashCode();
        result = 31 * result + fibre.hashCode();
        return result;
    }
}

package com.epam.jwd.domain;

public  class Food  {
    private String name;
    private double proteins;
    private double fats;
    private double carbs;
    private double energy;

    public double getProteins() {
        return this.proteins;
    }

    public void setProteins(double proteins) {
        this.proteins = proteins;
    }

    public double getFats() {
        return this.fats;
    }

    public void setFats(double fats) {
        this.fats = fats;
    }

    public double getCarbs() {
        return this.carbs;
    }

    public void setCarbs(double carbs) {
        this.carbs = carbs;
    }

    public double getEnergy() {
        return this.energy;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Food food = (Food) o;
        if (Double.compare(food.proteins, proteins) != 0) return false;
        if (Double.compare(food.fats, fats) != 0) return false;
        if (Double.compare(food.carbs, carbs) != 0) return false;
        if (Double.compare(food.energy, energy) != 0) return false;
        return name.equals(food.name);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        temp = Double.doubleToLongBits(proteins);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(fats);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(carbs);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(energy);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Food{" +
                "proteins=" + proteins +
                ", fats=" + fats +
                ", carbs=" + carbs +
                ", energy=" + energy +
                '}';
    }
}

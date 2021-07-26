package com.epam.jwd.domain;

public  class Food  {
    private double proteins;
    private double fats;
    private double carbs;
    private double energy;

    public Food(double proteins, double fats, double carbs) {
        this.proteins = proteins;
        this.fats = fats;
        this.carbs = carbs;
        this.energy = calculateEnergy(proteins, fats, carbs);
    }

    public Food(double proteins, double fats, double carbs, double energy) {
        this.proteins = proteins;
        this.fats = fats;
        this.carbs = carbs;
        this.energy = energy;
    }

    public Food() {
    }

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

    private double calculateEnergy(double proteins, double fats, double carbs) {
        return proteins * 4 + fats * 9 + carbs * 4;
    }

    public static double calculateWithWeight(double param, double weight) {
        return param * weight / 100;
    }
}

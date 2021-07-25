package com.epam.jwd.domain;

public class SaladDressing extends Food {
    private int id;
    private String name;
    private SaladDressingTypes saladDressingTypes;

    public SaladDressing() {
    }

    public SaladDressing(double proteins, double fats, double carbs, String name, SaladDressingTypes saladDressingTypes) {
        super(proteins, fats, carbs);
        this.name = name;
        this.saladDressingTypes = saladDressingTypes;
    }

    public SaladDressing(double proteins, double fats, double carbs, double energy, String name, SaladDressingTypes saladDressingTypes) {
        super(proteins, fats, carbs, energy);
        this.name = name;
        this.saladDressingTypes = saladDressingTypes;
    }

    public SaladDressing(SaladDressing s) {
        this.setId(s.getId());
        this.setName(s.getName());
        this.setSaladDressingTypes(s.saladDressingTypes);
        this.setProteins(s.getProteins());
        this.setFats(s.getFats());
        this.setCarbs(s.getCarbs());
        this.setEnergy(s.getEnergy());
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SaladDressingTypes getSaladDressingTypes() {
        return this.saladDressingTypes;
    }

    public void setSaladDressingTypes(SaladDressingTypes saladDressingTypes) {
        this.saladDressingTypes = saladDressingTypes;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString() {
        return "SaladDressing{id=" + this.id + " name='" + this.name + '\'' + " saladDressingTypes=" + this.saladDressingTypes + " proteins=" + this.proteins + " fats=" + this.fats + " carbs=" + this.carbs + " energy=" + this.energy + '}' + "\n";
    }
}

package com.epam.jwd.domain;

public class SaladDressing extends Food {
    private int id;
    private SaladDressingType saladDressingType;

    public SaladDressingType getSaladDressingTypes() {
        return this.saladDressingType;
    }

    public void setSaladDressingTypes(SaladDressingType saladDressingType) {
        this.saladDressingType = saladDressingType;
    }

    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return " id = " + this.id +
                ", name = '" + getName() + '\'' +
                ", type = " + this.saladDressingType +
                ", proteins = " + getProteins() +
                ", fats = " + getFats() +
                ", carbs = " + getCarbs() +
                ", energy = " + getEnergy()  + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SaladDressing that = (SaladDressing) o;
        if (id != that.id) return false;
        return saladDressingType == that.saladDressingType;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + id;
        result = 31 * result + saladDressingType.hashCode();
        return result;
    }
}

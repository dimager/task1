package com.epam.jwd.domain;

public enum SaladDressingType {
    SIMPLE(1),
    COMPAUND(2);
    private int id;
    SaladDressingType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

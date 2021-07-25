

package com.epam.jwd.domain;

public enum SaladDressingTypes {
    SIMPLE(1),
    COMPAUND(2);

    int id;

    SaladDressingTypes(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

}

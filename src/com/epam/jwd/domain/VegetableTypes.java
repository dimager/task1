
package com.epam.jwd.domain;

public enum VegetableTypes {
    FLOWER(1),
    LEAFY(2),
    TUBER(3),
    ROOT(4),
    BULB(5),
    STEM(6),
    FRUIT(7),
    POD(8);

    int id;

    public int getId() {
        return id;
    }

    VegetableTypes(int id) {
        this.id = id;
    }

}

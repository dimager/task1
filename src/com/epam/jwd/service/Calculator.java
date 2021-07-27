package com.epam.jwd.service;

public interface Calculator {
    static double convertTo100(double param, double weight){
        return param*100/weight;
    }
    static double calculateWithWeight(double param, double weight) {
        return param * weight / 100;
    }
}

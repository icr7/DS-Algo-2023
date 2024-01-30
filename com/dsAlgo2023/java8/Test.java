package com.dsAlgo2023.java8;

public class Test {

    public static void main(String[] args){
        MyCar car= Car::new;
        System.out.println(car.getCar(111,"creta"));
    }

}

interface MyCar{
    Car getCar(int model, String name);
}

class Car{
    int model;
    String name;

    public Car(int model, String name) {
        this.model = model;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model=" + model +
                ", name='" + name + '\'' +
                '}';
    }
}
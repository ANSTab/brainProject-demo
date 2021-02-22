package com.tabachenko.test2Brain;

public class ComponentComp {
        private String name;
        private double price;

    @Override
    public String toString() {
        return "ComponentComp{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ComponentComp(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

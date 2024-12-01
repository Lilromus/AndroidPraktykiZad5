package com.example.zad5;

public class Produkt {
    private final String name;
    private final String price;

    public Produkt(String name, String price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }
}

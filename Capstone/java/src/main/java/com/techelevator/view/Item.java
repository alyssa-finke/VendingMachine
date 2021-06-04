package com.techelevator.view;

public class Item {
    private String name;
    private double price;
    private String type;
    private int quantity = 5;
    private String slotNumber;
    //should quantity be static/constant?


    public Item(String name, double price, String type, int quantity) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public int getQuantity() {
        return quantity;
    }
}


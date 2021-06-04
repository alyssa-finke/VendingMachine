package com.techelevator.view;

public class Drink extends Item {
    public Drink(String name, double price, String type, int quantity) {
        super(name, price, type, quantity);
    }
//make an abstract getSound
    @Override
    public String getSound() {
        return "Glug Glug Yum";
    }
}

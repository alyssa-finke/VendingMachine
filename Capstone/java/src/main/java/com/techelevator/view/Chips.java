package com.techelevator.view;

public class Chips extends Item implements Sound{
    public Chips(String name, double price, String type, int quantity) {
        super(name, price, type, quantity);
    }
    //make an abstract getSound
    @Override
    public String getSound() {
        return "Crunch Crunch Yum";
    }
}

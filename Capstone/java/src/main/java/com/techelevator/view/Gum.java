package com.techelevator.view;

public class Gum extends Item implements Sound{

    public Gum(String name, double price, String type, int quantity) {
        super(name, price, type, quantity);
    }
    //make an abstract getSound
    @Override
    public String getSound() {
        return "Chew Chew Yum";
    }
}

package com.techelevator.view;

public class Candy extends Item implements Sound{
    public Candy(String name, double price, String type, int quantity) {
        super(name, price, type, quantity);
    }
    //make an abstract getSound
    @Override
    public String getSound() {
        return "Munch Munch Yum";
    }
}

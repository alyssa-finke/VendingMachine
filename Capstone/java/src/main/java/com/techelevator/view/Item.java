package com.techelevator.view;

public abstract class Item  implements  Sound{
    private String name;
    private double price;
    private String type;
    private int quantity = 5; //auto sets to five each time vending machine is started
    private String slotNumber;


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

    public abstract String getSound(); // created abstract in order to implement various "sound" of each item type

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}


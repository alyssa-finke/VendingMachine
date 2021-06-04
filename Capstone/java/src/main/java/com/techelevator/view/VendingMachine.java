package com.techelevator.view;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.techelevator.view.Item;

public class VendingMachine {
    private Map<String, Item> snackItem = new TreeMap<>();
    private double balance = 0;

    public VendingMachine() {

        Scanner scanner = new Scanner(System.in);
        File inventoryDataFile = new File("inventory.txt");

        try {
            Scanner inventoryDataInput = new Scanner(inventoryDataFile);
            while (inventoryDataInput.hasNext()) {
                String inventoryLine = inventoryDataInput.nextLine();
                String parts[] = inventoryLine.split("\\|");
                String slotNumber = parts[0];
                String snackName = parts[1];
                String snackPrice = parts[2];
                String snackType = parts[3];

                Item item = new Item(snackName, Double.parseDouble(snackPrice), snackType, 5);
                snackItem.put(slotNumber, item);
            }
        } catch (IOException error) {
            System.err.println("Can not open file");
        }
    }
// getters and setters
    public Map<String, Item> getSnackItem() { //getter for snackItem map
        return snackItem;
    } //getter for snackItem


    public double getBalance() { //getter for balance
        return balance;
    } //getter for balance

    public Item getItemAtSlotNumber(String slotNumber){
        Item chosenOne = snackItem.get(slotNumber);
       return chosenOne;

    }

    public void setBalance(double balance) { //setter for balance
        this.balance = balance;
    } //setter for balance


}



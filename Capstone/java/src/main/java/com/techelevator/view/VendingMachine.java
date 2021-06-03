package com.techelevator.view;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class VendingMachine {
    private Map<String, Item> snackItem = new TreeMap<>();

    public VendingMachine(Map<String, Item> snackItem) {
        this.snackItem = snackItem;
    }

    public Map<String, Item> getSnackItem() {
        return snackItem;
    }

    public void readInFile() {
        File inventoryDataFile = new File("inventory.txt");

        try (

                Scanner inventoryDataInput = new Scanner(inventoryDataFile)
        ) {
            while (inventoryDataInput.hasNext()) {
                String inventoryLine = inventoryDataInput.nextLine();
                String parts[] = inventoryLine.split("\\|");
                String slotNumber = parts[0].trim();
                String snackName = parts[1].trim();
                String snackPrice = parts[2].trim();
                String snackType = parts[3].trim();
                String snackQuantity = parts[4].trim();

                Item item = new Item(snackName, Double.parseDouble(snackPrice), snackType, Integer.parseInt(snackQuantity), slotNumber);
                snackItem.put(slotNumber, item);
                System.out.print(snackItem);
            }

        } catch (FileNotFoundException ex) {
            System.err.println("Can not open file");
        }


    }

}

//create constructor for vending machine
//call the method from the constructor
//have a getter for vending machine items
//in application have vending machine object that calls vending machine items


//Setter for variable quantity?
//Make a method that sets


//vending machine should have inventory
//then have the object in the application
//have a method in vending machine to get inventory

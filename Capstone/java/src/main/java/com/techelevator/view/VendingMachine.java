package com.techelevator.view;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.techelevator.view.Item;
//create instance variables
public class VendingMachine {
    private Map<String, Item> snackItem = new TreeMap<>();
    private double balance = 0;
    private double valueOfDollar = 1.00;
    private double valueOfQuarter = 0.25;
    private double valueOfDime = 0.10;
    private double valueOfNickel = 0.05;
    private int numberOfDollars;
    private int numberOfQuarters;
    private int numberOfDimes;
    private int numberOfNickels;

    public VendingMachine() {
//create scanner to read through file
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
//in order to implement the sound for each snackType, created a new item and a series of if-else statements to call each
// Item item = new Item(snackName, Double.parseDouble(snackPrice), snackType, 5,); - this was the original item before implementing get sound for item types
                Item item = null;
                if (snackType.equals("Chip")) {
                    item = new Chips(snackName, Double.parseDouble(snackPrice), "", 5);
                } else if (snackType.equals("Drink")) {
                    item = new Drink(snackName, Double.parseDouble(snackPrice), "", 5);
                } else if (snackType.equals("Candy")) {
                    item = new Candy(snackName, Double.parseDouble(snackPrice), "", 5);
                } else if (snackType.equals("Gum")) {
                    item = new Gum(snackName, Double.parseDouble(snackPrice), "", 5);
                }
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

    public Item getItemAtSlotNumber(String slotNumber) {
        Item chosenOne = snackItem.get(slotNumber);
        return chosenOne;
    }

    public void setBalance(double balance) { //setter for balance
        this.balance = balance;
    } //setter for balance

    public String purchaseItem(String userSelection) { // create String for handling balance and choosing snackItem
        Item chosenOne = snackItem.get(userSelection);
        if (chosenOne == null) {
            return "Selection Invalid. Please Try Again"; //if item selection via slotNumber is invalid, return null
        } else if (getSnackItem().containsKey(userSelection)) {
            if (balance < chosenOne.getPrice()) { //if balance is less than the chosen item's price, return insufficent funds
                return "Insufficient funds";
            } else { //if everything is good to go, "dispense" the item by removing the price from balance and 1 from item's quantity amount
                balance -= chosenOne.getPrice();
                chosenOne.setQuantity(chosenOne.getQuantity() - 1);
            }
        }
        return chosenOne.getSound();
    }

    public String returnChange(double endBalance) { // if there is a remaining balance when transaction is done, need to return change
        if (balance > 0) {  //created variables for different currencies and using the values of each, deducted respective amounts from remaining balance until balance is zero
            while (balance >= valueOfDollar) {
                numberOfDollars++;  //add how many of each currency is needed to bring balance to zero
                balance -= valueOfDollar;
            }
            while (balance >= valueOfQuarter) {
                numberOfQuarters++;
                balance -= valueOfQuarter;
            }
            while (balance >= valueOfDime) {
                numberOfDimes++;
                balance -= valueOfDime;
            }
            while (balance >= valueOfNickel) {
                numberOfNickels++;
                balance -= valueOfNickel;
            }
        }
        return "Your change is: " + numberOfDollars + " Dollar(s) " + numberOfQuarters + " Quarter(s) " + numberOfDimes + " Dime(s) " + numberOfNickels + " Nickel(s)";
    }
}



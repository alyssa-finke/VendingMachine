package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import com.techelevator.view.Item;

public class VendingMachine {

        private Map<String, Item> snackItem = new TreeMap<>();

        public VendingMachine() {
           // this.snackItem = snackItem;
        }

        public Map<String, Item> getSnackItem () {
            return snackItem;
        }

        public void addItem(String key,Item item){
            snackItem.put(key,item);
        }

       public void displayItems() {
            for (Map.Entry<String,Item> entry : snackItem.entrySet()) {
                Item item = entry.getValue();
                int quantity = item.getQuantity();
                System.out.print(entry.getKey() + ": " + item.getName());
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

//have a balance here for customer money
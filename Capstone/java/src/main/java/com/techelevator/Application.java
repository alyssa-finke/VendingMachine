package com.techelevator;

import com.sun.jdi.ObjectReference;
import com.techelevator.view.Item;
import com.techelevator.view.MenuDrivenCLI;
import com.techelevator.view.VendingMachine;
import com.techelevator.view.Item;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Application {

    private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
    private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE};
    private static String DEPOSIT_MONEY_INTO_MACHINE = "Deposit Money Into Vending Machine";
    private static String SELECT_ITEM_TO_PURCHASE = "Purchase An Item";
    private static String END_TRANSACTION = "End Transaction";
    private static String[] PURCHASE_ITEM_MENU = {DEPOSIT_MONEY_INTO_MACHINE, SELECT_ITEM_TO_PURCHASE, END_TRANSACTION};
//created new string and array to hold them in order to create new purchase map to interact with
    private final MenuDrivenCLI ui = new MenuDrivenCLI();
    private VendingMachine vendingMachine = new VendingMachine();
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Application application = new Application();
        application.run();
    }

    public Application() {
    }

    public void run() {

        while (true) {
            String selection = ui.promptForSelection(MAIN_MENU_OPTIONS);

            if (selection.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) { //option 1, display list of items with slot number, name, and price

                for (Map.Entry<String, Item> entry : vendingMachine.getSnackItem().entrySet()) {
                    Item item = entry.getValue();
                    int quantity = item.getQuantity();
                    System.out.println(entry.getKey() + ": " + item.getName() + " : " + item.getPrice());
                }
//pulling from vending machine, display the available snack items for purchase with slot numbers(getKey), item name, and price
            } else if (selection.equals(MAIN_MENU_OPTION_PURCHASE)) {
                // Get user input (Deposit, Purchase, Refund) ui.promptForSelection(String[] purchaseOptions)
                while (true) { //while  true keeps user in purchase menu instead of returning to main menu each time
                    String newSelection = ui.promptForSelection(PURCHASE_ITEM_MENU);

                    if (newSelection.equals(DEPOSIT_MONEY_INTO_MACHINE)) {//first option to deposit money into vending machine

                        System.out.println("Please deposit money");//prompt to deposit money
                        String moneyInput = scanner.nextLine();
                        double newBalance = Double.parseDouble(moneyInput); //+vendingMachine.getBalance();
                        vendingMachine.setBalance(newBalance); //sets balance to the entered amount of money

                    } else if (newSelection.equals(SELECT_ITEM_TO_PURCHASE)) {

                        //prompt customer to select item and display items
                        for (Map.Entry<String, Item> entry : vendingMachine.getSnackItem().entrySet()) {
                            Item item = entry.getValue();
                            int quantity = item.getQuantity();
                            System.out.println(entry.getKey() + ": " + item.getName() + " : " + item.getPrice());
                        }
                        System.out.println("Please select item slotNumber");
                        String userSelection = scanner.nextLine();//select chosen item's slot number

                        String result = vendingMachine.purchaseItem(userSelection);
                        System.out.print(result); //pulls balance and quantity and item transaction from VendingMachine
                    } else if (newSelection.equals(END_TRANSACTION)) {
                        String result = vendingMachine.returnChange(vendingMachine.getBalance());
                        System.out.println(result); //returns the change transaction from VendingMachine
                        System.out.println("Thank You. Have A Nice Day!");
                    }
                } // this ends the purchase menu while loop
                // String[] purchaseOptions = {"", ""};
            } //  this ends option two
        } // this ends the main menu while loop
    }

}

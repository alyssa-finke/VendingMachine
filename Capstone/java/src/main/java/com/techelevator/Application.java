package com.techelevator;

import com.sun.jdi.ObjectReference;
import com.techelevator.view.Item;
import com.techelevator.view.MenuDrivenCLI;
import com.techelevator.view.VendingMachine;

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
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE };

	private final MenuDrivenCLI ui = new MenuDrivenCLI();

	public static void main(String[] args) {
		Application application = new Application();
		application.run();
	}

	public Application() {
	}

	public void run() {
		VendingMachine vendingMachine = new VendingMachine();
		while (true) {
			String selection = ui.promptForSelection(MAIN_MENU_OPTIONS);

			if (selection.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// Read Inventory File
				File inventoryDataFile = new File("inventory.txt");
				// Create Array of Items
				// Add Items to Vending Machine
				try {
					Scanner inventoryDataInput = new Scanner(inventoryDataFile);
					while (inventoryDataInput.hasNext()) {
						String inventoryLine = inventoryDataInput.nextLine();
						String parts[] = inventoryLine.split("\\|");
						String slotNumber = parts[0];
						String snackName = parts[1];
						String snackPrice = parts[2];
						String snackType = parts[3];
						String snackQuantity = parts[4];

						Item item = new Item(snackName, Double.parseDouble(snackPrice), snackType, Integer.parseInt(snackQuantity));
						vendingMachine.addItem(slotNumber, item);
					}

				} catch (FileNotFoundException ex) {
					System.err.println("Can not open file");
				}

				// Display vending machine items
				vendingMachine.displayItems();
			} else if (selection.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// Get user input (Deposit, Purchase, Refund) ui.promptForSelection(String[] purchaseOptions)

				String[] purchaseOptions  = { "", "" };
				//String purchaseSelection = ui.promptForSelection();

				/*
				If (deposit)
					Ask user for amount to deposit (Not want to use ui.promptForSelection)
					Convert amount to Integer
					Add money to vending machine balance
					Show new balance
				else if (purchase)
					Check user balance
					if (user balance is empty)
						show error message
					else
						Optional: Display vending machine items
						Ask user for input. Obtain item location (A1, A2, A3, etc.)
						Get Item from vending machine
						Subtract cost from balance
						Subtract item from quantity
						Check Item type
						Print item eating sounds based on item type
				else if (refund)
					Convert vending machine balance to coins
					Display refund amount
				 */
			}
		}
	}


}
//in application have vending machine object that calls vending machine items

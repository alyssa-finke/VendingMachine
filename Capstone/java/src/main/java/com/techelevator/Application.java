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
	private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE};

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

			} else if (selection.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// Get user input (Deposit, Purchase, Refund) ui.promptForSelection(String[] purchaseOptions)

				//prompt for feed money
				System.out.println("Please deposit money");
				String moneyInput = scanner.nextLine();
				double newBalance = Double.parseDouble(moneyInput); //+vendingMachine.getBalance();
				vendingMachine.setBalance(newBalance);


				String[] purchaseOptions = {"", ""};
			}
		}
	}


}
//in application have vending machine object that calls vending machine items

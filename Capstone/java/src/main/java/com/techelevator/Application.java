package com.techelevator;

import com.techelevator.view.MenuDrivenCLI;

import java.io.File;
import java.nio.file.Files;
import java.util.List;
import java.util.Scanner;
import com.techelevator.view.VendingMachine;

public class Application {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE };

	private final MenuDrivenCLI ui = new MenuDrivenCLI();

	public static void main(String[] args) {
		Application application = new Application();
		application.run();
	}

//	public void test(){
//		System.out.print(snackItem);
//	}

	public void run() {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			String selection = ui.promptForSelection(MAIN_MENU_OPTIONS);

			if (selection.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
			} else if (selection.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
			}
		}
	}


}
//in application have vending machine object that calls vending machine items

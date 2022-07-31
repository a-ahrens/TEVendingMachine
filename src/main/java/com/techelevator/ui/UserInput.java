package com.techelevator.ui;

import com.techelevator.application.AuditLogger;
import com.techelevator.application.VendingMachine;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Responsibilities: This class should handle receiving ALL input from the User
 *
 * Dependencies: None
 */
public class UserInput {

    private Scanner scanner = new Scanner(System.in);

    public String getHomeScreenOption() {
        System.out.println("What would you like to do?");
        System.out.println();

        System.out.println("D) Display Items");
        System.out.println("P) Purchase");
        System.out.println("E) Exit");

        System.out.println();
        System.out.print("Please select an option: ");

        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toLowerCase();
        System.out.println();

        if (option.equals("d")) {
            return "display";
        }
        else if (option.equals("p")) {
            return "purchase";
        }
        else if (option.equals("e")) {
            return "exit";
        }
        else {
            return "";
        }
    }

    public String getPurchasingScreenInput() {

        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toLowerCase();
        System.out.println();

        if (option.equals("m")) {
            return "feed";
        }
        else if (option.equals("s")) {
            return "select";
        }
        else if (option.equals("f")) {
            return "finish";
        }
        else {
            return "";
        }
    }

    public int inputFeedAmount(){
        System.out.print("Machine takes 1, 5, 10, and 20 dollar bills. Please insert one at a time.");
        System.out.println("If you are done adding money, enter 0: ");

        int bill = Integer.parseInt(scanner.nextLine());

        return bill;
    }

    public String selectProduct(){
        System.out.print("\nPlease select an item: ");

        String selectedOption = scanner.nextLine();
        String item = selectedOption.trim().toUpperCase();
        System.out.println("You selected = " + item);

        return item;
    }

}


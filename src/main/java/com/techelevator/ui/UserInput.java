package com.techelevator.ui;

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
        System.out.println("option = " + option);

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

    public String getPurchasingScreenOptions() {
        System.out.println("What would you like to do?");
        System.out.println();

        System.out.println("M) Feed Money");
        System.out.println("S) Select Item");
        System.out.println("F) Finish Transaction");
        System.out.println();
        System.out.println("Current money provided");
        System.out.println();
        System.out.print("Please select an option: ");

        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toLowerCase();
        System.out.println("option = " + option);

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

    public BigDecimal feedBill(){
        //BigDecimal intToBigDecimal;
        System.out.println("Machine takes 1, 5, 10, and 20 dollar bills. Please insert one at a time.");
        int bill = Integer.parseInt(scanner.nextLine());
        if(bill == 1 || bill == 5 || bill == 10 || bill == 20) {
           BigDecimal intToBigDecimal =  BigDecimal.valueOf(bill);
            return intToBigDecimal;
        }
        return new BigDecimal(0);
    }
}


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
    AuditLogger auditLogger = new AuditLogger();
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

    public String getPurchasingScreenOptions(BigDecimal currentBalance) {
        System.out.println("What would you like to do?");
        System.out.println();

        System.out.println("M) Feed Money");
        System.out.println("S) Select Item");
        System.out.println("F) Finish Transaction");
        System.out.println();
        System.out.println("Current money provided $" + currentBalance);
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

    public BigDecimal feedBill(BigDecimal currentBalance){

        BigDecimal totalInserted = new BigDecimal(0.00);
        //auditLogger = new AuditLogger();
        while(true){

            System.out.println("Machine takes 1, 5, 10, and 20 dollar bills. Please insert one at a time.");

            int bill = Integer.parseInt(scanner.nextLine());

            System.out.println("\nIf you are done adding money, enter 0: ");

            if (bill == 1 || bill == 5 || bill == 10 || bill == 20) {
                totalInserted = totalInserted.add(new BigDecimal(bill));
                System.out.println("\nNew Balance: $" + totalInserted.add(currentBalance));
                System.out.println();
                auditLogger.auditFeed(bill, (totalInserted.add(currentBalance)));
            } else if(bill == 0){
                break;
            } else {
                System.out.println("\nPlease insert valid bill");
            }
            auditLogger.closeWriter();
        }
        return totalInserted;
    }

    public String selectProduct(){
        System.out.print("\nPlease select an item: ");

        String selectedOption = scanner.nextLine();
        String item = selectedOption.trim().toUpperCase();
        System.out.println("You selected = " + item);

        return item;
    }

}


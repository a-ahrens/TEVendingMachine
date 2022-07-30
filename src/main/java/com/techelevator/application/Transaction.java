package com.techelevator.application;

import com.techelevator.ui.UserInput;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Transaction {

    UserInput userInput = new UserInput();
    AuditLogger auditLogger = new AuditLogger();




    public BigDecimal feedBill(BigDecimal currentBalance){

        BigDecimal totalInserted = new BigDecimal(0.00);

        while(true){

            int bill = userInput.inputFeedAmount();

//            System.out.println("Machine takes 1, 5, 10, and 20 dollar bills. Please insert one at a time.");
//
//            int bill = Integer.parseInt(scanner.nextLine());
//
//            System.out.println("\nIf you are done adding money, enter 0: ");

            if (bill == 1 || bill == 5 || bill == 10 || bill == 20) {
                totalInserted = totalInserted.add(new BigDecimal(bill));
                System.out.println("\nNew Balance: $" + totalInserted.add(currentBalance));
                System.out.println();

                String messageToLog = "Feed Money " + bill + " " + totalInserted.add(currentBalance);
                auditLogger.auditFeed(messageToLog);

            } else if(bill == 0){
                break;
            } else {
                System.out.println("\nPlease insert valid bill");
            }

        }
        return totalInserted;
    }

    public void calculateChange(BigDecimal change) {

        String message = "Change given: " + change + " " + change.subtract(change);
        auditLogger.auditFeed(message);

        BigDecimal quantity = change.divide(new BigDecimal(1));
        int numOfDollars = quantity.intValue();

        change = change.subtract(new BigDecimal(numOfDollars));
        change = change.multiply(new BigDecimal(100));

        quantity = change.divide(new BigDecimal(25));
        int numOfQuarters = quantity.intValue();
        change = change.subtract(new BigDecimal(numOfQuarters * 25));

        quantity = change.divide(new BigDecimal(10));
        int numOfDimes = quantity.intValue();
        change = change.subtract(new BigDecimal(numOfDimes * 10));

        quantity = change.divide(new BigDecimal(5));
        int numOfNickles = quantity.intValue();
        change = change.subtract(new BigDecimal(numOfNickles * 5));

        change = change.round(new MathContext(1, RoundingMode.HALF_EVEN));
        int numOfPennies = change.intValue();

        System.out.println("Dollars: " + numOfDollars);
        System.out.println("Quarters: " + numOfQuarters);
        System.out.println("Dimes: " + numOfDimes);
        System.out.println("Nickles: " + numOfNickles);
        //System.out.println("Pennies: " + numOfPennies);
    }


}

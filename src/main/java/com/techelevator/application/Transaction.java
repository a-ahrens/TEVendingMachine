package com.techelevator.application;

import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;

public class Transaction {

    UserInput userInput = new UserInput();
    UserOutput userOutput = new UserOutput();
    AuditLogger auditLogger = new AuditLogger();


    public BigDecimal feedBill(BigDecimal currentBalance){

        BigDecimal insertedBill = new BigDecimal(0.00);
        BigDecimal totalInserted = new BigDecimal(0.00);
        BigDecimal updatedBalance = currentBalance;

        while(true){

            int bill = userInput.inputFeedAmount();
            boolean isValidBill = validateBill(bill);

            if(bill == 0){
                break;
            }

            if(isValidBill == true) {
                insertedBill = new BigDecimal(bill);
                totalInserted = totalInserted.add(insertedBill);

                System.out.println("\nNew Balance: $" + totalInserted.add(currentBalance));
                System.out.println();

                String messageToLog = String.format("%-21s $%5.2f $%5.2f", "MONEY FED: ", insertedBill, totalInserted.add(currentBalance));
                auditLogger.auditFeed(messageToLog);
            }
        }
        return totalInserted;
    }

    public boolean validateBill(int bill){
        boolean isValid = false;
        BigDecimal totalInserted =  new BigDecimal(0.00);
        if (bill == 1 || bill == 5 || bill == 10 || bill == 20) {
            totalInserted = totalInserted.add(new BigDecimal(bill));
            isValid = true;
        }

        return isValid;
    }

    public String calculateChange(BigDecimal change) {

        String messageToLog = String.format("%-21s $%-5.2f $%5.2f", "CHANGE GIVEN: ", change, change.subtract(change));
        auditLogger.auditFeed(messageToLog);

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

        String changeStatement = "B" + numOfDollars + " Q" + numOfQuarters + " D"
                                + numOfDimes + " N" + numOfNickles;

        System.out.println("Dollars: " + numOfDollars);
        System.out.println("Quarters: " + numOfQuarters);
        System.out.println("Dimes: " + numOfDimes);
        System.out.println("Nickles: " + numOfNickles);
        //System.out.println("Pennies: " + numOfPennies);

        return changeStatement;

    }



}

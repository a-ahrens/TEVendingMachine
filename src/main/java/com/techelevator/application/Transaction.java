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

        BigDecimal totalInserted = new BigDecimal(0.00);

        while(true){

            int bill = userInput.inputFeedAmount();

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

//    public void makeTransaction(List<Inventory> listOfIndexSlots) {
//        while (true) {
//            userOutput.displayInventory(listOfIndexSlots); //display inventory
//
//            String selectedID = userInput.selectProduct();      //get selected item
//            int indexSlot = findProduct(selectedID);            //verify slot exists, return value of list Location
//
//            if (indexSlot >= 0) {
//                userOutput.displaySlotInformation(indexSlot, this.listOfIndexSlots);  //print slot info and special message
//
//                int compare = getCurrentRemainingBalance().compareTo(listOfIndexSlots.get(indexSlot).getPrice());
//
//                if (listOfIndexSlots.get(indexSlot).getProductRemaining() > 0 && (compare == 1 || compare == 0)) {
//                    reduceCurrentRemainingBalance(this.listOfIndexSlots.get(indexSlot).getPrice());
//                    userOutput.displayTypeMessage(this.listOfIndexSlots.get(indexSlot).getProductType());
//                    listOfIndexSlots.get(indexSlot).reduceProductRemaining();
//
//
//                    String messageToLog = listOfIndexSlots.get(indexSlot).getProductName() + " "
//                            + listOfIndexSlots.get(indexSlot).getSlotId() + " "
//                            + listOfIndexSlots.get(indexSlot).getPrice().add(currentRemainingBalance) + " "
//                            + currentRemainingBalance;
//                    auditLogger.auditFeed(messageToLog);
//
//                } else if (listOfIndexSlots.get(indexSlot).getProductRemaining() == 0) {
//
//                    System.out.println("\n\nNO LONGER AVAILABLE");
//                } else {
//                    System.out.println("\n\nMORE FUNDS NEEDED!");
//                }
//
//                break;
//
//            } else {
//                System.out.println("Please enter a valid index slot.");
//            }
//
//        }
//    }




    public String calculateChange(BigDecimal change) {

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

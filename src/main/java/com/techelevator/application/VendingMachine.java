package com.techelevator.application;

import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import javax.crypto.Mac;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class VendingMachine {


    UserInput userInput = new UserInput();
    UserOutput userOutput = new UserOutput();
    MachineStartup machineStartup = new MachineStartup();
    AuditLogger auditLogger = new AuditLogger();
    Transaction transaction = new Transaction();

    private List<Inventory> listOfIndexSlots = machineStartup.createInventorySlots();
    private BigDecimal currentRemainingBalance = new BigDecimal( 0.00);


    public BigDecimal getCurrentRemainingBalance() {
        return currentRemainingBalance;
    }

    public void addMoney(BigDecimal bill){
        this.currentRemainingBalance = this.currentRemainingBalance.add(bill);
    }

    public void reduceCurrentRemainingBalance(BigDecimal cost){
        currentRemainingBalance = currentRemainingBalance.subtract(cost);
    }

    public void run() {
        while (true) {
            userOutput.displayHomeScreen();
            String choice = userInput.getHomeScreenOption();

            if (choice.equals("display")) {
                userOutput.displayInventoryTop();
                userOutput.displayInventory(this.listOfIndexSlots);
                userOutput.displayInventoryBottom();

            } else if (choice.equals("purchase")) {
                purchase();

            } else if (choice.equals("exit")) {
                System.out.println("Thanks for shopping with Tech Elevator! Have a great day! :-) ");
                break;
            }
        }
    }

    public void purchase() {

        while (true) {

            BigDecimal currentBalance = this.getCurrentRemainingBalance();
            userOutput.displayPurchaseScreenOptions(currentBalance);

            String choice = userInput.getPurchasingScreenInput();

            if (choice.equals("feed")) {
                addMoney(transaction.feedBill(currentBalance));
                System.out.println("Current Balance: $" + getCurrentRemainingBalance());

            } else if (choice.equals("select")) {
                System.out.println("SELECT AN ITEM VIA INDEX SLOT");
                //makeTransaction(this.listOfIndexSlots);
                makeTransaction();

            } else if (choice.equals("finish")) {
                System.out.println("DON'T FORGET YOUR CHANGE!");
                transaction.calculateChange(getCurrentRemainingBalance());
                reduceCurrentRemainingBalance(getCurrentRemainingBalance());
                break;
            }
        }

    }

    public void makeTransaction() {
        while (true) {
            userOutput.displayInventory(this.listOfIndexSlots); //display inventory

            String selectedID = userInput.selectProduct();      //get selected item
            int indexSlot = findProduct(selectedID);            //verify slot exists, return value of list Location

            if (indexSlot >= 0) {
                userOutput.displaySlotInformation(indexSlot, this.listOfIndexSlots);  //print slot info and special message

                int compare = getCurrentRemainingBalance().compareTo(listOfIndexSlots.get(indexSlot).getPrice());

                if (listOfIndexSlots.get(indexSlot).getProductRemaining() > 0 && (compare == 1 || compare == 0)) {
                    reduceCurrentRemainingBalance(this.listOfIndexSlots.get(indexSlot).getPrice());
                    userOutput.displayTypeMessage(this.listOfIndexSlots.get(indexSlot).getProductType());
                    listOfIndexSlots.get(indexSlot).reduceProductRemaining();


                    String messageToLog = listOfIndexSlots.get(indexSlot).getProductName() + " "
                                        + listOfIndexSlots.get(indexSlot).getSlotId() + " "
                                        + listOfIndexSlots.get(indexSlot).getPrice().add(currentRemainingBalance) + " "
                                        + currentRemainingBalance;
                    auditLogger.auditFeed(messageToLog);

                } else if (listOfIndexSlots.get(indexSlot).getProductRemaining() == 0) {

                    System.out.println("\n\nNO LONGER AVAILABLE");
                } else {
                    System.out.println("\n\nMORE FUNDS NEEDED!");
                }

                break;

            } else {
                System.out.println("Please enter a valid index slot.");
            }

        }
    }

    public int findProduct(String selectedID){
        int doesExist = -1;

        for(int i = 0; i < listOfIndexSlots.size(); i++) {
            if (listOfIndexSlots.get(i).getSlotId().equals(selectedID)) {
                doesExist = i;
                break;
            }
        }

        return doesExist;
    }

}


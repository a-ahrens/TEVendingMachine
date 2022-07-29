package com.techelevator.application;

import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import javax.crypto.Mac;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    UserInput userInput = new UserInput();
    UserOutput userOutput = new UserOutput();
    MachineStartup machineStartup = new MachineStartup();
    private List<Inventory> listOfIndexSlots;
    private BigDecimal currentRemainingBalance;

    public VendingMachine() {
        this.listOfIndexSlots = machineStartup.createInventorySlots();
        this.currentRemainingBalance = new BigDecimal( 0.00);
    }

    public BigDecimal getCurrentRemainingBalance() {
        return currentRemainingBalance;
    }

    public void feedMoney(BigDecimal bill){
        this.currentRemainingBalance.add(bill);
    }

    public void makePurchase(BigDecimal cost){
        this.currentRemainingBalance.subtract(cost);
    }

    public void run() {
        while (true) {
            userOutput.displayHomeScreen();
            String choice = userInput.getHomeScreenOption();

            System.out.println(choice);
            if (choice.equals("display")) {
                userOutput.displayInventory(this.listOfIndexSlots);
            } else if (choice.equals("purchase")) {
                purchase();
            } else if (choice.equals("exit")) {
                // good bye
                break;
            }
        }
    }

    public List<Inventory> getListOfIndexSlots() {
        return listOfIndexSlots;
    }

    public void purchase() {

        while (true) {

            String choice = userInput.getPurchasingScreenOptions();

            System.out.println(choice);
            if (choice.equals("feed")) {

            } else if (choice.equals("select")) {
                 userOutput.displayInventory(this.listOfIndexSlots);

            } else if (choice.equals("finish")) {
                //We need to return the change
                //Reset current balance in vending machine to 0
                break;
            }
        }
    }

}

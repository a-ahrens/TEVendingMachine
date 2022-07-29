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

    private List<Inventory> listOfIndexSlots = machineStartup.createInventorySlots();
    private BigDecimal currentRemainingBalance = new BigDecimal( 10.67);

    public VendingMachine() {
        //this.listOfIndexSlots = machineStartup.createInventorySlots();
        //this.currentRemainingBalance = new BigDecimal( 0.00);
    }

    public BigDecimal getCurrentRemainingBalance() {
        return currentRemainingBalance;
    }

    public void feedMoney(BigDecimal bill){
        this.currentRemainingBalance = this.currentRemainingBalance.add(bill);
    }

    public void reduceCurrentRemainingBalance(BigDecimal cost){
        currentRemainingBalance = currentRemainingBalance.subtract(cost);
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

            userOutput.displayPurchaseScreen();

            BigDecimal currentBalance = this.getCurrentRemainingBalance();
            String choice = userInput.getPurchasingScreenOptions(currentBalance);


            System.out.println(choice);
            if (choice.equals("feed")) {
                BigDecimal bill = userInput.feedBill();
                feedMoney(bill);

                System.out.println("You have fed $" + bill);
                System.out.println("Current Balance: $" + getCurrentRemainingBalance());

            } else if (choice.equals("select")) {

                userOutput.displayInventory(this.listOfIndexSlots);
                String selectedID = userInput.selectProduct();
                System.out.println("slotID = " + selectedID);

                int indexSlot = findProduct(selectedID);

                System.out.println(listOfIndexSlots.get(indexSlot).getProductType());

                //look at the list of inventory objects
                    // find Inventory.getSlotID = A1


            } else if (choice.equals("finish")) {
                calculateChange(getCurrentRemainingBalance());
                reduceCurrentRemainingBalance(getCurrentRemainingBalance());
                break;
            }
        }
    }

    public void calculateChange(BigDecimal change) {

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
        System.out.println("Pennies: " + numOfPennies);
    }

    public int findProduct(String selectedID){
        int doesExist = -1;

        for(int i = 0; i < listOfIndexSlots.size(); i++) {
            if (listOfIndexSlots.get(i).getSlotId().equals(selectedID)) {
                doesExist = i;
            }
        }
        return doesExist;
    }
}

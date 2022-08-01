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
    Sales sales = new Sales();

    private List<Inventory> listOfIndexSlots = machineStartup.createInventorySlots();
    private BigDecimal currentRemainingBalance = new BigDecimal( 0.00);

    public BigDecimal getCurrentRemainingBalance() {
        return currentRemainingBalance;
    }

    public void addMoneyToCurrentRemainingBalance(BigDecimal bill){
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
                userOutput.displayFullInventory(this.listOfIndexSlots);

            } else if (choice.equals("purchase")) {
                openPurchaseOptions();

            } else if (choice.equals("exit")) {
                System.out.println("Thanks for shopping with Taste Elevator! Have a great day! :-) ");
                break;
            } else if (choice.equals("sales")) {
                userOutput.displaySalesMenu();
                if (userInput.runSalesReport().equals("y")){
                    sales.createSalesReport(listOfIndexSlots);
                } else {
                    userOutput.displayHomeScreen();
                }
            }
        }
    }

    public void openPurchaseOptions() {

        while (true) {

            BigDecimal currentBalance = this.getCurrentRemainingBalance();
            userOutput.displayPurchaseScreenOptions(currentBalance);

            String choice = userInput.getPurchasingScreenInput();

            if (choice.equals("feed")) {
                addMoneyToCurrentRemainingBalance (transaction.feedBill(currentBalance));
                System.out.println("Current Balance: $" + getCurrentRemainingBalance());

            } else if (choice.equals("select")) {
                System.out.println("PLEASE SELECT AN ITEM VIA INDEX SLOT");
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

            userOutput.displayFullInventory(this.listOfIndexSlots);
            String selectedID = userInput.selectProduct();

            if(selectedID.equals("0")){
                break;
            }

            int indexSlot = findProduct(selectedID);            //verify slot exists, return index location

            if (indexSlot >= 0) {

                userOutput.displaySlotInformation(indexSlot, this.listOfIndexSlots);        //print slot info and special message
                int balanceVsPrice = getCurrentRemainingBalance().compareTo(listOfIndexSlots.get(indexSlot).getPrice());
                validatePurchase(indexSlot, balanceVsPrice);

                break;

            } else {
                System.out.println("\n!!!! PLEASE ENTER A VALID INDEX SLOT !!!!");
            }

        }
    }

    public void validatePurchase(int indexSlot, int balanceVsPrice){
        if (listOfIndexSlots.get(indexSlot).getProductRemaining() > 0 && (balanceVsPrice == 1 || balanceVsPrice == 0)) {

            reduceCurrentRemainingBalance(this.listOfIndexSlots.get(indexSlot).getPrice());
            System.out.println("Remaining balance: $" + currentRemainingBalance);
            userOutput.displayTypeMessage(this.listOfIndexSlots.get(indexSlot).getProductType());
            listOfIndexSlots.get(indexSlot).reduceProductRemaining();
            listOfIndexSlots.get(indexSlot).incrementProductSold();

            String messageToLog = String.format("%-17s %-3s $%5.2f $%5.2f",
                                        listOfIndexSlots.get(indexSlot).getProductName(),
                                        listOfIndexSlots.get(indexSlot).getSlotId(),
                                        listOfIndexSlots.get(indexSlot).getPrice().add(currentRemainingBalance),
                                        currentRemainingBalance);

            auditLogger.auditFeed(messageToLog);

        } else if (listOfIndexSlots.get(indexSlot).getProductRemaining() == 0) {

            System.out.println("\n\n SORRY! NO LONGER AVAILABLE :_( ");
        } else {
            System.out.println("\n\n $$$ MORE FUNDS NEEDED $$$");
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


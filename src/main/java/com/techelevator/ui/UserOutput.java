package com.techelevator.ui;

import com.techelevator.application.Inventory;
import com.techelevator.application.MachineStartup;
import com.techelevator.application.VendingMachine;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserOutput {

    public void displayMessage(String message) {
        System.out.println();
        System.out.println(message);
        System.out.println();
    }

    public void displayHomeScreen() {
        System.out.println();
        System.out.println("***************************************************");
        System.out.println("                      Home");
        System.out.println("***************************************************");
        System.out.println();
    }

    public void displayInventoryTop(){
        System.out.println("============================== MENU ==============================");
        System.out.println("|| Slot   Name               Price       Product Type     Stock ||");
    }

    public void displayInventory(List<Inventory> listOfIndexSlots){
        String productRemaining;

        for (int i = 0; i < listOfIndexSlots.size(); i++) {
            productRemaining= "OUT OF STOCK";
            if (listOfIndexSlots.get(i).getProductRemaining() > 0 ){
               productRemaining = String.valueOf(listOfIndexSlots.get(i).getProductRemaining());
           }
            System.out.printf("%-2s %-6s %-18s %-11.2f %-15s %2s %6s", "||", listOfIndexSlots.get(i).getSlotId(),
                    listOfIndexSlots.get(i).getProductName(), listOfIndexSlots.get(i).getPrice(), listOfIndexSlots.get(i).getProductType(), productRemaining, "||");
            System.out.println();
        }
    }

    public void displayInventoryBottom(){
        System.out.println("==================================================================");
        System.out.println();
    }

    public void displayFullInventory(List<Inventory> listOfIndexSlots){
        displayInventoryTop();
        displayInventory(listOfIndexSlots);
        displayInventoryBottom();
    }

    public void displayPurchaseScreenOptions(BigDecimal currentBalance) {
        System.out.println();
        System.out.println("***************************************************");
        System.out.println("                      Purchase");
        System.out.println("***************************************************");
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println();

        System.out.println("M) Feed Money");
        System.out.println("S) Select Item");
        System.out.println("F) Finish Transaction");
        System.out.println();
        System.out.println("Current money provided $" + currentBalance);
        System.out.println();
        System.out.print("Please select an option: ");

    }

    public void displaySlotInformation(int slotIndex, List<Inventory> listOfIndexSlots ){
        String productRemaining = "OUT OF STOCK";

        if (listOfIndexSlots.get(slotIndex).getProductRemaining() > 0 ){
            productRemaining = String.valueOf(listOfIndexSlots.get(slotIndex).getProductRemaining());
        }

        System.out.println();
        System.out.println("Product: " + listOfIndexSlots.get(slotIndex).getProductName()
                + " Price: " + listOfIndexSlots.get(slotIndex).getPrice());
    }

    public String displayTypeMessage(String itemType) {
        String message = "";

        Map<String, String> messages = new HashMap<>();
        messages.put("Munchy", "Munchy, Munchy, so Good!");
        messages.put("Candy", "Sugar, Sugar, so Sweet!");
        messages.put("Drink", "Drinky, Drinky, Slurp Slurp!");
        messages.put("Gum", "Chewy, Chewy, Lots Of Bubbles!");

        if (!itemType.equals("") && !itemType.equals(null)) {
            message = messages.get(itemType);
            System.out.println();
            System.out.println(message);
        }
        return message;
    }

    public void displaySalesMenu(){
        System.out.println("SALES REPORT");
        System.out.println("Do you want to generate a Sales Report? (Y/N)" );
    }

}

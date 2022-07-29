package com.techelevator.ui;

import com.techelevator.application.Inventory;
import com.techelevator.application.MachineStartup;
import com.techelevator.application.VendingMachine;

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

    public void displayInventory(List<Inventory> listOfIndexSlots){
        String productRemaining;

        System.out.println("Slot:     Name:      Price:      Product Type:       Product Remaining: ");
        for (int i = 0; i < listOfIndexSlots.size(); i++) {
            productRemaining= "OUT OF STOCK";
            if (listOfIndexSlots.get(i).getProductRemaining() > 0 ){
               productRemaining = String.valueOf(listOfIndexSlots.get(i).getProductRemaining());
           }
            System.out.println(listOfIndexSlots.get(i).getSlotId() + "   "
                    + listOfIndexSlots.get(i).getProductName() +  "  " + listOfIndexSlots.get(i).getPrice() +
                  "     "  +  listOfIndexSlots.get(i).getProductType() +
                "    " + productRemaining);
        }
    }


    public void displayPurchaseScreen() {
        System.out.println();
        System.out.println("***************************************************");
        System.out.println("                      Purchase");
        System.out.println("***************************************************");
        System.out.println();
    }

    public void displaySlotInformation(int slotIndex, List<Inventory> listOfIndexSlots ){
        String productRemaining = "OUT OF STOCK";
        if (listOfIndexSlots.get(slotIndex).getProductRemaining() > 0 ){
            productRemaining = String.valueOf(listOfIndexSlots.get(slotIndex).getProductRemaining());
        }

        System.out.println("Product: " + listOfIndexSlots.get(slotIndex).getProductName()
                + " Price: " + listOfIndexSlots.get(slotIndex).getPrice()
                + " Stock: " + productRemaining);
    }

    public void displayTypeMessage(String itemType){
        Map<String, String> messages = new HashMap<>();
        messages.put("Munchy", "Munchy, Munchy, so Good!");
        messages.put("Candy", "Sugar, Sugar, so Sweet!");
        messages.put("Drink", "Drinky, Drinky, Slurp Slurp!");
        messages.put("Gum", "Chewy, Chewy, Lots Of Bubbles!");

        System.out.println(messages.get(itemType));
    }

}

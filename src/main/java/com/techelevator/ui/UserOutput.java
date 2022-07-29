package com.techelevator.ui;

import com.techelevator.application.Inventory;
import com.techelevator.application.MachineStartup;
import com.techelevator.application.VendingMachine;

import java.util.List;

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
        String productRemaining = "NO LONGER AVAILABLE";


        System.out.println("Test");
        System.out.println("Slot:     Name:      Price:      Product Type:       Product Remaining: ");
        for (int i = 0; i < listOfIndexSlots.size(); i++) {

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

}

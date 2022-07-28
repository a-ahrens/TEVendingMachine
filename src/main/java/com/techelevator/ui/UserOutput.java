package com.techelevator.ui;

import com.techelevator.application.Inventory;
import com.techelevator.application.VendingMachine;

public class UserOutput {

    VendingMachine vendingMachine = new VendingMachine();

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

    public void displayInventory(){
        System.out.println("Test");
        //for(Inventory index : vendingMachine.getListOfIndexSlots()){
         //   System.out.println(index);
        //}
    }
}

package com.techelevator.application;

import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    UserInput userInput = new UserInput();
    UserOutput userOutput = new UserOutput();

    private List<Inventory> listOfIndexSlots = new ArrayList<Inventory>();

    public void run() {
        while(true) {
            userOutput.displayHomeScreen();
            String choice = userInput.getHomeScreenOption();

            System.out.println(choice);
            if(choice.equals("display")) {
               userOutput.displayInventory();
            }
            else if(choice.equals("purchase")) {
                // make a purchase
            }
            else if(choice.equals("exit")) {
                // good bye
                break;
            }
        }
    }

    public void loadIndexSlots() {
        MachineStartup machineStartup = new MachineStartup();
        listOfIndexSlots = machineStartup.createInventorySlots();
    }

    public List<Inventory> getListOfIndexSlots() {
        return listOfIndexSlots;
    }
}

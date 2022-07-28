package com.techelevator;


import com.techelevator.application.MachineStartup;
import com.techelevator.application.VendingMachine;

public class VendingMachineCLI {

	public static void main(String[] args) {
		VendingMachine vendingMachine = new VendingMachine();
		MachineStartup machineStartup = new MachineStartup();

		machineStartup.loadInventoryList();
		machineStartup.createInventorySlots();

		vendingMachine.run();


	}
}

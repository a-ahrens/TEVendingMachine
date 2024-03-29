package com.techelevator.application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MachineStartup {
    private final String PATHNAME = "src/main/resources";
    private final String FILENAME = "catering1.csv";

    private List<String> inventoryLines = new ArrayList<String>(); // sample of each list index: "A1,U-Chews,1.65,Gum"
    private File inventoryFile = new File(PATHNAME,FILENAME);

    public void loadInventoryList(){
        try(Scanner readFile = new Scanner(inventoryFile)){
            while(readFile.hasNextLine()){
                String inputLine = readFile.nextLine();
                inventoryLines.add(inputLine);
            }
        } catch (FileNotFoundException e){
            System.out.println("File Not Found");
            System.out.println();
        }
        inventoryLines.sort(Comparator.naturalOrder());
    }

    public List<Inventory> createInventorySlots(){
        loadInventoryList();
        List<Inventory> listOfInventoryObjects = new ArrayList<>();

        for(String input: inventoryLines){
            String[] attributeArray = input.split(",");

             Inventory indexSlot = new Inventory(attributeArray);
             //add this new inventory object into Vending Machine list: listOfIndexSlot
            listOfInventoryObjects.add(indexSlot);
        }

        return listOfInventoryObjects;
    }
}

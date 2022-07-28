package com.techelevator.application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MachineStartup {
    private final String pathName = "catering.csv";
    private final String fileName = "catering.csv";

    private List<String> inventoryLines = new ArrayList<String>();

    private File inventoryFile = new File(pathName, fileName);

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
    }

    public void createInventory(ArrayList<String> inventoryLines){
        for(String input: inventoryLines){
            String[] attributeArray = input.split(",");
            //String indexName = attributeArray[0];

            Inventory index = new Inventory(attributeArray);



        }
    }
}

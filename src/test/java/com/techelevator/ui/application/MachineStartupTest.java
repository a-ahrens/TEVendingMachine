package com.techelevator.ui.application;

import org.junit.AfterClass;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.*;

public class MachineStartupTest {

    private final String TEST_PATH_NAME = "src/main/resources";
    private final String TEST_FILE_NAME = "catering.csv";

    File fileTest = new File(TEST_PATH_NAME, TEST_FILE_NAME);
    private List<String> actualStringList = new ArrayList<String>();

    @Test
    public void FileDoesExist() {
        //Arrange
        boolean doesExist = false;
        //act
        if (fileTest.exists()) {
            doesExist = true;
        }

        //assert
        assertEquals(true, doesExist);
    }

//    @Test
//    public void LoadInventoryTest() {
//        //Arrange
//        MachineStartup machineStartup = new MachineStartup();
//        try(Scanner readFile = new Scanner(fileTest)){
//            while(readFile.hasNextLine()){
//                String inputLine = readFile.nextLine();
//                actualStringList.add(inputLine);
//            }
//        } catch (FileNotFoundException e){
//            System.out.println("File Not Found");
//            System.out.println();
//        }
//
//
//        boolean doesExist = false;
//        //act
//
//
//
//    }

    @Test
    public void InventorySlots () {
    }
}
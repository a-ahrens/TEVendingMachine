package com.techelevator.ui;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class UserOutputTest {

    @Test
    public void displayInventory() {
    }

    @Test
    public void displaySlotInformation() {
    }


//    Map<String, String> messages = new HashMap<>();
//        messages.put("Munchy", "Munchy, Munchy, so Good!");
//        messages.put("Candy", "Sugar, Sugar, so Sweet!");
//        messages.put("Drink", "Drinky, Drinky, Slurp Slurp!");
//        messages.put("Gum", "Chewy, Chewy, Lots Of Bubbles!");


    @Test
    public void displayTypeMessage_TestMunchy() {

        //arrange
        UserOutput userOutput = new UserOutput();
        String expected = "Munchy, Munchy, so Good!";
        //act
        String actual = userOutput.displayTypeMessage("Munchy");

        //assert
        assertEquals(expected, actual);
    }

    @Test
    public void displayTypeMessage_Test_NoKey() {

        //arrange
        UserOutput userOutput = new UserOutput();
        String expected = "";
        //act
        String actual = userOutput.displayTypeMessage("");
        //assert
        assertEquals(expected, actual);
    }


}
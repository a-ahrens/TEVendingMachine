package com.techelevator.application;

import org.junit.Test;

import static org.junit.Assert.*;

public class VendingMachineTest {

    @Test
    public void findProduct_DoesNotExist() {
        //arrange
        VendingMachine vendingMachine = new VendingMachine();
        int expected = -1;
        String testStr = "A10";
        //act
        int actual = vendingMachine.findProduct(testStr);

        //assert
        assertEquals(expected, actual);

    }

    @Test
    public void findProduct_DoesExist() {
        //arrange
        VendingMachine vendingMachine = new VendingMachine();
        int expected = 0;
        String testStr = "A1";
        //act
        int actual = vendingMachine.findProduct(testStr);

        //assert
        assertEquals(expected, actual);

    }


    @Test
    public void findProduct_EmptyString() {
        //arrange
        VendingMachine vendingMachine = new VendingMachine();
        int expected = -1;
        String testStr = "";
        //act
        int actual = vendingMachine.findProduct(testStr);

        //assert
        assertEquals(expected, actual);

    }

    @Test
    public void findProduct_Null() {
        //arrange
        VendingMachine vendingMachine = new VendingMachine();
        int expected = -1;
        String testStr = null;
        //act
        int actual = vendingMachine.findProduct(testStr);

        //assert
        assertEquals(expected, actual);

    }

}
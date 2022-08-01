package com.techelevator.application;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class TransactionTest {

    Transaction transaction = new Transaction();

    @Test
    public void validateBill_10() {

        //Arrange
        boolean expected = true;
        int bill = 10;

        //Act
        boolean actual = transaction.validateBill(bill);

        //Assert
        assertEquals(expected, actual);

    }

    @Test
    public void validateZero() {

        //Arrange
        boolean expected = false;
        int bill = 0;

        //Act
        boolean actual = transaction.validateBill(bill);

        //Assert
        assertEquals(expected, actual);

    }

    @Test
    public void validateBill_InvalidBill() {

        //Arrange
        boolean expected = false;
        int bill = 2;

        //Act
        boolean actual = transaction.validateBill(bill);

        //Assert
        assertEquals(expected, actual);

    }

    @Test
    public void calculateChange_EveryChangeType() {

        //Arrange
        String expected = "B3 Q2 D1 N1";

        //Act
        String actual = transaction.calculateChange(new BigDecimal(3.67));

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void calculateChange_CurrentBalanceIsZero() {

        //Arrange
        String expected = "B0 Q0 D0 N0";

        //Act
        String actual = transaction.calculateChange(new BigDecimal(0.00));

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void calculateChange_NoBills() {

        //Arrange
        String expected = "B0 Q0 D0 N0";

        //Act
        String actual = transaction.calculateChange(new BigDecimal(0.01));

        //Assert
        assertEquals(expected, actual);
    }

}
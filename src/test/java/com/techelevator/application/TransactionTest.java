package com.techelevator.application;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class TransactionTest {

    Transaction transaction = new Transaction();

//    @Test//1
//    public void feedBill_Test() {
//
//    //Arrange
//    BigDecimal expectedTotalInserted = new BigDecimal(36.00);
//    // type in 1, 5, 10 ,20, 0 manually
//
//    //Act
//    BigDecimal actualTotalInserted = transaction.feedBill(new BigDecimal(0.00));
//
//    //Assert
//    assertEquals(expectedTotalInserted, actualTotalInserted);
//
//    }

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
}
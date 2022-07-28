package com.techelevator.application;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private String slotId;
    private String productName;
    private BigDecimal price;
    private String productType;
    private int productRemaining = 6;

    public Inventory(String[] productInfo){
        this.slotId = productInfo[0];
        this.productName = productInfo[1];
        this.price = new BigDecimal(productInfo[2]);
        this.productType = productInfo[3];
    }

}

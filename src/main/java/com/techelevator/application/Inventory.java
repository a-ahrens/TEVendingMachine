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

    @Override
    public String toString() {
        return "Inventory{" +
                "slotId='" + slotId + '\'' +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", productType='" + productType + '\'' +
                ", productRemaining=" + productRemaining +
                '}';
    }

    public Inventory(String[] productInfo){
        this.slotId = productInfo[0];
        this.productName = productInfo[1];
        this.price = new BigDecimal(productInfo[2]);
        this.productType = productInfo[3];
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getProductName() {
        return productName;
    }

    public String getSlotId() {
        return slotId;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductRemaining(int productRemaining) {
        this.productRemaining = productRemaining;
    }
}

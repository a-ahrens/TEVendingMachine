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
    private int productSold = 0;

    @Override
    public String toString() {
        return "Inventory{" +
                "slotId='" + slotId + '\'' +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", productType='" + productType + '\'' +
                ", productRemaining=" + productRemaining +
                ", productSold=" + productSold +
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

    public int getProductRemaining() {
        return productRemaining;
    }

    public int getProductSold(){
        return productSold;
    }

    public void reduceProductRemaining(){
        this.productRemaining = this.productRemaining - 1;
    }

    public void incrementProductSold(){
        this.productSold += 1;
    }


}

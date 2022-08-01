package com.techelevator.application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sales {

    private final String PATHNAME = "src/main/resources/SalesReports";

    LocalDateTime currentLocalDateTime = LocalDateTime.now();
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM-dd-YYYY hh-mm-ss a ");
    String formattedDateTime = currentLocalDateTime.format(dateTimeFormatter);

    private final String FILENAME = formattedDateTime + "Sales Report.txt";

    File salesFile;
    PrintWriter writer;

    public Sales(){
        this.salesFile = new File(PATHNAME, FILENAME);

        try  {
            this.writer = new PrintWriter(new FileOutputStream(this.salesFile, true));
            this.writer.println("Taste Elevator Sales Report");
            this.writer.flush();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void createSalesReport(List<Inventory> listOfIndexes){

        BigDecimal totalSales = new BigDecimal(0.00);
        BigDecimal productPrice;
        BigDecimal productSold;

        for(int i =0; i < listOfIndexes.size(); i++){

            productPrice = listOfIndexes.get(i).getPrice();
            productSold = new BigDecimal(listOfIndexes.get(i).getProductSold());
            totalSales = totalSales.add(productPrice.multiply(productSold));


            this.writer.println(listOfIndexes.get(i).getProductName() + "|" + listOfIndexes.get(i).getProductSold());
            this.writer.flush();
        }

        this.writer.println("Total Sales: $" + totalSales);
        this.writer.flush();
    }



}

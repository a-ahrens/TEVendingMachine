package com.techelevator.application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sales {

    private final String PATHNAME = "src/main/resources/SalesReports";
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-YYYY hh-mm-ss a");
    private final String FILENAME = "Sales Report.txt";

    Map<String, Integer> sales = new HashMap<>();

    File salesFile;
    PrintWriter writer;

    public Sales(){
        this.salesFile = new File(PATHNAME, FILENAME);

        try  {
            this.writer = new PrintWriter(new FileOutputStream(this.salesFile, true));
            this.writer.println("Taste Elevator Sales Report");
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void createSalesReport(){

        for(String productName: sales.keySet()){
            this.writer.println(productName + "|" + sales.get(productName));
            System.out.println();
        }
        //this.writer.flush();
    }

    public void loadSalesMap(List<Inventory> listOfIndexes){
        Map<String, Integer> sales = new HashMap<>();

        for(int i = 0; i < listOfIndexes.size(); i++){
            sales.put(listOfIndexes.get(i).getProductName(), 0);
        }
    }


    public void incrementItemsSold(String product){
        int increment = 0;

        for(String productKey: sales.keySet()){

            if(productKey.equals(product)){
                increment = sales.get(productKey)+1;
                sales.put(productKey, increment);
            }
        }
    }


}

package com.techelevator.application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AuditLogger {

    private final String pathName = "src/main/resources";
    private final String fileName = "audit.txt";
    File auditFile;
    PrintWriter writer;

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-YYYY hh:mm:ss a");


    public AuditLogger(){
        this.auditFile = new File(pathName, fileName);

        try  {
           this.writer = new PrintWriter(new FileOutputStream(this.auditFile, true));
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void auditFeed(String messageToLog){

            this.writer.println(dtf.format(LocalDateTime.now()) + " " + messageToLog);
            this.writer.flush();


    }

    public void closeWriter(){
        writer.flush();
        writer.close();
    }
}

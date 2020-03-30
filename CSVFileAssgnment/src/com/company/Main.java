package com.company;

//question link - https://www.coursera.org/learn/java-programming/supplement/Qu17T/programming-exercise-parsing-export-data

import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class Main {

    public void tester(){

        FileResource fr = new FileResource();
        CSVParser parser;

        parser = fr.getCSVParser();
        countryInfo(parser, "Germany");

        parser = fr.getCSVParser();
        listExportersTwoProducts(parser, "gold", "diamonds");

        parser = fr.getCSVParser();
        System.out.println("numberOfExporters: "+numberOfExporters(parser,"gold"));

        parser = fr.getCSVParser();
        bigExporters(parser,"$999,999,999");

    }

    public String countryInfo(CSVParser parser, String country){

            String ans="";
            String inputCountry;
            for (CSVRecord record:parser) {

                inputCountry = record.get("Country");

                if (inputCountry.equals(country)){
                    System.out.println(inputCountry);
                    ans = record.get("Country")+":"+record.get("Exports");
                    System.out.println(ans);
                }
            }

            return null;
    }

    public String listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2){
        String ans="";
        String exportItemInput;

        for (CSVRecord record:parser) {
            exportItemInput = record.get("Exports");
            if ((exportItemInput.contains(exportItem1)) && (exportItemInput.contains(exportItem2))){
                ans = record.get("Country");
                System.out.println("listExportersTwoProducts: "+ans);
            }

        }
        return null;
    }

    public int numberOfExporters(CSVParser parser,String exportItem){
        String exportItemInput;
        String ans;
        int count=0;
        for (CSVRecord record:parser) {
            exportItemInput = record.get("Exports");
            if(exportItemInput.contains(exportItem))
                count++;
        }
        return count;
    }

    public void bigExporters(CSVParser parser, String amount){
        String outputAmount;
        String ans;
        int count=0;
        for (CSVRecord record:parser) {
            outputAmount = record.get("Value (dollars)");
            if(outputAmount.length() > amount.length()){
                ans = record.get("Country")+":"+record.get("Value (dollars)");
                System.out.println("bigExporters: "+ans);
            }
        }
    }

    public static void main(String[] args) {
	// write your code here
        Main main=new Main();
        main.tester();
    }
}

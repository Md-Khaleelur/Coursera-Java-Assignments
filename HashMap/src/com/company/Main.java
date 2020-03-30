package com.company;

import edu.duke.FileResource;

import java.util.HashMap;

public class Main {

    private HashMap<String,Integer> dnaCodons;

    Main(){
        dnaCodons=new HashMap<String, Integer>();
    }

    void buildCodonMap(int start, String dna){

        int stringPos=start;
        for (int i=0; stringPos+3<=dna.length(); i++){

            boolean index=dnaCodons.containsKey(dna.substring(stringPos,stringPos+3));

            if (index){
                int val =dnaCodons.get(dna.substring(stringPos,stringPos+3));
                dnaCodons.put(dna.substring(stringPos,stringPos+3),val+1);
            }

            else {
                dnaCodons.put(dna.substring(stringPos,stringPos+3),1);
            }

            stringPos=stringPos+3;
            i=i+3;
        }
    }

    public String getMostCommonCodon(){

        int max = 0;
        int value = 0;
        String maxKey="";
        for(String key: dnaCodons.keySet()){
            value = dnaCodons.get(key);
            if(value>max){
                max = value;
                maxKey = key;
             }
        }
        return maxKey;
    }

    public void printCodonCounts(int start, int end){
        for (String key : dnaCodons.keySet()) {
            int checkVal = dnaCodons.get(key);
            if (checkVal>start && checkVal<end)
                System.out.println("Key: "+key+" Value: "+dnaCodons.get(key));
        }
    }

    public void tester(){
        FileResource fileResource= new FileResource();
        String mostCommonCodon;
        for (String word: fileResource.words()){

            buildCodonMap(2,word);
            mostCommonCodon = getMostCommonCodon();
            System.out.println("Most Common Codon:"+ mostCommonCodon);
            printCodonCounts(0,5);

        }
    }

    public static void main(String[] args) {
	// write your code here
        Main main = new Main();
        main.tester();

    }
}

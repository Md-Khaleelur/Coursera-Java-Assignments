//question - Write a program to determine which words occur in the greatest number of files, and for each word, which files they occur in. 

import edu.duke.FileResource;

import java.util.ArrayList;

public class WordFrequencies {

    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;

    WordFrequencies(){
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>() ;
    }

    public void findUnique(){
        myFreqs.clear();
        myWords.clear();
        int index;
        FileResource fileResource = new FileResource();
        for (String name: fileResource.words()) {
            index = myWords.indexOf(name);
            if (index == -1) {
                myWords.add(name);
                myFreqs.add(1);
            }

            else {
                int count = myFreqs.get(index)+1;
                myFreqs.set(index,count);
            }
        }
    }

    public int findIndexOfMax() {
        int max = myFreqs.get(0);
        int index;
        for (int i=0; i < myFreqs.size(); i++) {
            index = myFreqs.get(i);
            System.out.println(myWords.get(i));
            System.out.println(myFreqs.get(i));
            if (max<index)
                max = index;
        }
        System.out.println(myWords.get(max));
        return max;
    }

    public void tester() {
            findUnique();
            System.out.print("Maximum Value "+findIndexOfMax());
    }

    public static void main(String[] args) {
            WordFrequencies wordFrequencies = new WordFrequencies();
            wordFrequencies.tester();
    }
}

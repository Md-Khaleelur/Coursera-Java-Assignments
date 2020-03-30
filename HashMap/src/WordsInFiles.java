import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;

public class WordsInFiles {

    private HashMap<String,ArrayList<String>> wordMap;

    public WordsInFiles(){
        wordMap = new HashMap<String, ArrayList<String>>();
    }

    public ArrayList<String> WordsInNumFiles(int number){

        ArrayList<String> requiredList =new ArrayList<>();

        for (String word: wordMap.keySet()) {
            int size = wordMap.get(word).size();
            if(number == size)
                requiredList.add(word);
        }
        return requiredList;
    }

    private void addWordsFromFile(File f){
        ArrayList<String> fileNames = new ArrayList<String>();
        FileResource fr =new FileResource(f);
        String filename = f.getName();
        //String fileData = fr.asString();
        for (String word: fr.words()) {
            if(wordMap.containsKey(word) && !wordMap.get(word).contains(filename)){
                fileNames = wordMap.get(word);
                fileNames.add(filename);
                wordMap.put(word, fileNames);
            }
            else {
                ArrayList<String> newList =new ArrayList<String>();
                newList.add(filename);
                wordMap.put(word, newList);
            }
        }
    }

    public void buildWordFileMap(){
        wordMap.clear();
        DirectoryResource directoryResource = new DirectoryResource();
        for (File file:
        directoryResource.selectedFiles() ) {
            addWordsFromFile(file);
        }
    }

    public int maxNumber(){
        int maxSize = 0;
        int size=0;

        for (String word: wordMap.keySet()) {
                size = wordMap.get(word).size();
                if(maxSize < size )
                    maxSize = size;
        }
        return maxSize;
    }

    public void printFilesIn(String word){
//            if(wordMap.containsKey(word))
//                    System.out.println("Files are "+wordMap.get(word));
//
        ArrayList<String> fileNames = wordMap.get(word);
        for (int index = 0; index < fileNames.size(); index++) {
            System.out.println(fileNames.get(index));
        }
  }

    public void tester(){
        buildWordFileMap();
        printFilesIn("hello");
        System.out.println(wordMap);
    }

    public static void main(String[] args) {

        WordsInFiles wordsInFiles =new WordsInFiles();
        wordsInFiles.tester();
    }
}

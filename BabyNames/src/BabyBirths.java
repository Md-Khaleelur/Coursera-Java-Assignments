//question link - https://www.coursera.org/learn/java-programming/supplement/VeM7L/miniproject-exercise-guide

import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class BabyBirths {

    public void printNames() {
        FileResource fr = new FileResource("/home/rehman/Downloads/testing/yob2014short.csv");
        for (CSVRecord rec : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(rec.get(2));
            if(numBorn <= 5) {
                System.out.println("Name " + rec.get(0) +
                        " Gender " + rec.get(1) +
                        " Num of Births " + rec.get(2));
            }

        }
    }

    public void totalBirths() {
        FileResource fr = new FileResource("/home/rehman/Downloads/testing/yob2014short.csv");
        int totalBirths = 0;
        int totalMale = 0;
        int totalFemale = 0;
        for (CSVRecord record : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(record.get(2));
            totalBirths += numBorn;
            if(record.get(1).equals("M")) {
                totalMale += numBorn;
            } else {
                totalFemale += numBorn;
            }
        }
        System.out.println("Total births: "+ totalBirths);
        System.out.println("Total boys: "+ totalMale);
        System.out.println("Total girls: "+ totalFemale);
    }

    public long getRank(int year, String name, String gender) {
        long rank = -1;
        FileResource fr = new FileResource("/home/rehman/Downloads/us_babynames_by_year/yob"+year+".csv");
        for (CSVRecord record : fr.getCSVParser(false)) {
            if(record.get(0).equals(name) && record.get(1).equals(gender)) {
                rank = record.getRecordNumber();
            }
        }
        return rank;
    }

    public String getName(int year, int rank, String gender) {
        String name = null;
        FileResource fr = new FileResource("/home/rehman/Downloads/us_babynames_by_year/yob"+year+".csv");
        for (CSVRecord record : fr.getCSVParser(false)) {
            long currentRank = record.getRecordNumber();
            if(currentRank == rank && record.get(1).equals(gender)) {
                name = record.get(0);
            }
        }
        if(name != null) {
            return  name;
        } else {
            return "NO NAME";
        }
    }

    public void whatIsNameInYear(String name, int year, int newYear, String gender) {
        //Search the first year file for the name and gender
        //Find the rank of this name and store in tempRank
        //Go to the second year file
        //Find the name where rank is tempRank and gender is the same
        long tempRank = 0;
        FileResource fr = new FileResource("/home/rehman/Downloads/us_babynames_by_year/yob"+year+".csv");
        for (CSVRecord record : fr.getCSVParser(false)) {
            if(record.get(0).equals(name) && record.get(1).equals(gender)) {
                tempRank = record.getRecordNumber();
            }
        }
        FileResource fr2 = new FileResource("/home/rehman/Downloads/us_babynames_by_year/yob"+newYear+".csv");
        String newName = null;
        for (CSVRecord record2 : fr2.getCSVParser(false)) {
            if(record2.get(1).equals(gender) && record2.getRecordNumber() == tempRank) {
                newName = record2.get(0);
            }
        }
        System.out.println(name+"'s new name in "+newYear+" would be "+newName);
    }

    public int yearOfHighestRank(String name, String gender) {
        int highestYear = -1;
        long highestRank = 0;
        String fileName = null;
        //Loop through files in each directory
        //Compare rank and update highestRank (Remember, lower number)
        //Get the file name, remove non-numeric characters and return

        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            for (CSVRecord record : fr.getCSVParser(false)) {
                long currentRank = record.getRecordNumber();
                if(record.get(0).equals(name) && record.get(1).equals(gender)) {
                    if(highestRank == 0) {
                        highestRank = currentRank;
                        fileName = f.getName();
                    }
                    else {
                        if(highestRank > currentRank) {
                            highestRank = currentRank;
                            fileName = f.getName();
                        }
                    }
                }

            }
        }
        fileName = fileName.replaceAll("[^\\d]", "");
        highestYear = Integer.parseInt(fileName);
        return highestYear;
    }

    public long getAverageRank(String name, String gender) {
        int numOfFiles = 0;
        long totalRank = 0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            for (CSVRecord record : fr.getCSVParser(false)) {
                if(record.get(0).equals(name) && record.get(1).equals(gender)) {
                    totalRank = totalRank + record.getRecordNumber();
                    numOfFiles++;
                }
            }
        }
        long averageRank = (totalRank/numOfFiles);
        return averageRank;
    }

    public int getTotalBirthsRankedHigher(int year, String name, String gender) {
        int totalBirths = 0;
        long rank = getRank(year, name, gender);
        FileResource fr = new FileResource("/home/rehman/Downloads/us_babynames_by_year/yob"+year+".csv");
        for (CSVRecord record : fr.getCSVParser(false)) {
            long currentRank = record.getRecordNumber();
            if(record.get(1).equals(gender) && currentRank < rank ) {
                totalBirths = totalBirths += Integer.parseInt(record.get(2));
            }
        }
        return totalBirths;
    }

}

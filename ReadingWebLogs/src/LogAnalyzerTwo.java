import edu.duke.FileResource;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import edu.duke.FileResource;


public class LogAnalyzerTwo {

        private ArrayList<LogEntry> records;

        LogAnalyzerTwo(){
            records=new ArrayList<LogEntry>();
        }

        public void readFile(String s){
            FileResource fileResource = new FileResource();
            for (String line: fileResource.lines()
            ) {
                LogEntry entry = WebLogParser.parseEntry(line);
                records.add(entry);
            }
        }

        public void printAll() {
            for (LogEntry le : records) {
                System.out.println(le);
            }
        }

    public int countUniqueIPs(){
        ArrayList<String> uniqueIPs = new ArrayList<String>();
        for (LogEntry le : records){
            //Check every entry, if the ip is not in our new array, add it, then return the size.
            String ipAddr = le.getIpAddress();
            if (!uniqueIPs.contains(ipAddr)){
                uniqueIPs.add(ipAddr);
            }
        }
        return uniqueIPs.size();
    }

    public void printAllHigherThanNum(int num){
        for (LogEntry le : records){
            //Check the entries, if the code is bigger than the num as a parameter, print it. Very simple.
            int statusCode = le.getStatusCode();
            if (statusCode > num){
                System.out.println(le);
            }
        }
    }

    public ArrayList uniqueIPVisitsOnDay(String someday){

        ArrayList<String> uniqueIPs = new ArrayList<String>();
        ArrayList<String> uniqueIPsDates = new ArrayList<String>();
        for (LogEntry le : records){
            Date d = le.getAccessTime();
            String str = d.toString();
            String subStr = str.substring(4,10);
            String ipAddr = le.getIpAddress();
            if(subStr.equals(someday) && !uniqueIPs.contains(ipAddr)){
                uniqueIPs.add(ipAddr);
                uniqueIPsDates.add(subStr);
            }
        }
        return uniqueIPs;
    }

    public int countUniqueIPsInRange(int low, int high){
        ArrayList<String> uniqueIPs = new ArrayList<String>();
        ArrayList<Integer> uniqueIPsStatus = new ArrayList<Integer>();
        for (LogEntry le : records){
            int status = le.getStatusCode();
            String ipAddr = le.getIpAddress();
            if (status >= low && status <= high && !uniqueIPs.contains(ipAddr)){
                uniqueIPs.add(ipAddr);
                uniqueIPsStatus.add(status);
            }
        }
        return uniqueIPsStatus.size();
    }

    public static void main(String[] args) {
            TesterTwo tester=  new TesterTwo();
            tester.testLogAnalyzer();
            tester.testUniqueIP();
            tester.testUniqueIPVisitsOnDay();
            tester.testCountUniqueIPsInRange();
    }

}


class TesterTwo{
    public void testLogAnalyzer(){
        LogAnalyzer read = new LogAnalyzer();
        read.readFile("short-test_log");
        read.printAll();
    }

    public void testUniqueIP(){
        LogAnalyzerTwo read = new LogAnalyzerTwo();
        read.readFile("short-test_log");
        System.out.println("There are " + read.countUniqueIPs()+ " different IPs");
    }

    public void testUniqueIPVisitsOnDay(){
        LogAnalyzerTwo read = new LogAnalyzerTwo();
        read.readFile("short-test_log");
        read.countUniqueIPs();
        ArrayList a = read.uniqueIPVisitsOnDay("Sep 24");
        System.out.println(a.size());
    }

    public void testCountUniqueIPsInRange(){
        LogAnalyzerTwo read = new LogAnalyzerTwo();
        read.readFile("short-test_log");
        System.out.println(read.countUniqueIPsInRange(200,299));
    }
}


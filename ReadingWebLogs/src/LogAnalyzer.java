import edu.duke.FileResource;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;


public class LogAnalyzer{
    private ArrayList<LogEntry> logList;

    LogAnalyzer(){
         logList=new ArrayList<LogEntry>();
     }

     public void readFile(String s){
        FileResource fileResource = new FileResource();
         for (String line: fileResource.lines()
              ) {
             LogEntry entry = WebLogParser.parseEntry(line);
             logList.add(entry);
         }
     }

    public void printAll() {
        for (LogEntry le : logList) {
            System.out.println(le);
        }
    }

    public static void main(String[] args) {
        Tester tester=  new Tester();
        tester.testLogAnalyzer();
    }

}

class Tester{
     public void testLogAnalyzer(){
         LogAnalyzer read = new LogAnalyzer();
         read.readFile("short-test_log");
         read.printAll();
     }

}

class LogEntry{
    private String ipAddress;
    private Date accessTime;
    private String request;
    private int statusCode;
    private int bytesReturned;

    public LogEntry(String ip, Date time, String req, int status, int bytes) {
        ipAddress = ip;
        accessTime = time;
        request = req;
        statusCode = status;
        bytesReturned = bytes;

    }

    public String getIpAddress() {
        return ipAddress;
    }
    public Date getAccessTime() {
        return accessTime;
    }
    public String getRequest() {
        return request;
    }
    public int getStatusCode() {
        return statusCode;
    }
    public int getBytesReturned() {
        return bytesReturned;
    }

    public String toString() {
        return ipAddress + " " + accessTime + " " + request
                + " " + statusCode + " " + bytesReturned;
    }
}

class WebLogParser {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy:kk:mm:ss Z", Locale.US);

    private static String munchTo(StringBuilder sb, String delim) {
        int x = sb.indexOf(delim);
        if (x == -1) {
            x = sb.length();
        }
        String ans = sb.substring(0,x);
        sb.delete(0, x + delim.length());
        return ans;
    }

    public static LogEntry parseEntry(String line) {

        StringBuilder sb = new StringBuilder(line);
        String ip = munchTo(sb, " ");
        munchTo(sb, " ");
        munchTo(sb, " [");
        String dateStr = munchTo(sb, "] \"");
        Date date = parseDate(dateStr);
        String request = munchTo(sb, "\" ");
        String statusStr = munchTo(sb, " ");
        int status = Integer.parseInt(statusStr);
        String byteStr = munchTo(sb, " ");
        int bytes = Integer.parseInt(byteStr);
        return new LogEntry(ip, date, request, status, bytes);
    }

    public static Date parseDate(String dateStr) {
        ParsePosition pp = new ParsePosition(0);
        return  dateFormat.parse(dateStr, pp);
    }

}
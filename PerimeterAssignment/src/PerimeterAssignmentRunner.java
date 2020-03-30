import edu.duke.*;
import java.io.File;

//question link - https://www.coursera.org/learn/java-programming/supplement/s3GE0/calculating-the-perimeter-of-a-shape

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int noPoints = 0;
        for (Point p: s.getPoints()) {
            noPoints++;
        }
        return noPoints;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        // Start with totalLength = 0
        double totalLength = 0.0;
        int noSide = 0;
        // Start wth prevPt = the last point
        Point prevPt = s.getLastPoint();

        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt
            double currDist = prevPt.distance(currPt);
            // Update totalLength by currDist
            totalLength = totalLength + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
            noSide++;
        }
        double avgLength=totalLength/noSide;
        // totalLength is the answer
        return avgLength;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        double largestSide = 0.0;
        double sideLength = 0.0;
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt
            sideLength = prevPt.distance(currPt);
            if(sideLength>largestSide)
                largestSide=sideLength;
        }
        return largestSide;
    }

    public double getLargestX(Shape s) {
        // Put code here
        double val_X;
        double max_X = 0;
        for (Point currPt: s.getPoints() ) {
            val_X=currPt.getX();

            if(val_X>max_X) max_X=val_X;
        }
        return max_X;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        double currPerimeter=0.0;
        double maxPerimeter=0.0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape shape = new Shape(fr);
            currPerimeter=getPerimeter(shape);
            if (currPerimeter>maxPerimeter)
                maxPerimeter=currPerimeter;
        }
        return maxPerimeter;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here

        File currFile = null;    // replace this code
        double currPerimeter=0.0;
        double maxPerimeter=0.0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape shape = new Shape(fr);
            currPerimeter=getPerimeter(shape);
            if (currPerimeter>maxPerimeter){
                maxPerimeter=currPerimeter;
                currFile=f;
            }
        }
        return currFile.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        int points = getNumPoints(s);
        System.out.println("points = " + points);
        double avgLength = getAverageLength(s);
        System.out.println("Average Length = " + avgLength);
        double lSide = getLargestSide(s);
        System.out.println("Largest Side = " +lSide);
    }

    public void testPerimeterMultipleFiles() {
        String fName = getFileWithLargestPerimeter();
        System.out.println("File with largest perimeter "+fName);

    }

    public void testFileWithLargestPerimeter() {
        String fileName=getFileWithLargestPerimeter();
        System.out.println("testFileWithLargestPerimeter:"+fileName);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
        pr.testPerimeterMultipleFiles();
    }
}

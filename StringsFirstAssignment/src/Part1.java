//question link - https://www.coursera.org/learn/java-programming/supplement/T8W0j/programming-exercise-finding-a-gene-and-web-links

public class Part1 {
    public String findSimpleGene(String dna){

        String ans="";
        int indexStart=dna.indexOf("ATG");
        int indexStop=dna.indexOf("TAA");
        int len=0;

        System.out.println("Input String is: "+dna);

        if(indexStart==-1 && indexStop==-1) {
            System.out.println("ATG not found: ");
            System.out.println("TAA not found: ");

        }

        else if(indexStart!=-1 && indexStop==1){
            System.out.println("TAA not found: ");
            System.out.println("Start index ATG: "+indexStart);

        }

        else if(indexStart==1 && indexStop!=-1) {
            System.out.println("ATG not found: ");
            System.out.println("Stop index TAA: "+indexStop);

        }

        else
        {
            System.out.println("The String contains ATG and DNA");
            len=indexStart+3-indexStop;
            if (len%3==0){

                System.out.println("Substring in middle multiple of 3");
                return dna.substring(indexStart,indexStop+3);
            }
            System.out.println("Substring in middle not multiple of 3");
        }
        return ans;

    }
     public void testSimpleGene(){
         findSimpleGene("ASCDSATAA");
         findSimpleGene("ATGABCASD");
         findSimpleGene("ASDFGHJKL");
         findSimpleGene("ATGASDTAA");
         findSimpleGene("ATGABTAA");
     }
     public static void main(String[] args){
        Part1 p = new Part1();
        p.testSimpleGene();
     }
}

//question link - https://www.coursera.org/learn/java-programming/supplement/FzhKr/programming-exercise-finding-many-genes

public class Part1 {

    public int findStopCodon(String dna,int startIndex,String stopCodon) {
        int firstOccurence=0;
        int result=0;
        int answer=0;
        firstOccurence = dna.indexOf(stopCodon);
        if (dna.contains(stopCodon) && firstOccurence != -1 && firstOccurence%3==0) {
            result = firstOccurence;
        }
        else{
            System.out.println("Not found: "+stopCodon);
        }
        return result;
    }

    public String findGene(String dna) {
        int startFirstOccurence = dna.indexOf("ATG");
        int stopFirstOccurence = 0;
        String ans="";
        int result = 0;

        if (startFirstOccurence != -1) {
            System.out.println("TAA: " + findStopCodon(dna, startFirstOccurence, "TAA"));
            System.out.println("TAG: " + findStopCodon(dna, startFirstOccurence, "TAG"));
            System.out.println("TGA: " + findStopCodon(dna, startFirstOccurence, "TGA"));
            String stopCodonArr[] = {"TAA", "TAG", "TGA"};

            for (int i = 0; i < stopCodonArr.length; i++) {
                stopFirstOccurence = dna.indexOf(stopCodonArr[i]);
                if (dna.contains(stopCodonArr[i]) && stopFirstOccurence != -1 && stopFirstOccurence % 3 == 0) {
                    result = stopFirstOccurence;
                    ans = dna.substring(startFirstOccurence, stopFirstOccurence + 3);
                }
            }
        }

        else {
            ans = "";
        }

        return ans;
    }

    public void testFindGene() {
        System.out.println(findGene("ATGFDSTAA"));
        System.out.println(findGene("ATGFDSTAG"));
        System.out.println(findGene("ATGFDSTGA"));
        System.out.println(findGene("ATGTHGFDS"));
    }

    public void testFindStopCodon() {
            System.out.println("Stop codon is "+findStopCodon("ATGASDTAA",0,"TAA"));
    }

    public static void main(String[] args) {
            Part1 part1=new Part1();
            part1.testFindStopCodon();
            part1.testFindGene();
    }
}

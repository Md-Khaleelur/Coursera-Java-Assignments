public class Part3 {

    public int findStopCodon(String dna,int startIndex,String stopCodon) {
        int firstOccurence=0;
        int result=0;
        int answer=0;

        firstOccurence = dna.indexOf(stopCodon);
        if (dna.contains(stopCodon) && firstOccurence != -1 && firstOccurence%3==0) {
            result = firstOccurence;
        }
        else{
            System.out.println("Not found");
            result=dna.length();
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

    public void testFindGene(){
        System.out.println(findGene("ATGFDSTAA"));
        System.out.println(findGene("ATGFDSTAG"));
        System.out.println(findGene("ATGFDSTGA"));
        System.out.println(findGene("ATGTHGFDS"));
    }

    public int countGenes(String dna){

        int startFirstOccurence = dna.indexOf("ATG");
        int stopFirstOccurence = 0;
        String ans="";
        int result = 0;
        int count=0;

        if (startFirstOccurence != -1) {

            String stopCodonArr[] = {"TAA", "TAG", "TGA"};

            for (int i = 0; i < stopCodonArr.length; i++) {
                stopFirstOccurence = dna.indexOf(stopCodonArr[i]);
                if (dna.contains(stopCodonArr[i]) && stopFirstOccurence != -1 && stopFirstOccurence % 3 == 0) {
                    result = stopFirstOccurence;
                    ans = dna.substring(startFirstOccurence, stopFirstOccurence + 3);
                    count++;
                }
            }
        }

        return count;
     }

    public static void main(String[] args) {
        Part3 p3 = new Part3();
        System.out.println(p3.countGenes("ATGCCCTAGGHTTGA"));
    }
}

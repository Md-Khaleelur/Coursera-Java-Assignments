import edu.duke.StorageResource;

public class Part1 {
    public StorageResource getAllGenes(String dna) {
        int startFirstOccurence =0;
        int stopFirstOccurence = 0;
        String ans="";
        int result = 0;
        StorageResource storageResource=new StorageResource();

        startFirstOccurence = dna.indexOf("ATG");

        if (startFirstOccurence != -1) {
            String stopCodonArr[] = {"TAA", "TAG", "TGA"};

            for (int i = 0; i < stopCodonArr.length; i++) {
                stopFirstOccurence = dna.indexOf(stopCodonArr[i]);
                if (dna.contains(stopCodonArr[i]) && stopFirstOccurence != -1 && stopFirstOccurence % 3 == 0) {
                    result = stopFirstOccurence;
                    ans = dna.substring(startFirstOccurence, stopFirstOccurence + 3);
                    storageResource.add(ans);
                }
            }
        }

        else {
            ans = "";
        }

        return storageResource;
    }


    public void testGetAllGenes(){
        System.out.println(getAllGenes("ATGFDSTAA"));
        System.out.println(getAllGenes("ATGFDSTAG"));
        System.out.println(getAllGenes("ATGFDSTGA"));
        System.out.println(getAllGenes("ATGTHGFDS"));

    }

    public static void main(String[] args) {
        Part1 part1 = new Part1();
        part1.testGetAllGenes();
    }


}

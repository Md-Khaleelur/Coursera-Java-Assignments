public class Part2 {

    public String findSimpleGene(String dna, String startCodon, String stopCodon){

        String ans="";
        String start;
        String stop;
        char firstChar=dna.charAt(0);
        if (Character.isUpperCase(firstChar)) {
            start = startCodon;
            stop = stopCodon;
        }
        else{
            start = startCodon.toLowerCase();
            stop = stopCodon.toLowerCase();
        }

        int indexStart=dna.indexOf(startCodon);
        int indexStop=dna.indexOf(stopCodon);
        int len=0;

        System.out.println("Input String is: "+dna);

        if(indexStart==-1 && indexStop==-1) {
            System.out.println("ATG not found: ");
            System.out.println("TAA not found: ");

        }

        else if(indexStart!=-1 && indexStop==-1){
            System.out.println("TAA not found: ");
            System.out.println("Start index ATG: "+indexStart);

        }

        else if(indexStart==-1 && indexStop!=-1) {
            System.out.println("ATG not found: ");
            System.out.println("Stop index TAA: "+indexStop);

        }

        else
        {
            System.out.println("The String contains ATG and DNA");
            len=indexStart+3-indexStop;

            if (len%3==0){
                return dna.substring(indexStart,indexStop+3);
            }

            System.out.println("Substring in middle not multiple of 3");
        }
        return ans;
    }

    public void testSimpleGene(){

        findSimpleGene("ASCDSATAA","ATG","TAA");
        findSimpleGene("ATGABCASD","ATG","TAA");
        findSimpleGene("ASDFGHJKL","ATG","TAA");
        findSimpleGene("ATGASDTAA","ATG","TAA");
        findSimpleGene("ATGABTAA","ATG","TAA");
        findSimpleGene("ATGABTAA","ATG","TAA");
        findSimpleGene("atgtgdtaa","atg","taa");


    }

    public static void main(String[] args) {

        Part2 p2=new Part2();
        p2.testSimpleGene();

    }

}

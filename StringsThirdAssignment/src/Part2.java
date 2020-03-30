public class Part2 {
    public String cgRatio(String dna){
        String cgRatio ;
        int countOfC=0;
        int countOfG=0;

        for(int i=0;i<dna.length();i++){
            if (dna.charAt(i)=='C') countOfC++;
            if (dna.charAt(i)=='G') countOfC++;
        }

        cgRatio = countOfC+"/"+countOfG;

        return cgRatio;
    }

    public int countCTG(String dna){
        int i=0;
        int j,count=0;
        String stringa="CTG";

        i=dna.indexOf(stringa);
        if(i>-1) {
            count++;
            for (j = i; j < dna.length(); j++) {
                i = dna.indexOf(stringa, j + stringa.length());
                if (i!=-1)  count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Part2 part2=new Part2();
        System.out.println("CG Ratio"+part2.cgRatio("ATGSDFTAATGA"));
        System.out.println(part2.countCTG("ATGCCCGTCASD"));
        System.out.println(part2.countCTG("ATGFDSGTCGTC"));
        System.out.println(part2.countCTG("ATGCTGAHSGDF"));
    }
}

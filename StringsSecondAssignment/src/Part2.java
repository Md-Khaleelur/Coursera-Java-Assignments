public class Part2 {
    public int noOfOccurences(String stringa,String stringb){
        int i=0;
        int j,count=0;

        i=stringb.indexOf(stringa);
        if(i>-1) {
            count++;
            for (j = i; j < stringb.length(); j++) {
                i = stringb.indexOf(stringa, j + stringa.length());
                if (i!=-1)  count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Part2 part2=new Part2();
        System.out.println(part2.noOfOccurences("ana","banana"));
        System.out.println(part2.noOfOccurences("an","banana"));
        System.out.println(part2.noOfOccurences("x","banana"));
    }
}

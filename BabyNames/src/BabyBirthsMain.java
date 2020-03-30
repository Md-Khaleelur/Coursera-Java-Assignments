public class BabyBirthsMain {

    public static void main(String[] args) {
        BabyBirths b = new BabyBirths();
        System.out.println(b.getRank(1971, "Frank", "F"));
        System.out.println(b.getName(1982, 450, "M"));
        System.out.println(b.getTotalBirthsRankedHigher(1990, "Drew", "M"));

    }
}

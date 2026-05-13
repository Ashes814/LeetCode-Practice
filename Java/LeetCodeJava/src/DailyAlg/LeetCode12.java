package DailyAlg;

public class LeetCode12 {
    public static void main(String[] args) {
        System.out.println("Hello Java!");
        System.out.println(new LeetCode12().inToRoman(1994));
    }

    String inToRoman(int num) {
        String[] M ={"", "M", "MM", "MMM"};
        String[] C = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] X = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] I = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        return M[num / 1000] + C[(num % 1000) / 100] + X[(num % 100) / 10] + I[num % 10];

    }
}

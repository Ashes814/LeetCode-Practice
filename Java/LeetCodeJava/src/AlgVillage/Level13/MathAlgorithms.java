package AlgVillage.Level13;

/**
 * @author 欧欧
 * @version 1.0
 */
public class MathAlgorithms {
    public static void main(String[] args) {
        System.out.println(trailingZeros());
    }

    public static int arraySign(int[] nums) {
        int negCount = 0;
        for (int n: nums) {
            if (n == 0) {
                return 0;
            }
            if (n < 0) {
                negCount++;
            }
        }

        if ((negCount % 2) == 0) {
            return 1;
        } else {
            return -1;
        }
    }


    public static int trailingZeros(int n) {
        // return how many 0 in the end of n!
        // n! = 1 * 2 * 3 * ... * n
        // you just need to calculate haw many pairs of 2 * 5, 2 is more than 5 (obvious)
        int n_counts = 0;
        for (int i = 1; i<=n; i++) {
            if (i % 5 == 0) {
                n_counts += i / 5;
            }
        }
        return n_counts;

    }


}

package AlgBlog.DigitCalculation;

public class DigitCal {
    public static void main(String[] args) {

    }

    public static int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }

        return count;
    }

    public static int[] countBits(int n) {
        int[] res = new int[n+1];
        for (int i = 0; i <= n; i++) {
            int bit = i;
            int ones = 0;
            while (bit != 0) {
                bit = bit & (bit - 1);
                ones++;
            }
            res[i] = ones;

        }
        return res;
    }
}

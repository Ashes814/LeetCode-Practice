package AlgVillage.Level11;

/**
 * @author 欧欧
 * @version 1.0
 */
public class BitCalculation {
    public static void main(String[] args) {
//        System.out.println(hammingWeight03(0000000000000000000000000001011));
//        int[] test = countBits(5);
//        for (int i = 0; i < test.length ; i++) {
//            System.out.println(test[i]);
//        }
        System.out.println(reverseBits(94967293));
    }

    // Leetcode 191
    public static int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++){
            count += (n >> i) & 1;
        }
        return count;
    }

    public static int hammingWeightLeft(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++){
            if (((n) & (1 << i)) > 0) {
                count += 1;
            }
        }
        return count;
    }

    public static int hammingWeight03(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count += 1;
        }
        return count;
    }

    public static int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            ans[i] = hammingWeight03(i);
        }
        return ans;
    }

    public static int reverseBits(int n) {
        int reversed = 0;
        int power = 31;
        while (n != 0) {
            reversed += (n & 1) << power;
            n = n >>> 1;
            power--;
        }
        return reversed;
    }
}

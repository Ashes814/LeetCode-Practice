package AlgVillage.Level11;

/**
 * @author 欧欧
 * @version 1.0
 */
public class BitCalculation {
    public static void main(String[] args) {
        System.out.println(hammingWeight03(0000000000000000000000000001011));

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

    
}

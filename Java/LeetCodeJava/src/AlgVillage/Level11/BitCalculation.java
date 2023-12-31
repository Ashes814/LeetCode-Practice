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
        System.out.println(multiply(5,3));
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

    public static int getSum(int a, int b) {
        while (b != 0) {
            int sign = (a & b) << 1; //进位部分
            a = a ^ b; //不进位部分
            b = sign; //之后每次循环相当于吧不进位部分a与进位部分sign相加，若sign位0，则表示不用再加不进位部分了，退出循环
        }
        return a;
    }

    public static int multiply(int a, int b) {
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        int ans = 0;
        for (int i = 0; min != 0; i++) {

            if ((min & 1) == 1) {
                ans += max;
            }

            // min 右移一位，相当于除以2
            min >>= 1;
            // min 除以2后，相当于max 乘 2
            max += max;
        }
        return ans;
    }
}

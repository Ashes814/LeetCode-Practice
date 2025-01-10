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

    public int reverseBits(int n) {
        int res = 0;
        int power = 31;
        while (power >= 0) {
            int lastDigit = n & 1;
            int newDigit = lastDigit << power;
            res += newDigit;
            n = n >>> 1;
            power--;
        }
        return res;
    }

    public int getSum(int a, int b) {
        while (b != 0) {
            int sign = (a & b) << 1;
            a = a ^ b;
            b = sign;
        }
        return a;
    }


    public int multiply(int A, int B) {
        int min = Math.min(A,B);
        int max = Math.max(A,B);
        int res = 0;

        while (min != 0) {

            if ((min & 1) == 1) {
                res += max;
            }
            min = min >> 1;
            max += max;


        }
        return res;
    }

    public void checkDuplicates(int[] array) {
        BitSet bs = new BitSet(32000);
        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            int num0 = num - 1;
            if (bs.get(num0)) {
                System.out.println(num);
            } else {
                bs.set(num0);
            }
        }
    }

    class BitSet {
        int[] bitSet;

        public BitSet(int size) {
            this.bitSet = new int[size>>5];
        }

        boolean get(int pos) {
            int wordNumber = pos >> 5;
            int bitNumber = pos & 0x1F;
            return (bitSet[wordNumber] & (1 << bitNumber)) != 0;

        }

        void set(int pos) {
            int wordNumber = pos >> 5;
            int bitNumber = pos & 0x1F;
            bitSet[wordNumber] |= 1 << bitNumber;
        }
    }

}

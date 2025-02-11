package AlgBlog.MathAlg;

import com.sun.org.apache.xpath.internal.operations.Bool;

public class MathAlgPrac {
    public static void main(String[] args) {

    }

    public int arraySign(int[] nums) {
        int sign = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                sign *= -1;
            } else if (nums[i] > 0) {
                sign *= 1;

            } else {
                return 0;
            }
        }
        return sign;
    }

    public int trailingZeroes(int n) {
        int count = 0;
        for (long i = 5; n / i > 0; i *= 5) {
            count += n/i;
        }
        return count;
    }

    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int tmp = x % 10;
            if (res > Integer.MAX_VALUE / 10 || ((res == Integer.MAX_VALUE / 10) && (tmp > 7))) {
                return 0;
            }

            if (res < -214748364 || ((res == -214748364) && (tmp < -8))) {
                return 0;
            }

            res = res * 10 + tmp;
            x = x / 10;


        }
        return res;
    }

    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revNum = 0;
        while (x > revNum) {
            revNum = revNum * 10 + x % 10;
            x = x / 10;
        }
        return x == revNum || x == revNum / 10;



    }

    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        int sign = 0;
        if (num < 0) {
            num = -num;
            sign = -1;
        }

        while (num > 0) {
            sb.append(num % 7 + "");
            num /= 7;
        }

        if (sign == -1) {
            sb.append("-");
        }

        return sb.reverse().toString();
    }

    public String convert(int M, int N) {
        String[] F = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
        Boolean flag = false;
        if (M < 0) {
            flag = true;
            M = -M;
        }
        StringBuffer sb = new StringBuffer();
        int temp;
        while (M != 0) {
            temp = M % N;
            sb.append(F[temp]);
            M /= N;
        }
        sb.reverse();
        if (flag) {
            return "-" + sb.toString();
        } else {
            return sb.toString();
        }
    }
}

package AlgBlog.MathAlg;

import com.sun.org.apache.xpath.internal.operations.Bool;

public class MathAlgPrac {
    public static void main(String[] args) {
        int[] testInt = {9};
        plusOne(testInt);
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

    public static int[] plusOne(int[] digits) {
        int finalPosition = digits.length - 1;
        int flag = 1;
        while (finalPosition >= 0 && flag == 1) {
            int newDigits = digits[finalPosition] + 1;
            if (newDigits >= 10) {
                digits[finalPosition--] = 0;

            } else {
                digits[finalPosition--] = newDigits;
                flag = 0;
            }

        }
        if (flag == 1) {
           int[] newArray = new int[digits.length + 1];
           newArray[0] = 1;
           for (int i = 1; i < newArray.length; i++) {
                newArray[i] = digits[i - 1];
           }
           return newArray;

        }
        return digits;
    }

    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int add = 0;
        StringBuffer ans = new StringBuffer();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;

        }
        ans.reverse();
        return ans.toString();
    }

    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int add = 0;
        StringBuffer ans = new StringBuffer();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? a.charAt(i) - '0' : 0;
            int y = j >= 0 ? b.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.append(result % 2);
            add = result / 2;
            i--;
            j--;

        }
        ans.reverse();
        return ans.toString();
    }

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }

        while (n % 2 == 0) {
            n /= 2;
        }

        return n == 1;
    }
}

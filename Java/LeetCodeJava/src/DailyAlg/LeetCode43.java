package DailyAlg;

import java.math.BigInteger;

public class LeetCode43 {


    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] res = new int[m + n]; // 结果最长 m+n 位

        // 从后往前逐位相乘
        for (int i = m - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';

                int mul = n1 * n2; // 两个数字相乘
                int sum = mul + res[i + j + 1]; // 加原来的值

                res[i + j + 1] = sum % 10; // 当前位
                res[i + j] += sum / 10;    // 进位
            }
        }

        // 转字符串，去掉前导 0
        StringBuilder sb = new StringBuilder();
        for (int num : res) {
            if (!(sb.length() == 0 && num == 0)) { // 跳过开头的0
                sb.append(num);
            }
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}

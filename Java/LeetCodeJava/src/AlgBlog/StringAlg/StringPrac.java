package AlgBlog.StringAlg;

public class StringPrac {
    public static void main(String[] args) {


    }

    public String toLowerCase(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        for (int i = 0; i < n; i++) {
            if (chars[i] >= 65 && chars[i] <= 90) {
                chars[i] += 32;
            }

        }
        return new String(chars);
    }

    public int myAtoi(String s) {
        char[] chars = s.toCharArray();
        int len = s.length();
        int index = 0;
        while (index < len && chars[index] == ' ') {
            index++;
        }

        int sign = 1;
        if (chars[index] == '+') {
            index++;
        } else if (chars[index] == '-') {
            index++;
            sign = -1;

        }
        int res = 0;
        while (index < len) {
            if (chars[index] < '0' || chars[index] > '9' ) {
                break;
            }


            if ((res > Integer.MAX_VALUE / 10) || (res == Integer.MAX_VALUE / 10 && (chars[index] - '0') > (Integer.MAX_VALUE % 10))) {
                return Integer.MAX_VALUE;
            }

            if ((res < Integer.MIN_VALUE / 10) || (res == Integer.MIN_VALUE / 10 && (chars[index] - '0') > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }
            res = res * 10 + sign * (chars[index] - '0');
            index++;
        }

        return res;
    }
}

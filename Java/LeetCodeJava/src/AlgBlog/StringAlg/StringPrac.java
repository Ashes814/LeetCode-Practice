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

    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        for (int i = 0; i < len; i += 2*k) {
            reverse(chars, i, Math.min(i + k, len) - 1);
        }
        return new String(chars);
    }

    public void reverse(char[] s, int left, int right) {
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    public String reverseOnlyLetters(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (!Character.isLetter(chars[left])) {
                left++;
            }
            if (!Character.isLetter(chars[right])) {
                right--;
            }
            if (Character.isLetter(chars[left]) && Character.isLetter(chars[right])) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }
        return new String(chars);
    }
}

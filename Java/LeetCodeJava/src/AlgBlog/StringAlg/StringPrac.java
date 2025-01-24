package AlgBlog.StringAlg;

import java.util.Arrays;
import java.util.HashMap;

public class StringPrac {
    public static void main(String[] args) {
        String testStr = "the sky is blue";
        System.out.println(reverseWords(testStr));

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

    public static void reverse(char[] s, int left, int right) {
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

    public static String reverseWords(String s) {
        int start = 0;
        int end = s.length() - 1;
        char[] chars = s.toCharArray();
        while (chars[start] == ' ') {
            start++;
        }
        while (chars[end] == ' ') {
            end--;
        }
        reverse(chars, start, end);
        for (int i = start; i <= end; i++) {
            if (chars[i] == ' ') {
                continue;
            }
            int left = i;
            while (i <= end && chars[i] != ' '   ) {
                i++;
            }
            int right = i - 1;
            if (i == end) {
                right = i;
            }

            reverse(chars, left, right);

        }

        StringBuilder sb = new StringBuilder();
        while (start <= end) {
            if (chars[start] != ' ') {
                sb.append(chars[start]);
            } else if (chars[start] == ' ' && chars[start - 1] != ' ') {
                sb.append(' ');
            }
            start++;
        }
        return sb.toString();


    }

    public boolean isPalindrome(String s) {


        int left = 0;
        int right = s.length() - 1;
        char[] chars = s.toCharArray();
        while (left < right) {
            if (Character.isLetterOrDigit(chars[left]) && Character.isLetterOrDigit(chars[right])) {
                if (Character.toLowerCase(chars[left]) != Character.toLowerCase(chars[right])) {
                    return false;
                }
                left++;
                right--;
            }

            if (!Character.isLetterOrDigit(chars[left])) {
                left++;
            }
            if (!Character.isLetterOrDigit(chars[right])) {
                right--;
            }


        }
        return true;
    }

    public int firstUniqChar(String s) {
        if (s == null) {
            return -1;
        }

        HashMap<Character, Integer> freq = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);

        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (freq.get(ch) == 1) {
                return i;
            }
        }
        return -1;

    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] charsA = s.toCharArray();
        char[] charsB = t.toCharArray();
        Arrays.sort(charsA);
        Arrays.sort(charsB);
        for (int i = 0; i < charsA.length; i++) {
            if (charsA[i] != charsB[i]) {
                return false;
            }
        }
        return true;
    }

    public String longestCommonPrefix(String[] strs) {
        int strsLength = strs.length;
        if (strsLength == 1) {
            return strs[0];
        }
        int minLength = Integer.MAX_VALUE;
        for (String str: strs) {
            minLength = Math.min(str.length(), minLength);
        }

        for (int i = 0; i < minLength; i++) {
            for (int j = 0; j < strsLength - 1; j++) {
                if (strs[j].charAt(i) == strs[j + 1].charAt(i)) {
                    continue;
                } else {
                    if (i == 0) {
                        return "";
                    } else {
                        return strs[j].substring(0, i);
                    }

                }

            }
        }
        return "";
    }
}

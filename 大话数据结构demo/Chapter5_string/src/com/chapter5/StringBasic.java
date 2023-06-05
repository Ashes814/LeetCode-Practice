package com.chapter5;

/**
 * @author 欧欧
 * @version 1.0
 */
public class StringBasic {
    public static void main(String[] args) {
        String testS = "abcdefghi";
        String testT = "sss";
        int value = CustomString.indexSequence(testS, testT, 0);
        System.out.println(value);

    }
}


class CustomString {
    private String data;

    public CustomString(String data) {
        this.data = data;
    }

    public static int index(String s, String t, int pos) {
        int n, m, i;
        String sub;
        if (pos >= 0) {
            n = s.length();
            m = t.length();
            i = pos;
            while (i <= n - m - 1) {
                sub = s.substring(i, i + m);

                if (sub.compareTo(t) != 0) {
                    ++i;
                } else {
                    return i;
                }

            }
        }
        return -1;
    }

    public static int indexSequence(String s, String t, int pos) {
        int sLength = s.length();
        int tLength = t.length();

        for (int i = 0; i <= s.length() - 1;) {
            for (int j = 0; j <= t.length() - 1;) {
                if (t.substring(j, j + 1).equals(s.substring(i, i + 1))) {
                    if (j == t.length() - 1) {
                        return i - t.length() + 1;
                    }
                    i++;
                    j++;

                } else {
                    i = i - j + 1;
                    break;
                }
            }
        }
        return -1;
    }
}
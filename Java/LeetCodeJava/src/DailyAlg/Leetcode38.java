package DailyAlg;

import java.util.ArrayList;

public class Leetcode38 {
    public static void main(String[] args) {
        String r = countAndSay(4);
        System.out.println(r);
    }
    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        } else {
            return RLE(countAndSay(n - 1));
        }
    }

    public static String RLE(String string) {
        if (string == null || string.isEmpty()) {
            return "";
        }

        char[] chars = string.toCharArray();
        ArrayList<Character> res = new ArrayList<>();

        int counts = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i-1]) {
                counts++;
            } else {
                res.add((char) (counts + '0'));
                res.add(chars[i - 1]);

                counts = 1;
            }
        }

        res.add((char) (counts + '0'));
        res.add(chars[chars.length - 1]);

        StringBuilder sb = new StringBuilder();
        for (char c : res) {
            sb.append(c);
        }

        return sb.toString();
    }
}

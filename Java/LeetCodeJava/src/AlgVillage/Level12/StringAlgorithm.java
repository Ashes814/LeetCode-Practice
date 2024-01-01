package AlgVillage.Level12;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author 欧欧
 * @version 1.0
 */
public class StringAlgorithm {
    public static void main(String[] args) {
        String testString = "aBcde";
        System.out.println(toLowerCase(testString));
    }

    public static String toLowerCase(String s) {
        ArrayList<Character> res = new ArrayList<>();
        for (char c: s.toCharArray()) {
            if (c <= 90 && c >=65) {
                char newC = (char) (c + 32);
                res.add(newC);
            } else {
                res.add(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : res) {
            sb.append(c);
        }


        return sb.toString();
    }
}

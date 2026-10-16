package DailyAlg;

import java.util.ArrayList;
import java.util.List;

public class LeetCode49 {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams(strs);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        int[] ind = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {

            if (ind[i] == 0) {
                ArrayList<String> temp = new ArrayList<>();
                String curString = strs[i];
                temp.add(curString);
                ind[i] = 1;
                for (int j = i + 1; j < strs.length; j++) {
                    if (ind[j] == 0 && isAnagrams(curString, strs[j])) {
                        temp.add(strs[j]);
                        ind[j] = 1;
                    }

                }
                res.add(temp);
            }


        }
        return res;

    }

    public static boolean isAnagrams(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        int[] count = new int[26];

        for (char s1 : str1.toCharArray()) {
            count[s1 - 'a']++;
        }

        for (char s2 : str2.toCharArray()) {
            count[s2 - 'a']--;

            if (count[s2 - 'a'] < 0) {
                return false;
            }
        }

        return true;


    }
}
//

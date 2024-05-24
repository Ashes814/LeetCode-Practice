package AlgVillage.Level16;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MovingWindow {
    public static void main(String[] args) {
        int[] testArray = {1, 12, 13, 15, 5, 3};
//        System.out.println(findMaxAverage(testArray, 4));
//        System.out.println(findLengthOfLCIS(testArray));
//        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstringTwoDistinct("aabbcccd"));
    }

    public static double calAverage(int start, int k, int[] nums) {
        System.out.println(start);
        double sum = nums[start];
        for (int i = start + 1; i < start + k; i++) {

            sum = sum + nums[i];
        }

        return sum / k;
    }

    public static double findMaxAverage(int[] nums, int k) {
        if (nums.length <= k) {
            double maxAverage = nums[0];
            for (int i = 0; i < nums.length; i++) {
                maxAverage += nums[i];
            }
            return maxAverage / nums.length;
        }
        double maxAverage = calAverage(0, k, nums);
        for (int i = 0; i <= nums.length - k; i++) {
            if (maxAverage < calAverage(i, k, nums)) {
                maxAverage = calAverage(i, k, nums);
            }
        }

        return maxAverage;
    }

    public static int findLengthOfLCIS(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int left = 0;
        int right = 1;
        int res = 0;
        int curRes = 1;
        while (left < nums.length) {
            if (right >= nums.length) {
                if (curRes >= res) {
                    res = curRes;
                    return res;
                } else {
                    return res;
                }
            }
            if (nums[right] > nums[right - 1]) {
                curRes++;
                right++;
            } else {
                if (curRes >= res) {
                    res = curRes;
                }
                left = right + 1;
                right++;
            }
        }
        return res;
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int left = 0;
        int curRes = 0;
        int res = 0;

        while (left < s.length()) {
            curRes = 0;
            Map stringMap = new HashMap();
            for (int i = left; i < s.length(); i++) {
                if (stringMap.containsKey(s.charAt(i))) {
                    left++;
                    if (curRes >= res) {
                        res = curRes;
                    }
                    break;
                }
                stringMap.put(s.charAt(i), 1);
                curRes++;

                if (i == s.length() - 1) {
                    left++;
                }

            }
        }

        return res;
    }

    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s.length() < 3) {
            return s.length();
        }
        int left = 0, right = 0;
        HashMap<Character, Integer> hashmap = new HashMap<>();
        int maxLen = 2;

        while (right < s.length()) {
            if (hashmap.size() < 3) {
                hashmap.put(s.charAt(right), right++);
            }

            if (hashmap.size() == 3) {
                int del_idx = Collections.min(hashmap.values());
                hashmap.remove(s.charAt(del_idx));
                left = del_idx + 1;
            }

            maxLen = Math.max(maxLen, right - left);
        }

        return maxLen;
    }


}

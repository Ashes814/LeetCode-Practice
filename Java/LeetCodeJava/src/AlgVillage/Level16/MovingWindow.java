package AlgVillage.Level16;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class MovingWindow {
    public static void main(String[] args) {
        int[] testArray = {1,8,6,2,5,4,8,3,7};
        int [] testArray2 = {1, 1};
//        System.out.println(findMaxAverage(testArray, 4));
//        System.out.println(findLengthOfLCIS(testArray));
//        System.out.println(lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(lengthOfLongestSubstringTwoDistinct("aabbcccd"));
//        System.out.println(maxArea(testArray2));
        System.out.println(checkInclusion("ab", "eidboaooo"));
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

    public static int minSubArrayLen(int target, int[] nums) {
       int left = 0, right = 0, sum = 0, min = Integer.MAX_VALUE;
       while (right < nums.length) {
           sum += nums[right++];
           while (sum >= target) {
               min = Math.min(min, right - left);
               sum -= nums[left++];
           }
       }
       return min == Integer.MAX_VALUE ? 0 : min;

    }

    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1, area = 0, curArea = 0;
        while (right > left) {
            curArea = (right - left) * (Math.min(height[left], height[right]));
            if (curArea > area) {
                area = curArea;
            }
            if (height[right] > height[left]) {
                left++;
            } else {
                right--;
            }
        }
        return area;
    }

    public static boolean ifResort(String s1, String s2) {
        int[] charArrayS1 = new int[26];
        int[] charArrayS2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            charArrayS1[s1.charAt(i) - 'a']++;
            charArrayS2[s2.charAt(i) - 'a']++;

        }

        return Arrays.equals(charArrayS1, charArrayS2);
    }

    public static boolean checkInclusion(String s1, String s2) {
        int s1Length = s1.length();
        int s2Length = s2.length();
        if (s1Length > s2Length) return false;

        int start = 0;
        while (start <= s2Length - s1Length) {
            if (ifResort(s1, s2.substring(start, start + s1Length))) {
                return true;
            }
            start++;
        }
        return false;

    }


    public static List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();

        ArrayList<Integer> res = new ArrayList<Integer>();
        if (sLen < pLen) {
            return res;
        }

        int start = 0;

        while (start <= sLen - pLen) {
            if (ifResort(s.substring(start, start+pLen), p)) {
                res.add(start);
            }
            start++;

        }
        return res;
    }


}

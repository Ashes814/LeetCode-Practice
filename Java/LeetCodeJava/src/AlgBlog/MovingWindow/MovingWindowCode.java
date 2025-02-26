package AlgBlog.MovingWindow;

import java.util.*;

public class MovingWindowCode {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        maxSlidingWindow(nums, k);
    }

    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        double avg = 0;
        if (nums.length <= k) {

            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
            }
            return sum / nums.length;
        }

        int left = 0;
        int right = k - 1;
        int len = nums.length;
        for (int i = left; i <= right; i++) {
            sum += nums[i];
        }
        avg = sum / k;
        while (right < len - 1) {
            sum += nums[++right];
            sum -= nums[left++];
            avg = Math.max(avg, sum / k);
        }
        return avg;
    }

    public int findLengthOfLCIS(int[] nums) {
        int left = 0;
        int right = 0;
        int len = nums.length;
        if (len <= 1) {
            return len;
        }

        int maxLength = 1;

        while (right < len - 1) {
            if (nums[right + 1] > nums[right]) {
                right++;
                maxLength = Math.max(maxLength, right - left + 1);
            } else {
                right++;
                left = right;

            }
        }
        return maxLength;
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int right = 0;right < s.length(); right++) {
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(left, map.get(s.charAt(right)) + 1);
            }
            map.put(s.charAt(right), right);
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    public int lengthOfLongestSubstringTwoDistinct(String s) {
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

    public int lengthOfLongestSubstringTwoDistinct(String s, int k) {
        if (s.length() < k + 1) {
            return s.length();
        }
        int left = 0, right = 0;
        HashMap<Character, Integer> hashmap = new HashMap<>();
        int maxLen = k;
        while (right < s.length()) {
            if (hashmap.size() < k + 1) {
                hashmap.put(s.charAt(right), right++);
            }

            if (hashmap.size() == k + 1) {
                int del_idx = Collections.min(hashmap.values());
                hashmap.remove(s.charAt(del_idx));
                left = del_idx + 1;
            }

            maxLen = Math.max(maxLen, right - left);

        }

        return maxLen;

    }

    public int minSubArrayLen(int target, int[] nums) {
        if (Arrays.stream(nums).sum() < target) {
            return 0;
        }
        int left = 0, right = 0;
        int cur = 0, curLen = 0;
        int minLen = Integer.MAX_VALUE;
        while (cur >= target || right < nums.length) {
            if ( cur < target) {
                cur += nums[right++];
                curLen++;
            }

            if (cur >= target) {
                minLen = Math.min(minLen, curLen);
                cur -= nums[left++];
                curLen--;
            }

        }
        return minLen;
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1];
            }
        });
        for (int i = 0; i < k; i++) {
            pq.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[n - k + 1];
        ans[0] = pq.peek()[0];
        for (int i = k; i < n; i++) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }
}

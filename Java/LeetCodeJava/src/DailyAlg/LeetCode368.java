package DailyAlg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class LeetCode368 {
    public static void main(String[] args) {
        int[] testNums = {4,8,10, 240};
        System.out.println(largestDivisibleSubset(testNums));
    }
    
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);

        int numsLen = nums.length;
        int[] dp = new int[numsLen];
        
        int maxSize = 1;
        int maxIndex = 0;
        for (int i = 0; i < numsLen; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = dp[i] + 1;
                }
            }
            if (dp[i] > maxSize) {
                maxSize = dp[i];
                maxIndex = i;
            }
        }

        List<Integer> res = new ArrayList<Integer>();
        res.add(nums[maxIndex]);
        maxSize--;

        for (int ii = maxIndex - 1; ii >= 0; ii--) {
            if (dp[ii] == maxSize && res.getFirst() % nums[ii] == 0 ) {
                res.add(nums[ii]);
                maxSize--;
            }
        }

        return res;
    }
}

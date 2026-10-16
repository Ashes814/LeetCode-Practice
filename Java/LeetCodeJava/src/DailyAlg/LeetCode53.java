package DailyAlg;

import java.util.Arrays;

public class LeetCode53 {
    public static void main(String[] args) {

    }

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] f = new int[n];
        f[0] = nums[0];
        for (int i = 1; i < n; i++) {
            if (f[i-1] > 0) {
                f[i] = f[i-1] + nums[i];
            } else {
                f[i] = nums[i];
            }
        }

        return Arrays.stream(f).max().getAsInt();
    }
}

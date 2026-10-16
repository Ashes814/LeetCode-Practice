package DailyAlg;

import java.util.Arrays;

public class LeetCode164 {
    public static void main(String[] args) {
        int[] nums = {3,6,9,1};
        maximumGap(nums);
    }

    public static int maximumGap(int[] nums) {

        int n = nums.length;
        if (n < 2) {
            return 0;
        }


        long exp = 1;
        int maxVal = Arrays.stream(nums).max().getAsInt();
        int[] buf = new int[n];

        while (maxVal >= exp) {
            int[] cnt = new int[10];
            for (int i = 0; i < n; i++) {
                int digit = (nums[i] / (int) exp) % 10;
                cnt[digit]++;
            }

            for (int i = 1; i < 10; i++) {
                cnt[i] += cnt[i - 1];
            }

            for (int i = n - 1; i >= 0; i--) {
                int digit = (nums[i] / (int) exp) % 10;
                buf[cnt[digit] - 1] = nums[i];
                cnt[digit]--;
            }

            System.arraycopy(buf, 0, nums, 0, n);
            exp *= 10;
        }

        int ret = 0;
        for (int i = 1; i < n; i++){
            if ((nums[i] - nums[i - 1]) > ret) {
                ret = nums[i] - nums[i - 1];
            }
        }

        return ret;

    }
}

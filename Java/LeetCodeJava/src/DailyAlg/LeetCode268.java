package DailyAlg;

import java.util.Arrays;

public class LeetCode268 {
    public static void main(String[] args) {

    }

    public int missingNumber(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) {
                return i;
            }
        }

        return 0;
    }
}

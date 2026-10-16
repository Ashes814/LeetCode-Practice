package DailyAlg;

public class LeetCode16 {
    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        System.out.println(threeSumClosest(nums, 1));

    }
    public static int threeSumClosest(int[] nums, int target) {
        int numLen = nums.length;
        if (numLen <= 3) {
            int res = 0;
            for (int i = 0; i < numLen; i++) {
                res += nums[i];
            }
            return res;
        }

//        int i = 0;
//        int j = 1;
//        int k = 2;
        int res = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < numLen - 2; i++) {
            for (int j = i + 1; j < numLen - 1; j++) {
                for (int k = j + 1; k < numLen; k++) {
                    int temp = nums[i] + nums[j] + nums[k];
                    if (Math.abs(temp - target) < Math.abs(res - target)) {
                        res = temp;
                    }
                }
            }

        }
        return res;
    }
}

package DailyAlg;

public class LeetCode45 {
    public static void main(String[] args) {
        int[] j = {2,3,0,1,4};
        System.out.println(jump(j));
    }

    public static int jump(int[] nums) {
        int n = nums.length;
        int[] f = new int[n];

        f[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j >= n) {
                    break;
                }
                int cur = f[i + j];
                if (cur == 0) {
                    f[i + j] = f[i] + 1;
                } else {
                    if (f[i + j] > f[i] + 1) {
                        f[i + j] = f[i] + 1;
                    }
                }
            }

        }
        return f[n - 1];

    }

}

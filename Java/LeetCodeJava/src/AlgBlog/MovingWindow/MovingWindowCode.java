package AlgBlog.MovingWindow;

import java.util.Arrays;

public class MovingWindowCode {
    public static void main(String[] args) {

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
}

package DailyAlg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class LeetCode179 {
    public static void main(String[] args) {

    }

    public static String largestNumber(int[] nums) {
        int  n = nums.length;
        Integer[] numsArr = new Integer[n];
        for (int i = 0; i < n; i++) {
            numsArr[i] = nums[i];
        }

        Arrays.sort(numsArr, (x, y) -> {
            long sx = 10, sy = 10;
            while (sx <= x) {
                sx *= 10;
            }
            while (sy <= y) {
                sy *= 10;
            }

            return Long.compare(sx * y + x, sy * x + y);
        });

        if (numsArr[0] == 0) {
            return "0";
        }
        StringBuilder ret = new StringBuilder();
        for (int num : numsArr) {
            ret.append(num);
        };
        return ret.toString();

    }
}

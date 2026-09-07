package DailyAlg;

import java.util.Arrays;

public class LeetCode274 {
    public static void main(String[] args) {
        int[] test = {80, 70, 5,4,3};
        hIndex(test);
    }
    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 1;

        if (citations.length == 1) {
            if (citations[0] > 0) {
                return 1;
            } else {
                return 0;
            }

        }

        for (int i = citations.length - 1; i >= 0 ; i--) {

            if (citations[i] >= h) {
                h++;
            } else {
                h--;
                return h;
            }
        }
        h--;
        return h;

    }
}

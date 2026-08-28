package DailyAlg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class LeetCode179 {
    public static void main(String[] args) {

    }

    public static String largestNumber(int[] nums) {
        int maxNum = Arrays.stream(nums).max().getAsInt();
        String numString = String.valueOf(maxNum);
        int maxNumLen = numString.length();
        Double maxN = Math.pow(10, maxNumLen);
        ArrayList<Double> buffer = new ArrayList<>();
        for (int num: nums) {
            String numS = String.valueOf(num);
            int curNumLen = numS.length();
            int gap = maxNumLen - curNumLen;
            Double newNum = num * Math.pow(10, gap);
            buffer.add(newNum);

        }

        buffer.sort(Comparator.reverseOrder());


    }
}

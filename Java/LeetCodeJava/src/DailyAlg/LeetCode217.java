package DailyAlg;

import java.util.ArrayList;
import java.util.Arrays;

public class LeetCode217 {
    public static void main(String[] args) {

    }

    public int[] quicksort(int[] arr) {
        if (arr.length < 1) {
            return arr;
        }

        int pivot = arr[arr.length - 1];
        int[] left = Arrays.stream(arr, 0, arr.length - 1).filter(x -> x <= pivot).toArray();
        int[] right = Arrays.stream(arr, 0, arr.length - 1).filter(x -> x > pivot).toArray();

        return concat(concat(quicksort(left), new int[]{pivot}), quicksort(right));


    }

    public int[] concat(int[] a, int[] b) {
        int[] result = Arrays.copyOf(a, a.length + b.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        return result;
    }

    public boolean containsDuplicate(int[] nums) {
        int[] sortedNums = quicksort(nums);
        for (int i = 0; i < sortedNums.length - 1; i++) {
            if (sortedNums[i] == sortedNums[i+1]) {
                return true;
            }
        }
        return false;
    }
}

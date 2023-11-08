package AlgVillage.Level9;

/**
 * @author 欧欧
 * @version 1.0
 */
public class BiSearch {
    public static void main(String[] args) {
        int[] testArray = {1, 2, 3,4, 5,6,8,9,9,19 };
        System.out.println(binarySearchLoop(testArray, 0, 9, 19));


    }

    public static int binarySearchLoop(int[] array, int low, int high, int target) {
        while (low <= high) {
            int m =low + ((high - low) >> 1);
            if (target < array[m]) {
                high = m - 1;
            };
            if (target > array[m]) {
                low = m + 1;
            }
            if (target == array[m]) {
                return m;
            }

        }
        return -1;
    }
}


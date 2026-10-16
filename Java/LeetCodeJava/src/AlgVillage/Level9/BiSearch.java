package AlgVillage.Level9;

/**
 * @author 欧欧
 * @version 1.0
 */
public class BiSearch {
    public static void main(String[] args) {
        int[] testArray = {1, 2, 3,4, 5,6,6,6,6,6,6,6,6,6,6,6,6,6,6,8,9,9,9,9,9,9,9,9,9,9,19 };
//        System.out.println(searchRange(testArray, 20)[0]);


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


    public static int binarySearchRecursion(int[] array, int low, int high, int target) {
        if (low > high) {
            return -1;
        }

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
        return binarySearchLoop(array, low, high, target);

    }

    public static int binarySearchRecursionEqual(int[] array, int low, int high, int target) {
        if (low > high) {
            return -1;
        }

        int m =low + ((high - low) >> 1);
        if (target < array[m]) {
            high = m - 1;
        };
        if (target > array[m]) {
            low = m + 1;
        }
        if (target == array[m]) {
            for (int i = m; i >= 0; i--) {
                if (i == 0) {
                    return i;
                }
                if (target != array[i - 1]) {
                    return i;
                } else {
                    continue;
                }
            }
            return m;
        }
        return binarySearchRecursionEqual(array, low, high, target);

    }
    public static int binarySearchRecursionEqualMax(int[] array, int low, int high, int target) {
        if (low > high) {
            return -1;
        }

        int m =low + ((high - low) >> 1);
        if (target < array[m]) {
            high = m - 1;
        };
        if (target > array[m]) {
            low = m + 1;
        }
        if (target == array[m]) {
            for (int i = m; i < array.length; i++) {
                if (i == array.length - 1) {
                    return i;
                }
                if (target != array[i + 1]) {
                    return i;
                } else {
                    continue;
                }
            }
            return m;
        }
        return binarySearchRecursionEqualMax(array, low, high, target);

    }



}


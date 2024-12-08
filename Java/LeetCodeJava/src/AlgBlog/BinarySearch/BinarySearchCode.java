package AlgBlog.BinarySearch;

public class BinarySearchCode {
    public static void main(String[] args) {

    }


    public int binarySearchLoop(int[] array, int low, int high, int target) {
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (target == array[mid]) {
                return mid;
            } else if (target < array[mid]) {
                high = mid - 1;
            } else if (target > array[mid]) {
                low = mid + 1;
            }
        }
        return -1;
    }

    public int binarySearchRecur(int[] array, int low, int high, int target) {
        if (low > high) {
            return -1;
        }
        int mid = low + ((high - low) >> 1);
        if (target == array[mid]) {
            return mid;
        } else if (target < array[mid]) {
            return binarySearchRecur(array, low, mid - 1, target);
        } else if (target > array[mid]) {
            return binarySearchRecur(array, low + 1, mid, target);
        }
        return -1;
    }
}

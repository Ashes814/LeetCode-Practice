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

    public static int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int high = arr.length - 1;
        while (left <= high) {
            int mid = left + ((high - left) >> 1);
            if (arr[mid - 1] <= arr[mid] && arr[mid] >= arr[mid + 1]) {
                return mid;
            } else if (arr[mid - 1] <= arr[mid]) {
                left = mid + 1;
            } else if (arr[mid] >= arr[mid + 1]) {
                high = mid - 1;
            }

        }
        return -1;
    }

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            }

        }
        return nums[left];
    }
}

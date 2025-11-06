package DailyAlg;

public class BinarySearchLC {
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        searchRange(nums, 8);
    }
    public static int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;

    }

    private static int binarySearch(int[] nums, int low, int high, int target) {
        int res = -1;
        if (low > high) {
            return -1;
        }
        int mid = (low + high) >> 1;
        if (low > high || mid >= nums.length) {
            return -1;
        }
        if (nums[mid] == target) {
            res = mid;
        } else if (nums[mid] < target) {
            res = binarySearch(nums, mid + 1, high, target);
        } else if (nums[mid] > target) {
            res = binarySearch(nums, low, mid - 1, target);
        }
        return res;
    }

    public static int[] searchRange(int[] nums, int target) {
        int initialIndex = binarySearch(nums, 0, nums.length - 1, target);
        int[] res = {-1, -1};
        if (initialIndex == -1) {
            return res;
        }
        int startIndex = initialIndex;
        int endIndex = initialIndex;

        while ((startIndex > 0 && nums[startIndex - 1] == target) || nums[endIndex] == target) {
            if (startIndex > 0 && nums[startIndex - 1] == target) {
                startIndex--;
            }

            if (endIndex < nums.length - 1) {
                endIndex++;
            }
        }
        if (nums[startIndex] == target && startIndex > 0) {
            startIndex--;
        }
        if (nums[endIndex] == target && endIndex < nums.length - 1) {
            endIndex++;
        }
        return null;
    }
}

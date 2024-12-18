package AlgBlog.QuickSort;

public class QuickSortCode {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,8,4,6,9};
        quickSortImpl2(nums1, 0, 6);

    }

    public static void quickSortImpl1(int[] nums, int left, int right) {
        if (left < right) {
            int pivot = nums[right];
            int i = left - 1;
            for (int j = left; j < right; j++) {
                if (nums[j] < pivot) {
                    i++;
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }

            int pivotIndex = i + 1;
            int temp = nums[pivotIndex];
            nums[pivotIndex] = nums[right];
            nums[right] = temp;

            quickSortImpl1(nums, left, pivotIndex - 1);
            quickSortImpl1(nums, pivotIndex + 1, right);
        }
    }

    public static void quickSortImpl2(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int l = left;
        int r = right;
        int pivot = nums[(left + right) / 2];

        while (l <= r) {
            while (l <= r && nums[l] < pivot) {
                l++;
            }

            while (l <= r && nums[r] > pivot) {
                r--;
            }

            if (l <= r) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l++;
                r--;
            }
        }

        quickSortImpl2(nums, left, r);
        quickSortImpl2(nums, l, right);
    }
 }

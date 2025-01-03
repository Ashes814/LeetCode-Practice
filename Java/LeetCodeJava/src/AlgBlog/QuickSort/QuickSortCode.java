package AlgBlog.QuickSort;

import java.sql.Array;

public class QuickSortCode {
    public static void main(String[] args) {
        int[] nums1 = {6,3,2,1,4,5,8,7};
        int[] temp = new int[nums1.length];
        mergeSort(nums1, 0, nums1.length - 1, temp);
//        quickSortImpl2(nums1, 0, 6);
//        System.out.println(findKthLargest(nums1, k));

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

    public static int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        return quickSelect(nums, 0, n - 1, n - k);
    }

    public static int quickSelect(int[] nums, int left, int right, int nK) {
        if (left == right) {
            return nums[left];
        }

        int i = left - 1;
        int j = right + 1;
        int pivot = nums[left];

        while (i < j) {
            do {
                i++;
            } while (nums[i] < pivot);

            do {
                j--;
            } while (nums[j] > pivot);

            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        if (nK <= j) {
            return quickSelect(nums, left, j, nK);
        } else {
            return quickSelect(nums, j + 1, right, nK);
        }
    }

    public static void mergeSort(int[] array, int start, int end, int temp[]) {
        if (start >= end) {
            return;
        }
        mergeSort(array, start, (start + end) >> 1, temp);
        mergeSort(array, ((start + end) >> 1) + 1, end, temp);
        merge(array, start, end, temp);

    }

    public static void merge(int[] array, int start, int end, int[] temp) {
        int middle = (start + end) >> 1;
        int left = start;
        int right = middle + 1;
        int index = left;
        while (left <= middle && right <= end) {
            if (array[left] < array[right]) {
                temp[index++] = array[left++];
            } else {
                temp[index++] = array[right++];
            }
        }

        while (left <= middle) {
            temp[index++] = array[left++];
        }

        while (right <= end) {
            temp[index++] = array[right++];
        }

        for (int i = start; i <= end; i++) {
            array[i] = temp[i];
        }



    }

 }

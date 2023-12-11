package AlgVillage.Level10;

/**
 * @author 欧欧
 * @version 1.0
 */
public class BronzeQuichSort {
    public static void main(String [] args) {

        int[] testArray = {26, 53, 48,15,13,48,32,15};
        int[] temp = new int[testArray.length];
//        quickSort2(testArray, 0, testArray.length - 1);
//        for (int i = 0; i < testArray.length - 1; i++) {
//            System.out.println(testArray[i]);
//        }
        mergeSort(testArray, 0, testArray.length - 1, temp);
        for (int i = 0; i < testArray.length; i++) {
            System.out.println(testArray[i]);
        }
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = arr[right];
            int i = left - 1;
            for (int j = left; j < right; j++) {
                if (arr[j] < pivot) {
                    i++;
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }

            int pivotIndex = i + 1;
            int temp = arr[pivotIndex];
            arr[pivotIndex] = arr[right];
            arr[right] = temp;

            quickSort(arr, left, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, right);
        }

    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= pivot) {
                high--;

            }
            arr[low] = arr[high];

            while (low < high && arr[low] <= pivot) {
                low++;

            }
            arr[high] = arr[low];
        }
        arr[low] = pivot;
        return low;
    }

    public static void quickSort2(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort2(arr, low, pivotIndex - 1);
            quickSort2(arr, pivotIndex + 1, high);

        }
    }

    public static int quickSelect(int[] nums, int l, int r, int k) {
        if (l == r) return nums[k];
        int x = nums[l], i = l - 1, j = r + 1;
        while (i < j) {
            do i++; while (nums[i] < x);
            do j--; while (nums[j] > x);
            if (i < j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        if (k <= j) return quickSelect(nums, l, j, k);
        else return quickSelect(nums, j + 1, r, k);
    }

    public static int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        return quickSelect(nums, 0, n - 1, n - k);
    }

    public static void merge(int[] nums, int low, int high, int[] temp) {
        int middle = (low + high) / 2;
        int left = low;
        int right = middle + 1;
        int index = left;
        while (left <= middle && right <= high) {
            if (nums[left] < nums[right]) {
                temp[index++] = nums[left++];
            } else {
                temp[index++] = nums[right++];
            }
        }
        while (left <= middle) {
            temp[index++] = nums[left++];
        }
        while (right <= high) {
            temp[index++] = nums[right++];
        }
        for (int i = low; i <= high; i++) {
            nums[i] = temp[i];
        }
    }
    public static void mergeSort(int[] nums, int low, int high, int[] temp) {
        if (low >= high) {
            return;
        }
        mergeSort(nums, low, (low + high) / 2, temp);
        mergeSort(nums, (low + high) / 2 + 1, high, temp);
        merge(nums, low, high, temp);

    }
}

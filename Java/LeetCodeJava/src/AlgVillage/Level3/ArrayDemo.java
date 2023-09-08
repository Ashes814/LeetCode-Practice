package AlgVillage.Level3;

/**
 * @author 欧欧
 * @version 1.0
 */
public class ArrayDemo {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3, 0, 0, 0};
        int[] nums2 = {2,5,6};
        merge(nums1, 3, nums2, 3);
//        System.out.println(removeByElement(testArr, 5, 1));
        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);

        }

    }

    public static int findByElement(int[] arr, int size, int key) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == key) {
                return i;
            }


        }
        return -1;
    }
    public static int findBig(int[] arr, int size, int key) {
        for (int i = 0; i < size; i++) {
            if (arr[i] >= key) {
                return i;
            }


        }
        return -1;
    }

    public static int addByElementSequence(int[] arr, int size, int element) {
        if (arr.length <= size) {
            return -1;

        }

        int index = size;
        for (int i = 0; i < size; i++) {
            if (element < arr[i]) {
                index = i;
                break;
            }

        }

        for (int j = size; j > index ; j--) {
            arr[j] = arr[j - 1];

        }
        arr[index] = element;
        return index;

    }
    public static int addByElementSequence2(int[] arr, int size, int element) {
        if (arr.length <= size) {
            return -1;

        }


        for (int i = size; i > 0; i--) {
            if (element > arr[i - 1]) {
                arr[i] = element;
                return i;
            } else {
                arr[i] = arr[i - 1];
                arr[i - 1] = element;
            }
        }
        return 0;


    }

    public static int removeByElement(int[] arr, int size, int key) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (arr[i] == key) {
                index = i;
                break;
            }

        }

        if (index == -1) {
            return -1;
        }
        for (int i = index; i < size; i++) {
            arr[i] = arr[i + 1];
        }
        return index;
    }

    public static boolean isMonotonic(int[] nums) {

        if (nums.length == 0 || nums.length == 1) {
            return true;
        }
        boolean res = true;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >=  nums[i - 1]) {

            } else {
                res = false;
                break;
            }

        }

        if (res) {
            return res;
        }
        res = true;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <=  nums[i - 1]) {
                continue;
            } else {
                res = false;
                break;
            }

        }

        return res;

    }

    public static int searchInsert(int[] nums, int target) {
       int left = 0;
       int right = nums.length - 1;
       while (right >= left) {
           int mid = left + (right - left) / 2;
           if (target > nums[mid]) {
               left = mid + 1;
           } else if (target < nums[mid]) {
               right = mid - 1;
           } else {
               return mid;
           }
       }
       return left;


    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m + n - 1;
        int len1 = m - 1;
        int len2 = n - 1;
        while (len1 >= 0 && len2 >= 0) {
            if (nums1[len1] < nums2[len2]) {
                nums1[i] = nums2[len2];
                len2--;
            } else if (nums1[len1] >= nums2[len2]) {
                nums1[i] = nums1[len1];
                len1--;
            }
            i--;
        };

        while (len1 >= 0) {
            nums1[i] = nums1[len1];
            i--;
            len1--;
        }
        while (len2 >= 0) {
            nums1[i] = nums2[len2];
            i--;
            len2--;
        }

    }
}

package AlgVillage.Level3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 欧欧
 * @version 1.0
 */
public class ArrayDemo {
    public static void main(String[] args) {
        int[] nums1 = {0,1,2};
        int[] nums2 = {0,0,1,1,1,1,1,1,1,1,2,2,3,3,4};
        sortColors(nums1);
//        rotate(nums1, 0);
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

    public static int removeElement(int[] nums, int val) {
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                fast++;
                slow++;
            } else if (nums[fast] == val) {
                fast++;
            }
        }
        return slow;
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        if (nums.length == 0) {
            return 0;
        }
        int slow = 1;
        int fast = 1;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow - 1]) {
                nums[slow] = nums[fast];
                fast++;
                slow++;

            } else if (nums[fast] == nums[slow - 1]) {
                fast++;
            }
        }
        return slow;
    }

    public static int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (right >= left) {
            if (nums[left] % 2 == 0) {
                left++;
            }
            if (nums[right] % 2 == 1) {
                right--;
            }

            if (nums[left] % 2 == 1 && nums[right] % 2 == 0) {
                int temp = nums[right];
                nums[left] = temp;
                nums[right] = nums[left];
            }
        }
        return nums;
    }

    public static int[] reverseArray(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (right >= left) {
            int temp = nums[right];
            nums[right] = nums[left];
            nums[left] = temp;
            right--;
            left++;
        }
        return nums;
    }
    public static void rotate(int[] nums, int k) {
        if (k >= nums.length) {
            k = k % nums.length;
        }
        reverseArray(nums);
        int[] leftArray = new int[k];
        int[] rightArray = new int[nums.length - k];
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                leftArray[i] = nums[i];
            } else {
                rightArray[i - k] = nums[i];
            }
        }
        reverseArray(leftArray);
        reverseArray(rightArray);
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                nums[i] = leftArray[i];
            } else {
                nums[i] = rightArray[i - k];
            }
        }
    }

    public static List<String> summaryRanges(int[] nums) {
        String quote = "\"";
        List<String> res = new ArrayList<>();
        if (nums.length == 1) {
            res.add("\""  + nums[0] + "\"" );
            return res;
        }
        int slow = 0;
        int fast = 1;
        while (fast < nums.length) {
            if ((nums[fast] - 1) == nums[fast - 1]) {
                fast++;
                if ((fast == nums.length)) {
                    res.add("\"" + nums[slow]+"->" +nums[fast - 1]+"\"" );
                }
            } else {
                if (nums[slow] == nums[fast - 1]) {
                    res.add("\""  + nums[slow] + "\"" );
                } else {
                    res.add("\""  + nums[slow]+"->" +nums[fast - 1] + "\"" );
                }

                slow = fast;
                fast++;


                if ((fast == nums.length)) {
                    res.add("\"" + nums[fast - 1] + "\"");
                }
            }

        }
        return res;
    }

    public static String replaceSpace(StringBuffer str) {
        if (str == null) {
            return null;
        }
        int numOfblank = 0;
        int len = str.length();
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == ' ') {
                numOfblank++;
            };
        }
        str.setLength(len + 2 * numOfblank);
        int fast = len - 1;
        int slow = (len - 1 + 2 * numOfblank);
        while (fast >= 0 && slow > fast) {
            char c = str.charAt(fast);
            if (c == ' ') {
                fast--;
                str.setCharAt(slow--, '0');
                str.setCharAt(slow--, '2');
                str.setCharAt(slow--, '%');
            } else {
                str.setCharAt(slow, c);
                fast--;
                slow--;
            }
        }
        return str.toString();
    }

    public static int moreThanHalfNum(int[] array) {
        if (array == null) {
            return 0;
        }
        Map<Integer, Integer> res = new HashMap<>();
        int len = array.length;
        for (int i = 0; i < len; i++) {
            res.put(array[i], res.getOrDefault(array[i], 0) + 1);
            if (res.get(array[i]) > len / 2) {
                return array[i];
            }

        }
        return 0;
    }

    public static int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = res ^ nums[i];
        }
        return res;
    }
    public static int singleNumberII(int[] nums) {
        int ones = 0, twos = 0;

        for (int num : nums) {
            ones = (ones ^ num) & ~twos;
            twos = (twos ^ num) & ~ones;
        }

        return ones;
    }
    public static void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (right >= left) {
            if (nums[left] == 2) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                right--;
            }
            if (nums[left] != 2) {
                left++;
            }

        }
        left = 0;
        while (right > left) {
            if (nums[left] == 1) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                right--;
            }
            if (nums[left] != 1) {
                left++;
            }

        }




    }
}

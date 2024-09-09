package AlgBlog.lovearray;

public class LoveArrayList {
    public static void main(String[] args) {
//        int[] nums = new int[]{1,2,3,4,5,6,7,8,9};
//        System.out.println(addByElementSequence(nums, 4, 4));
//        System.out.println("=====================");
//        for (int num : nums) {
//            System.out.print(num);
//        }
//        System.out.println("=====================");
//        int[] nums2 = new int[]{1,2,3,5,0,0,0,0,0};
//        System.out.println(addByElementSequence02(nums2, 4, 4));
//        System.out.println("=====================");
//        for (int num : nums2) {
//            System.out.print(num);
//        }
//        System.out.println(removeByElement(nums, 9, 9));
//        int[] nums1 = {1, 2, 3, 0, 0, 0};
//        int[] nums2 = {2, 5, 6};
//        merge(nums1,3, nums2, 3);
        int[] nums = {3,1,2,4};
//        System.out.println(removeElement(nums, 2));
        System.out.println(sortArrayByParity(nums));

    }

    public static int addByElementSequence(int[] arr, int size, int element) {
        if (size >= arr.length) {
            return -1;
        }

        int index = size;
        for (int i = 0; i < size; i++) {
            if (arr[i] > element) {
                index = i;
                break;
            }
        }

        for (int j = size; j > index; j--) {
            arr[j] = arr[j - 1];
        }
        arr[index] = element;
        return index;
    }

    public static int addByElementSequence02(int[] arr, int size, int element) {
        if (size >= arr.length) {
            return -1;
        }

        int index = 0;
        for (int i = size; i>0; i--) {
            if (arr[i - 1] <= element) {
                arr[i] = element;
                return i;
            } else {
                arr[i] = arr[i - 1];
            }
        }
        arr[0] = element;
        return 0;
    }

    public static int removeByElement(int[] arr, int size, int element) {
        if (size > arr.length) {
            return -1;
        }
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (element == arr[i]) {
                index = i;
                for (int j = index; j < size - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                size--;
                return index;
            }

        }
        return index;
    }

    public static boolean isMonotonic(int[] nums) {
        boolean res = true;
        if (nums.length <= 1) {
            return true;
        }

        int rise = 2;

        for (int i = 0; i < nums.length - 1; i++) {
          if (rise == 1) {
              if (nums[i] > nums[i + 1]) {
                  return false;
              }
          } else if (rise == 0) {
              if (nums[i] < nums[i + 1]) {
                  return false;
              }
          } else {
              if (nums[i] > nums[i + 1]) {
                  rise = 0;
              } else if (nums[i] < nums[i + 1]) {
                  rise = 1;
              } else {
                  rise = 2;
              }
          }

        }
        return res;
    }

    public static int searchInsert(int[] nums, int target) {
        int nums_length = nums.length;
        int left = 0;
        int right = nums_length - 1;
        int ans = nums_length;

        while (right > left) {
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m + n - 1;
        m--;
        n--;
        while (i >= 0) {
            if (m < 0) {
                nums1[i] = nums2[n];
                n--;
                i--;
                continue;
            }
            if (n < 0) {
                nums1[i] = nums1[m];
                m--;
                i--;
                continue;
            }
            if (nums1[m] >= nums2[n]) {
                nums1[i] = nums1[m];
                m--;
            } else {
                nums1[i] = nums2[n];
                n--;
            }
            i--;



        }

    }

    public static int removeElement(int[] nums, int val) {

        int slow = 0;
        int fast = 0;
        while (slow < nums.length && val != nums[slow]) {
            slow++;
            fast++;
        }
        while (fast < nums.length) {
            while (fast < nums.length && val == nums[fast]) {
                fast++;
            }
            if (fast == nums.length) {
                break;
            }
            nums[slow] = nums[fast];
            slow++;
            fast++;
        }
        return slow;

    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return 1;
        }
        int slow = 0;
        int fast = 0;

        while (fast < nums.length) {
            if (nums[slow] == nums[fast]) {
                fast++;
            } else {
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow+1;

    }

    public static int[] sortArrayByParity(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums;
        }

        int odd = 0;
        int even = 0;
        while (even < nums.length && odd < nums.length) {

            if (nums[odd] % 2 == 0) {
                odd++;
            }
            if (nums[even] % 2 == 1) {
                even++;
            }

            if (even < odd) {
                even = odd;
            }

            if (odd == nums.length || even == nums.length){
                break;
            }

            if ((nums[odd] % 2 == 1) && (nums[even] % 2 == 0)) {
                int temp = nums[even];
                nums[even] = nums[odd];
                nums[odd] = temp;
            }

        }
        return nums;
    }
}

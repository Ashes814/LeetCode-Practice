package AlgBlog.BinarySearch;

public class BinarySearchCode {
    public static void main(String[] args) {
//        int[] test1 = {};
//        System.out.println(missingNumber(test1));
        int[] nums1 = {1,2,2,2,2,2,2,2,2,6};
        int[] nums2 = {-1,0,3,5,9,12};
//        System.out.println(findMedianSortedArrays(nums1, nums2));
        System.out.println(search(nums1, 2));

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

    public static int sqrtOptimize(int x) {
        int left = 1;
        int right = x;
        while (left < right){
            int mid = left + ((right - left) >> 1);
            if (x / mid > mid) {
                left = mid + 1;
            } else if (x / mid < mid) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return right;
    }

    public static int missingNumber(int[] a) {
        int left  = 0;
        int right = a.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (a[mid] == mid) {
                left = mid + 1;
            } else if (a[mid] != mid) {
                right = mid;
            }

        }
        return left;
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (val == root.val) {
            return root;
        }

        if (root.val < val) {
            return searchBST(root.right, val);
        }

        if (root.val > val) {
            return searchBST(root.left, val);
        }

        return null;

    }


    Long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {

        if (root == null) {
            return true;
        }

        if (!isValidBST(root.left)) {
            return false;
        }

        if (root.val <= pre) {
            return false;
        }

        return isValidBST(root.right);


    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return constructTree(nums, 0, nums.length - 1);
    }

    public TreeNode constructTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + ((right - left) >> 1);

        TreeNode root = new TreeNode(nums[mid]);
        root.left = constructTree(nums, left, mid - 1);
        root.right = constructTree(nums, mid + 1, right);
        return root;
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int lenght2 = nums2.length;
        int totalLength = length1 + lenght2;
        if (totalLength % 2 == 1) {
            int k = totalLength / 2;
            double median = getKthElement(nums1, nums2, k + 1);
            return median;
        } else {
            int k1 = totalLength / 2 - 1;
            int k2 = totalLength /2 ;
            double median = (getKthElement(nums1, nums2, k1 + 1) + getKthElement(nums1, nums2, k2 + 1)) / 2.0;
            return median;
        }
    };

    public static double getKthElement(int[] nums1, int[] nums2, int k) {
        int length1 = nums1.length;
        int length2 = nums2.length;

        int index1 = 0;
        int index2 = 0;

        while (true) {
            if (index1 == length1) {
                return nums2[index2 + k - 1];
            }

            if (index2 == length2) {
                return nums1[index1 + k - 1];
            }

            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }


            int halfK = k / 2;
            int newIndex1 = Math.min(index1 + halfK, length1) - 1;
            int newIndex2 = Math.min(index2 + halfK, length2) - 1;
            int pivot1 = nums1[newIndex1];
            int pivot2 = nums2[newIndex2];

            if (pivot1 <= pivot2) {
                k = k - (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;

            } else {
                k = k - (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;

            }



        }

    }


    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        return binarySearch(nums, target,left, right);

    }

    public static int binarySearch(int[] nums, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = left + ((right - left) >> 1);
        if (target == nums[mid]) {
            if (mid == left) {
                return mid;
            }

            if (nums[mid] != nums[mid - 1]) {
                return mid;
            }

            return binarySearch(nums, target, left, mid - 1);
        }
        if (target < nums[mid]) {
            return binarySearch(nums, target, left, mid - 1);
        } else if (target > nums[mid]) {
            return binarySearch(nums, target, mid + 1, right);
        }

        return -1;

    }

}

class TreeNode {
    int val;
    TreeNode left;

    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}



/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

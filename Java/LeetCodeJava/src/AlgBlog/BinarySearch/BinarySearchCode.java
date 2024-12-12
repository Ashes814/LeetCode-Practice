package AlgBlog.BinarySearch;

public class BinarySearchCode {
    public static void main(String[] args) {
//        int[] test1 = {};
//        System.out.println(missingNumber(test1));


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

class MyLinkedList {
    Node dummyHead;
    int size;

    public MyLinkedList() {
        size = 0;
        dummyHead = new Node(0);
    }

    public int get(int index) {
        Node res = dummyHead.next;
        for (int i = 0; i < index; i++) {
            res = res.next;
            if (res == null) {
                return -1;
            }
        }
        return res.val;
    }

    public void addAtHead(int val) {
        Node temp = new Node(val);
        temp.next = dummyHead.next;
        dummyHead.next = temp;
        size++;
    }

    public void addAtTail(int val) {
        Node cur = dummyHead;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = new Node(val);
        size++;
    }

    public void addAtIndex(int index, int val) {

        if(index > size){
            return ;
        }

        Node cur = dummyHead;
        for(int i= 0; i< index;i++){
            cur  = cur .next;
        }
        Node newNode = new Node(val);
        newNode.next = cur .next;
        cur.next = newNode;
        size++;


    }

    public void deleteAtIndex(int index) {
        Node cur = dummyHead;
        for (int i = 0; i < index; i++) {
            cur =  cur.next;
        }
        cur.next =  cur.next.next;
    }
}

class Node {
    int val;
    Node next;


    public Node(int v) {
        this.val = v;
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

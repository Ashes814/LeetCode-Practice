package DailyAlg;

import java.util.*;

public class DailyAlg202504 {
    public static void main(String[] args) {
//        ListNode node1 = new ListNode(7, new ListNode(1, new ListNode(6)));
//        ListNode node2 = new ListNode(5, new ListNode(9, new ListNode(2,new ListNode(9))));

//        addTwoNumbers(node1, node2);
//        int[] testArray = {1,2,2,3};
//        int[] testArray2 = {2,2};
//        System.out.println(intersection(testArray, testArray2));

//        int[][] test1 = {{1,2,3},{4,5,6},{7,8,9}};
//        rotate(test1);
//        int[] test = {3,0,3,2,4,2,1,1,0,4};
//        findSmallestInteger(test, 5);
//        ListNode testNode = new ListNode(-10, new ListNode(-3, new ListNode(0, new ListNode(5, new ListNode(9)))));
//        TreeNode res = sortedListToBST(testNode);
//        TreeNode testTree = new TreeNode(1,new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(5, null, new TreeNode(6)));
//        flatten(testTree);
//        Node testNode = new Node(1);
//        testNode.left = new Node(2);
//        testNode.right = new Node(3);
//
//        testNode.left.left = new Node(4);
//        testNode.left.right = new Node(5);
//
//        testNode.right.left = new Node(6);
//        testNode.right.right = new Node(7);
//        connect(testNode);
    }


    // 面试题02.05. 链表求和
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode dummyHead = res;
        int flag = 0;
        int curNumber = 0;
        while (l1 != null && l2 != null) {
            curNumber = l1.val + l2.val + flag;
            if (curNumber >= 10) {
                curNumber = curNumber - 10;
                flag = 1;
                res.next = new ListNode(curNumber);
            } else {
                res.next = new ListNode(curNumber);
                flag = 0;
            }
            l1 = l1.next;
            l2 = l2.next;
            res = res.next;

        }

        if (l1 != null) {
            while (l1 != null) {
                curNumber = l1.val + flag;
                if (curNumber >= 10) {
                    curNumber = curNumber - 10;
                    flag = 1;
                    res.next = new ListNode(curNumber);
                } else {
                    res.next = new ListNode(curNumber);
                    flag = 0;
                }
                l1 = l1.next;
                res = res.next;
            }
        }

        if (l2 != null) {
            while (l2 != null) {
                curNumber = l2.val + flag;
                if (curNumber >= 10) {
                    curNumber = curNumber - 10;
                    flag = 1;
                    res.next = new ListNode(curNumber);
                } else {
                    res.next = new ListNode(curNumber);
                    flag = 0;
                }
                l2 = l2.next;
                res = res.next;
            }
        }

        if (flag == 1) {
            res.next = new ListNode(1);
        }
        return dummyHead.next;
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < nums1.length; i++) {
            if (res.contains(nums1[i])) {
                continue;
            } else {
                for (int j = 0; j < nums2.length; j++) {
                    if (nums1[i] == nums2[j]) {
                        res.add(nums1[i]);
                        break;
                    }

                }
            }

        }
        return res.stream().mapToInt(Integer::intValue).toArray();

    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = temp;
            }
        }


    }

    public static int findSmallestInteger(int[] nums, int value) {
        int n = nums.length;
        boolean[] vis = new boolean[n + 1];
        int[] cnt = new int[value];

        for (int i = 0; i < n; i++) {
            int t = (nums[i] % value + value) % value;
            int y = cnt[t] * value + t;
            if (y < n) {
                vis[y] = true;
            }
            cnt[t]++;

        }

        for (int i = 0; i <= n ; i++) {
            if (!vis[i]) {
                return i;
            }

        }
        return -1;


    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        int flag = 0;
        ListNode resNode = new ListNode();
        ListNode dummyHead = resNode;
        while (l1 != null && l2 != null) {
            int num = l1.val + l2.val + flag;
            if (num >= 10) {
                num = num - 10;
                flag = 1;
            } else {
                flag = 0;
            }
            resNode.next = new ListNode(num);
            l1 = l1.next;
            l2 = l2.next;
            resNode = resNode.next;

        }


        while (l1 != null) {
            int num = l1.val + flag;
            if (num >= 10) {
                num = num - 10;
                flag = 1;
            } else {
                flag = 0;
            }
            resNode.next = new ListNode(num);
            l1 = l1.next;
            resNode = resNode.next;
        }

        while (l2 != null) {
            int num = l2.val + flag;
            if (num >= 10) {
                num = num - 10;
                flag = 1;
            } else {
                flag = 0;
            }
            resNode.next = new ListNode(num);
            l2 = l2.next;
            resNode = resNode.next;
        }

        if (flag == 1) {
            resNode.next = new ListNode(1);
        }

        return dummyHead.next;


    }

    public static ListNode partition(ListNode head, int x) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;

        ListNode preNode = new ListNode();
        ListNode preHead = preNode;
        ListNode postNode = new ListNode();
        ListNode postHead = postNode;
        dummyHead = dummyHead.next;
        do {

            if (dummyHead.val < x) {
                preNode.next = dummyHead;
                preNode = preNode.next;
                dummyHead = dummyHead.next;
                preNode.next = null;
            } else if (dummyHead.val >= x) {
                postNode.next = dummyHead;
                postNode = postNode.next;
                dummyHead = dummyHead.next;
                postNode.next = null;
            }
        } while (dummyHead != null);
        preNode.next = postHead.next;
        return preHead.next;


    }

    public static TreeNode sortedListToBST(ListNode head) {
        List<Integer> nodeArr = new ArrayList<Integer>();
        int nodeLength = 0;
        ListNode temp = head;
        while (temp != null) {
            nodeArr.add(nodeLength, temp.val);
            nodeLength++;
            temp = temp.next;
        }
        return generateAVL(nodeArr, 0, nodeLength - 1);

    }

    public static TreeNode generateAVL(List<Integer> arr, int left, int right) {
        if (right < left) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(arr.get(mid));
        root.left = generateAVL(arr, left,  mid - 1);
        root.right = generateAVL(arr, mid + 1, right);
        return root;
    }

    public static void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        flatPre(list, root);
        for (int i = 1; i < list.size(); i++) {
            TreeNode prev = list.get(i - 1), curr = list.get(i);
            prev.left = null;
            prev.right = curr;

        }

    }

    public static void flatPre(List<TreeNode> list, TreeNode root) {
       if (root != null) {
           list.add(root);
           flatPre(list, root.left);
           flatPre(list, root.right);
       }
    }



    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        Map<Node, Node> map = new HashMap<>();
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }

        return map.get(head);

    }

    public void reorderList(ListNode head) {
        ListNode cur = head;
        LinkedList<ListNode> nodeList = new LinkedList<>();
        int nodeLength = 0;
        while (cur != null) {
            nodeList.add(cur);
            cur = cur.next;
            nodeLength++;
        }

        if (nodeLength % 2 == 0) {
            for (int i = 0; i < nodeLength / 2; i++) {
                nodeList.get(i).next = nodeList.get(nodeLength - i - 1);

                if (i == nodeLength / 2 - 1) {
                    nodeList.get(i).next.next = null;
                } else {
                    nodeList.get(i).next.next = nodeList.get(i + 1);
                }


            }
        } else {
            for (int i = 0; i <= nodeLength / 2; i++) {
                nodeList.get(i).next = nodeList.get(nodeLength - i - 1);

                if (i == nodeLength / 2) {
                    nodeList.get(i).next = null;
                } else {
                    nodeList.get(i).next = nodeList.get(nodeLength - i - 1);
                    nodeList.get(i).next.next = nodeList.get(i + 1);
                }


            }
        }





    }

    public static boolean isMonotonic(int[] nums) {
        if (nums.length <= 1) {
            return true;
        }
        int flag = 0;
        int index = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            int diff = nums[i + 1] - nums[i];
            if (diff == 0) {
                continue;
            }
            if (diff > 0) {
                flag = 0;
                index = i;
                break;
            } else {
                flag = -1;
                index = i;
                break;
            }


        }

        if (index == -1) {
            return true;
        }

        for (int i = index; i < nums.length - 1; i++) {
            if ((flag == 0 && (nums[i + 1] - nums[i] >= 0)) || (flag == -1 && (nums[i + 1] - nums[i] <= 0))) {
                continue;

            } else {
                return false;
            }
        }
        return true;
    }

}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
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

//class Node {
//    public int val;
//    public Node left;
//    public Node right;
//    public Node next;
//
//    public Node() {}
//
//    public Node(int _val) {
//        val = _val;
//    }
//
//    public Node(int _val, Node _left, Node _right, Node _next) {
//        val = _val;
//        left = _left;
//        right = _right;
//        next = _next;
//    }
//};

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}


class LUPrefix {

    private int videoLength;
    private boolean[] uploadedCode;
    private int curRes = 0;

    public LUPrefix(int n) {
        videoLength = n;
        uploadedCode = new boolean[n];
    }

    public void upload(int video) {

        if (video <= videoLength && uploadedCode[video - 1] == false) {
            uploadedCode[video - 1] = true;
        }

        while (curRes < videoLength && uploadedCode[curRes] == true) {
            curRes++;
        }

    }

    public int longest() {
        return curRes;
    }
}

//class LRUCache {
//    class DLinkedNode {
//        int key;
//        int value;
//        DLinkedNode prev;
//        DLinkedNode next;
//        public DLinkedNode() {}
//        public DLinkedNode(int _key, int _value) {key = _key; value = _value;}
//    }
//
//
//
//    private int cap;
//    private HashMap<Integer, DLinkedNode> hashMap = new HashMap<>();
//    private DLinkedNode head, tail;
//
//    public LRUCache(int capacity) {
//        this.cap = capacity;
//        head = new DLinkedNode();
//        tail = new DLinkedNode();
//        head.next = tail;
//        tail.prev = head;
//    }
//
//    public int get(int key) {
//
//    }
//
//    public void put(int key, int value) {
//        if (hashMap.containsKey(key)) {
//            hashMap.
//        }
//    }
//
//    private void addToHead(DLinkedNode node) {
//
//    }
//
//    private void removeNode(DLinkedNode node) {
//
//    }
//
//    private void moveToHead(DLinkedNode node) {
//
//    }
//
//    private DLinkedNode removeTail() {
//
//    }
//
//
//}


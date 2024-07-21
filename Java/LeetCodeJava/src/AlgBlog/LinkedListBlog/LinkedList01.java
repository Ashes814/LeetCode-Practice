package AlgBlog.LinkedListBlog;

import java.util.*;

public class LinkedList01 {
    static int arr[] = new int[5];

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(LinkedListDemo.rotateRight(head, 2));
    }
}

class LinkedListDemo {

    public static int getListLength(ListNode head) {
        int length = 0;
        ListNode node = head;

        // 从头至尾遍历整个链表
        while (node != null ) {
            length++;
            node = node.next;
        }
        return length;
    }

    public static ListNode insertNode(ListNode head, ListNode nodeInsert, int position) {

        // head 为空，则随便插入，直接返回要插入的Node
        if (head == null) {
            return nodeInsert;
        }

        // 处理越界情况
        int size = getListLength(head);
        if (position > size + 1 || position < 1) {
            System.out.println("Position out of range!");
            return head;
        }


        // 在表头插入
        if (position == 1) {
            nodeInsert.next = head;
            return nodeInsert;
        }

        // 在其他位置插入
        ListNode tempNode = head;
        int count = 1;
        while (count < position - 1) {
            tempNode = tempNode.next;
            count++;
        }
        nodeInsert.next = tempNode.next;
        tempNode.next = nodeInsert;
        return head;
    }

    public static ListNode deleteNode(ListNode head, int position) {
        // head 为空
        if (head == null) {
            return null;
        }

        // 处理越界情况这里是size因为删除的位置不可能是size + 1，与插入不同
        int size = getListLength(head);
        if (position > size  || position < 1) {
            System.out.println("Position out of range!");
            return head;
        }

        // 删除第一个结点
        if (position == 1) {
            return head.next;
        }

        // 删除中间的结点
        ListNode tempNode = head;
        int count = 1;
        while (count < position - 1) {
            tempNode = tempNode.next;
            count++;
        }
        tempNode.next = tempNode.next.next;

        return head;


    }

    // Using Hash or Set to solve common node problem
    public static ListNode findFirstCommonNodeBySet(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        Set<ListNode> nodeSetA = new HashSet<ListNode>();
        while (headA != null) {
            nodeSetA.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (nodeSetA.contains(headB)) {
                return headB;
            } else {
                headB = headB.next;
            }
        }
        return null;
    }

    // Using two stack to solve this problem
    public static ListNode findFirstCommonNodeByStack(ListNode headA, ListNode headB) {
        Stack<ListNode> stackA = new Stack<>();
        Stack<ListNode> stackB = new Stack<>();

        while (headA != null) {
            stackA.push(headA);
            headA = headA.next;
        }

        while (headB != null) {
            stackB.push(headB);
            headB = headB.next;
        }

        // Using a preNode to represent the last same node
        ListNode preNode = null;
        while (!stackA.isEmpty() && !stackB.isEmpty()) {
            if (stackA.peek() == stackB.peek()) {
                preNode = stackA.pop();
                stackB.pop();
            } else {
                break;
            }
        }
        return preNode;

    }

    // Leetcode 234
    public static boolean isPalindrome(ListNode head) {
        Stack<ListNode> tempStack = new Stack<>();
        ListNode tempNode = head;
        int nodeLength = 0;
        while (tempNode != null) {
            tempStack.add(tempNode);
            tempNode = tempNode.next;
            nodeLength++;
        }

        nodeLength = nodeLength / 2;
        ListNode tempNode2 = head;

        while (nodeLength != 0) {
            if (tempNode2.val != tempStack.pop().val) {
                return false;
            }
            nodeLength--;
            tempNode2 = tempNode2.next;

        }
        return true;






    }

    // Leetcode 21
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newHead = new ListNode(-1);
        ListNode res = newHead;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                res.next = list1;
                list1 = list1.next;
            } else {
                res.next = list2;
                list2 = list2.next;
            }
            res = res.next;
        }

        res.next = list1 == null ? list2 : list1;
        return newHead.next;

    }

    // Leetcode 1669
    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode endList = list1;
        int i = 0;
        while (i <= b) {
            endList = endList.next;
            i++;
        }

        ListNode startList = list1;
        int j = 1;
        while (j < a) {
            startList = startList.next;
            j++;
        }
        startList.next = list2;

        ListNode resList = list1;
        while (resList.next != null) {
            resList = resList.next;
        }
        resList.next = endList;
        return list1;

    }

    // Leetcode 876
    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (slow.next != null && fast != null &&fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < k; i++) {
            if (fast != null) {
                fast = fast.next;
            } else {
                break;
            }

        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;

    }

    /**
     * leet code 61
     * @param head
     * @param k
     * @return
     */
    public static ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null) {
            return head;
        }
        ListNode tempNode1 = head;
        int nodeLength = 0;
        while (tempNode1 != null) {
            nodeLength++;
            tempNode1 = tempNode1.next;
        }

        int moveK = k % nodeLength;
        if (moveK == 0) {
            return head;
        }

        ListNode preNode = getKthFromEnd(head, moveK);
        int preK = nodeLength - moveK;
        ListNode postNode = head;
        while (preK != 1) {
            postNode = postNode.next;
            preK--;
        }
        postNode.next = null;

        ListNode resNode = preNode;
        while (resNode.next != null) {
            resNode = resNode.next;
        }
        resNode.next = head;
        return preNode;

    }

}




class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}



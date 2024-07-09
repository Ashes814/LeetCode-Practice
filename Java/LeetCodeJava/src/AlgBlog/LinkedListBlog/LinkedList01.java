package AlgBlog.LinkedListBlog;

import java.util.*;

public class LinkedList01 {
    static int arr[] = new int[5];

    public static void main(String[] args) {
        System.out.println(arr[0]);
        System.out.println(1 + "10" + 3 + "2");
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
}




class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}



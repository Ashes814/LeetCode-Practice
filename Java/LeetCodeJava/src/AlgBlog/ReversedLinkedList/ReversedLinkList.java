package AlgBlog.ReversedLinkedList;


import java.util.Stack;

public class ReversedLinkList {

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(5);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
        System.out.println(reverseBetween(head, 1, 2));
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        Stack<ListNode> tempStack = new Stack<>();
        ListNode stackNode = head;
        while (stackNode != null) {
            tempStack.push(stackNode);
            stackNode = stackNode.next;
        }
        ListNode res = new ListNode(-1);
        ListNode tempRes = tempStack.pop();
        res.next = tempRes;
        while (!tempStack.isEmpty()) {
            tempRes.next = tempStack.pop();
            tempRes = tempRes.next;
        }
        tempRes.next = null;
        return res.next;
    }

    public static ListNode reverseList02(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode tempNext = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tempNext;
        }
        return pre;
    }

    public static ListNode reverseList03(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList03(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode insertHead = new ListNode(-1);
        insertHead.next = head;
        ListNode cur = head;
        int start = 1;
        int end = 1;
        while (start < left) {
            insertHead = insertHead.next;
            cur = cur.next;
            start++;
            end++;
        }
        ListNode pre = cur;

        while (end < right) {
            if (cur == null || cur.next == null) {
                break;
            }
            ListNode curNext = cur.next;
            insertHead.next = curNext;
            cur.next = curNext.next;
            curNext.next = pre;
            pre = insertHead.next;
            end++;
        }
        if (insertHead.val == -1) {
            return insertHead.next;
        }  else {
            return head;
        }
    }

    public static ListNode reverseBetween02(ListNode head, int left, int right) {
//        ListNode dummyHead = new ListNode(-1);
//        dummyHead.next = head;
//        ListNode pre = dummyHead;
//        ListNode leftNode = head;
//        ListNode rightNode = head;
//        int rightIndicator = 0;
//        for (int i = 0; i < left - 1; i++) {
//            pre = pre.next;
//            leftNode = leftNode.next;
//            rightNode = rightNode.next;
//            rightIndicator++;
//        }
//
//        for (int r = rightIndicator; r < right - 1; r++) {
//            rightNode = rightNode.next;
//        }
//        ListNode succ = rightNode.next;
//
//        rightNode.next = null;
//        pre.next = null;
//        ListNode newReversedList = reverseList(leftNode);
//        pre.next = newReversedList;
//        while (pre.next != null) {
//            pre = pre.next;
//        }
//        pre.next = succ;
//        return dummyHead.next;
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;

        for (int i = 0; i< left - 1; i++) {
            pre = pre.next;
        }

        ListNode rightNode = pre;
        for (int i = 0; i < right - left - 1; i++) {
            rightNode = rightNode.next;
        }

        ListNode leftNode = pre.next;
        ListNode succ = rightNode.next;
        rightNode.next = null;
        reverseList(leftNode);
        pre.next = rightNode;
        leftNode.next = succ;
        return dummyNode.next;
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur = head;
        ListNode pre = dummyHead;
        while (cur != null && cur.next != null) {
            ListNode curNext = cur.next;
            cur.next = curNext.next;
            curNext.next = cur;
            pre.next = curNext;
            pre = cur;
            cur = cur.next;
        }
        return dummyHead.next;
    }

}

 class ListNode {
    int val;
    ListNode next;
  ListNode() {}
    ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
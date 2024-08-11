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
}

 class ListNode {
    int val;
    ListNode next;
  ListNode() {}
    ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
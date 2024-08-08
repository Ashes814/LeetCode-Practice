package AlgBlog.ReversedLinkedList;


import java.util.Stack;

public class ReversedLinkList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        System.out.println(reverseList(head));
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
}

 class ListNode {
    int val;
    ListNode next;
  ListNode() {}
    ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
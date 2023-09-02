package AlgVillage.Level2;

import java.util.List;

/**
 * @author 欧欧
 * @version 1.0
 */
public class ListNodeLevel2 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1,
                        new ListNode(2,
                        new ListNode(3,
                        new ListNode(4,
                        new ListNode(5)))));


        showList(reverseListWithRecur(head));
    }

    public static void showList(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static ListNode reverseListWithDummy(ListNode head){
        if (head == null) {
            return head;
        }
        ListNode ans = new ListNode(-9999);
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = ans.next;
            ans.next = cur;
            cur = next;


        }
        return ans.next;
    };
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;

    };

    public static ListNode reverseListWithRecur(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseListWithRecur(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;


    };

}


class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }


}
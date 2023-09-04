package AlgVillage.Level2;

import java.util.List;

/**
 * @author 欧欧
 * @version 1.0
 */
public class ListNodeLevel2 {
    public static void main(String[] args) {
        ListNode head = new ListNode(7,
                        new ListNode(2,
                        new ListNode(4,
                        new ListNode(3,
                        new ListNode(9)))));
        ListNode head2 = new ListNode(8,
                        new ListNode(7,
                        new ListNode(4,
                        new ListNode(3))));
        showList(head);
        showList(head2);



        showList(addTwoNumbers(head, head2));
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

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;

        }
        ListNode cur = pre.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;


        }
        return dummyNode.next;
    }
    public static ListNode reverseBetween2(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;

        }

        ListNode rightNode= pre;
        for (int i = 1; i <= right - left; i++) {
            rightNode = rightNode.next;
        };
        ListNode leftNode = pre.next;
        ListNode succ = rightNode.next;
        rightNode.next = null;
        reverseList(leftNode);
        pre.next = rightNode;
        leftNode.next = succ;
        return dummyNode.next;

    }
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode left = pre.next;
        ListNode right = left.next;

        while (pre.next.next != null) {
            left.next = right.next;
            right.next = left;
            pre.next = right;

            pre = pre.next.next;
            if (pre.next == null) {
                break;
            } else {
                left = pre.next;
                right = left.next;
            }

        }
        return dummyHead.next;
        // swap


    }
    public static ListNode plusOne(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode rHead = reverseList(dummyNode);
        ListNode cur = rHead;
        while (cur != null) {
            if (cur.val < 9) {
                cur.val++;
                break;
            } else {
                cur.val = 0;
                cur = cur.next;
            }
        }
        ListNode res = reverseList(rHead);
        if (res.val == 0) {
            return res.next;
        } else {
            return res;
        }
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode cur = res;
        ListNode rL1 = reverseList(l1);
        ListNode rL2= reverseList(l2);
        int carry = 0;
        int sum = 0;
        while (rL1 != null || rL2 != null) {
            sum = (rL1 != null ? rL1.val : 0) + (rL2 != null ? rL2.val : 0);
            if (sum + carry < 10) {
                cur.val = sum + carry;
                cur.next = new ListNode(0);
                carry = 0;
                cur = cur.next;

            } else {

                sum -= 10;
                cur.val = sum + carry;
                cur.next = new ListNode(0);
                cur = cur.next;
                carry = 1;
            }

            if (rL1 == null) {
                rL2 = rL2.next;
            } else if (rL2 == null) {
                rL1 = rL1.next;
            } else {
                rL1 = rL1.next;
                rL2 = rL2.next;
            }



        };
        res = reverseList(res);
        if (carry == 1) {
            res.val = 1;
            return res;
        } else {
            return res.next;
        }
    }

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
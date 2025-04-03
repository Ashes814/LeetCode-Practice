package DailyAlg;

public class DailyAlg202504 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(7, new ListNode(1, new ListNode(6)));
        ListNode node2 = new ListNode(5, new ListNode(9, new ListNode(2,new ListNode(9))));

        addTwoNumbers(node1, node2);
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
}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
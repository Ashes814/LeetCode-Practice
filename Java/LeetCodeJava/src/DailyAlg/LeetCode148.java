package DailyAlg;

public class LeetCode148 {
    public static void main(String[] args) {
        ListNode test = new ListNode(4);
        test.next = new ListNode(2);
        test.next.next = new ListNode(1);
        test.next.next.next = new ListNode(3);
        sortList(test);
    }

    public static ListNode sortList(ListNode head) {


        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyHead = new ListNode();
        dummyHead.next = head;

        ListNode curNode = head;
        ListNode prevNode = dummyHead;
        ListNode nextNode = head.next;
        ListNode finishNode = null;

        while (dummyHead.next != finishNode) {
            while (nextNode != finishNode) {
                if (curNode.val > nextNode.val) {
                    prevNode.next = nextNode;
                    curNode.next = nextNode.next;
                    nextNode.next = curNode;
                    prevNode = nextNode;
                    nextNode = curNode.next;
                } else {
                    prevNode = curNode;
                    curNode = nextNode;
                    nextNode = nextNode.next;
                }
            }
            finishNode = curNode;

            curNode = dummyHead.next;
            prevNode = dummyHead;
            nextNode = curNode.next;
        }

        return dummyHead.next;


    }

}

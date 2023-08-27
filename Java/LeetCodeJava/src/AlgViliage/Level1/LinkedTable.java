package AlgViliage.Level1;

/**
 * @author 欧欧
 * @version 1.0
 */
public class LinkedTable {

    public static int getListLenth(ListNode head) {
        int length = 0;
        ListNode node = head;
        while (head.getNext() != null) {
            length++;
            node.setNext(node.getNext());
        }
        return length;
    }

    public static ListNode insertNode(ListNode head, ListNode newNode, int pos) {

    }
}

class ListNode {
    private int val;
    private ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
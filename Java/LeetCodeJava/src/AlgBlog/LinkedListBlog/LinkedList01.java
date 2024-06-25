package AlgBlog.LinkedListBlog;

public class LinkedList01 {
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
}




class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

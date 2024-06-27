package AlgBlog.LinkedListBlog;

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
}




class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}



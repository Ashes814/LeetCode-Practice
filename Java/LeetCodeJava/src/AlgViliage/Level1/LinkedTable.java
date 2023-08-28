package AlgViliage.Level1;

import java.util.List;

/**
 * @author 欧欧
 * @version 1.0
 */
public class LinkedTable {

//    public static int getListLength(ListNode head) {
//        int length = 0;
//        ListNode node = head;
//        while (head.getNext() != null) {
//            length++;
//            node.setNext(node.getNext());
//        }
//        return length;
//    }
//
//    public static ListNode insertNode(ListNode head, ListNode newNode, int pos) {
//        if (head == null) {
//            return newNode;
//        }
//        if (pos == 1) {
//            newNode.setNext(head);
//            head = newNode;
//            return head;
//        }
//
//        int size = LinkedTable.getListLength(head);
//        if (size + 1 < pos) {
//            System.out.println("pos out of range");
//        }
//
//
//        ListNode node = head;
//
//        for (int i = 1; i < pos - 1; i++) {
//
//
//
//            node = node.getNext();
//            i++;
//        }
//
//        newNode.setNext(node.getNext());
//        node.setNext(newNode);
//        return head;
//
//    }
//    public static ListNode deleteNode(ListNode head, int pos) {
//        if (head == null) {
//            return null;
//        }
//        int size = LinkedTable.getListLength(head);
//
//        if (pos == 1) {
//            head = head.getNext();
//            return head;
//        }
//
//        if (size < pos || pos < 1) {
//            System.out.println("Out of range");
//            return head;
//        }
//
//
//        ListNode node = head;
//
//        for (int i = 1; i < pos - 1; i++) {
//
//
//            node = node.getNext();
//            i++;
//        }
//
//        node.setNext(node.getNext().getNext());
//
//        return head;
//
//    }
}

//class ListNode {
//    private int val;
//    private ListNode next;
//
//    public ListNode(int val) {
//        this.val = val;
//    }
//
//    public int getVal() {
//        return val;
//    }
//
//    public void setVal(int val) {
//        this.val = val;
//    }
//
//    public ListNode getNext() {
//        return next;
//    }
//
//    public void setNext(ListNode next) {
//        this.next = next;
//    }
//}
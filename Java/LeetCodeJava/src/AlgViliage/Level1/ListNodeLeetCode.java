package AlgViliage.Level1;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author 欧欧
 * @version 1.0
 */
public class ListNodeLeetCode {
    public static void main(String[] args) {

    }

    public static ListNodeLC findFirstCommonNodeBySet(ListNodeLC headA, ListNodeLC headB) {
        Set<ListNodeLC> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;

        }

        while (headB != null){
            if (set.contains(headB)) {
                return headB;
            } else {
                headB = headB.next;
            }
        }
        return null;
    }
    public static ListNodeLC findFirstCommonNodeByStack(ListNodeLC headA, ListNodeLC headB) {
        Stack<ListNodeLC> aStack =new Stack();
        Stack<ListNodeLC> bStack =new Stack();

        while (headA != null) {
            aStack.push(headA);
            headA = headA.next;
        }
        while (headB != null) {
            bStack.push(headB);
            headB = headB.next;
        }

        while (!aStack.isEmpty() && !bStack.isEmpty()) {
            ListNodeLC nodeA = aStack.pop();
            ListNodeLC nodeB = bStack.pop();
            if (nodeA == nodeB) {
                return nodeA;
            }
        }

        return null;
    }

    public static boolean backTestValidation(ListNodeLC head) {
        ListNodeLC temp = head;
        Stack<Integer> stack = new Stack();
        int listLengh = 0;
        while (temp != null) {
            stack.push(temp.val);
            listLengh++;
        }
        temp = head;
        for (int i = 0; i < listLengh / 2; i++) {
            if (stack.pop() != temp.val) {
                return false;
            }
            temp = temp.next;

        }
        return true;


    }
    public static ListNodeLC mergeTwoLists(ListNodeLC list1, ListNodeLC list2) {
        ListNodeLC newHead = new ListNodeLC(-1);
        ListNodeLC res = newHead;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                newHead.next = list1;
                list1 = list1.next;
            } else if (list1.val > list2.val) {
                newHead.next = list2;
                list2 = list2.next;
            } else {
                newHead.next = list1;
                list1 = list1.next;
                newHead = newHead.next;
                newHead.next = list2;
                list2 = list2.next;
            }
            newHead = newHead.next;
        }

        while (list1 != null) {
            newHead.next = list1;
            list1 = list1.next;
            newHead = newHead.next;
        }
        while (list2 != null) {
            newHead.next = list2;
            list2 = list2.next;
            newHead = newHead.next;
        }
        return res.next;

    }
    public static ListNodeLC mergeTwoListsOpt(ListNodeLC list1, ListNodeLC list2) {
        ListNodeLC newHead = new ListNodeLC(-1);
        ListNodeLC res = newHead;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                newHead.next = list1;
                list1 = list1.next;
            } else {
                newHead.next = list2;
                list2 = list2.next;
            }
            newHead = newHead.next;
        }

        newHead.next = list1 == null ? list2 : list1;
        return res.next;

    }

    public static ListNodeLC mergeKLists(ListNodeLC[] lists) {
        ListNodeLC res = null;
        for (ListNodeLC list: lists) {
            res = mergeTwoListsOpt(res, list);
        }
        return res;
    }
    public static ListNodeLC mergeInBetween(ListNodeLC list1, int a, int b, ListNodeLC list2) {
        ListNodeLC front = list1;
        for (int i = 1; i < a - 1; i++) {
            front = front.next;
        }
        front.next = list2;
        ListNodeLC end = list1;
        for (int i = 1; i < b + 1; i++) {
            end = end.next;
        }
        ListNodeLC res = front;
        while (res.next != null) {
            res = res.next;
        }
        res.next = end;
        return front;
    }

    public static ListNodeLC middleNode(ListNodeLC head) {
        ListNodeLC slow = head;
        ListNodeLC fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

        }
        return  slow;
    }
    public static ListNodeLC getKthFromEnd(ListNodeLC list, int k) {
        ListNodeLC fast = list;
        ListNodeLC slow = list;
        for (int i = 1; i < k + 1; i++) {
            fast = fast.next;
            if (fast.next == null) {
                break;
            }

        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
    public static ListNodeLC rotateRight(ListNodeLC head, int k) {
        ListNodeLC temp = head;
        int size = 0;
        while(temp != null) {
            temp = temp.next;
            size++;
        }
        if (k > size) {
            k = k % size;
        }
       ListNodeLC front = head;
       ListNodeLC end = getKthFromEnd(head, k);
        for (int i = 1; i <= size - k; i++) {
            front = front.next;
        }
        front.next = null;
        ListNodeLC endTemp = end;
        while(endTemp != null) {
            endTemp = endTemp.next;
        }
        endTemp.next = front;
        return end;


    }
    public static ListNodeLC removeElements(ListNodeLC head, int val) {
        ListNodeLC dummyHead = new ListNodeLC(-1);
        dummyHead.next = head;
        ListNodeLC cur = dummyHead;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }
    public static ListNodeLC removeNthFromEnd(ListNodeLC head, int n) {
        ListNodeLC dummy = new ListNodeLC(-1);
        dummy.next = head;
        ListNodeLC fast = head;
        ListNodeLC second = dummy;
        for (int i = 1; i <= n; i++) {
            fast = fast.next;

        }

        while (fast != null) {
            fast = fast.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    public static ListNodeLC deleteDuplicates(ListNodeLC head) {
        if (head == null) {
            return head;
        }
        ListNodeLC dummy = new ListNodeLC(0);
        dummy.next = head;
        ListNodeLC cur = dummy;
        while(cur.next != null) {
            if (cur.val == cur.next.val) {
                cur = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    public static ListNodeLC findFirstCommonNode(ListNodeLC pHead1, ListNodeLC pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        ListNodeLC p1 = pHead1;
        ListNodeLC p2 = pHead2;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
            if (p1 != p2) {
                if (p1 == null) {
                    p1 = pHead2;
                }
                if (p2 == null) {
                    p2 = pHead1;
                }
            }
        }
        return p1;

    }
    public static ListNodeLC findFirstCommonNode2(ListNodeLC pHead1, ListNodeLC pHead2) {}

}

class ListNodeLC {
    public int val;
    public ListNodeLC next;

    ListNodeLC(int x) {
        val = x;
        next = null;
    }
}

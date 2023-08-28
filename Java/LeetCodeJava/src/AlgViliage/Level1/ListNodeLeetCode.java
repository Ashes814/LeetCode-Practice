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
}

class ListNodeLC {
    public int val;
    public ListNodeLC next;

    ListNodeLC(int x) {
        val = x;
        next = null;
    }
}

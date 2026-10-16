package AlgBlog.ReversedLinkedList;


import java.util.Stack;

public class ReversedLinkList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        System.out.println(reverseKGroup(head, 7));
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        Stack<ListNode> tempStack = new Stack<>();
        ListNode stackNode = head;
        while (stackNode != null) {
            tempStack.push(stackNode);
            stackNode = stackNode.next;
        }
        ListNode res = new ListNode(-1);
        ListNode tempRes = tempStack.pop();
        res.next = tempRes;
        while (!tempStack.isEmpty()) {
            tempRes.next = tempStack.pop();
            tempRes = tempRes.next;
        }
        tempRes.next = null;
        return res.next;
    }

    public static ListNode reverseList02(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode tempNext = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tempNext;
        }
        return pre;
    }

    public static ListNode reverseList03(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList03(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode insertHead = new ListNode(-1);
        insertHead.next = head;
        ListNode cur = head;
        int start = 1;
        int end = 1;
        while (start < left) {
            insertHead = insertHead.next;
            cur = cur.next;
            start++;
            end++;
        }
        ListNode pre = cur;

        while (end < right) {
            if (cur == null || cur.next == null) {
                break;
            }
            ListNode curNext = cur.next;
            insertHead.next = curNext;
            cur.next = curNext.next;
            curNext.next = pre;
            pre = insertHead.next;
            end++;
        }
        if (insertHead.val == -1) {
            return insertHead.next;
        }  else {
            return head;
        }
    }

    public static ListNode reverseBetween02(ListNode head, int left, int right) {
//        ListNode dummyHead = new ListNode(-1);
//        dummyHead.next = head;
//        ListNode pre = dummyHead;
//        ListNode leftNode = head;
//        ListNode rightNode = head;
//        int rightIndicator = 0;
//        for (int i = 0; i < left - 1; i++) {
//            pre = pre.next;
//            leftNode = leftNode.next;
//            rightNode = rightNode.next;
//            rightIndicator++;
//        }
//
//        for (int r = rightIndicator; r < right - 1; r++) {
//            rightNode = rightNode.next;
//        }
//        ListNode succ = rightNode.next;
//
//        rightNode.next = null;
//        pre.next = null;
//        ListNode newReversedList = reverseList(leftNode);
//        pre.next = newReversedList;
//        while (pre.next != null) {
//            pre = pre.next;
//        }
//        pre.next = succ;
//        return dummyHead.next;
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;

        for (int i = 0; i< left - 1; i++) {
            pre = pre.next;
        }

        ListNode rightNode = pre;
        for (int i = 0; i < right - left - 1; i++) {
            rightNode = rightNode.next;
        }

        ListNode leftNode = pre.next;
        ListNode succ = rightNode.next;
        rightNode.next = null;
        reverseList(leftNode);
        pre.next = rightNode;
        leftNode.next = succ;
        return dummyNode.next;
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur = head;
        ListNode pre = dummyHead;
        while (cur != null && cur.next != null) {
            ListNode curNext = cur.next;
            cur.next = curNext.next;
            curNext.next = cur;
            pre.next = curNext;
            pre = cur;
            cur = cur.next;
        }
        return dummyHead.next;
    }


    public static ListNode listPlus1Stack(ListNode head) {
        Stack<ListNode> nodeStack = new Stack<>();
        while (head != null) {
            nodeStack.push(head);
            head = head.next;
        }

        int adder = 0;
        ListNode pre = nodeStack.pop();
        if (pre.val + 1 >= 10) {
            pre.val = pre.val + 1 - 10;
            adder = 1;
        } else {
            pre.val = pre.val + 1;
        }
        while (!nodeStack.isEmpty()) {
            ListNode cur = nodeStack.pop();
            if (adder == 1) {
                if (cur.val + 1 >= 10) {
                    cur.val = cur.val + 1 - 10;
                } else {
                    cur.val = cur.val + 1;
                    adder = 0;
                }



            }
            cur.next = pre;
            pre = cur;

        }
        if (adder == 1) {
            ListNode res = new ListNode(1);
            res.next = pre;
            return res;
        }
        return pre;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> l1Stack = new Stack<>();
        Stack<Integer> l2Stack = new Stack<>();

        while (l1 != null ) {
            l1Stack.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            l2Stack.add(l2.val);
            l2 = l2.next;
        }

        Integer carry = 0;
        ListNode preNode = null;
        while (!l1Stack.isEmpty() && !l2Stack.isEmpty()) {
            Integer newVal = l1Stack.pop() + l2Stack.pop();
            if (carry == 1) {
                if (newVal + 1 >= 10) {
                    carry = 1;
                    newVal = newVal - 10 + 1 ;
                } else {
                    newVal = newVal + 1;
                    carry = 0;
                }

            } else {
                if (newVal >= 10) {
                    carry = 1;
                    newVal = newVal - 10;
                } else {
                    carry = 0;
                }
            }
            ListNode newNode = new ListNode(newVal);
            newNode.next = preNode;
            preNode = newNode;
        }


        while (!l1Stack.isEmpty()) {
            Integer newVal = l1Stack.pop();
            if (carry == 1) {
                if (newVal + 1 >= 10) {
                    carry = 1;
                    newVal = newVal - 10 + 1;
                } else {
                    newVal = newVal + 1;
                    carry = 0;
                }

            } else {
                if (newVal >= 10) {
                    carry = 1;
                    newVal = newVal - 10;
                } else {
                    carry = 0;
                }
            }
            ListNode newNode = new ListNode(newVal);
            newNode.next = preNode;
            preNode = newNode;
        }

        while (!l2Stack.isEmpty()) {
            Integer newVal = l2Stack.pop();
            if (carry == 1) {
                if (newVal + 1 >= 10) {
                    carry = 1;
                    newVal = newVal - 10 + 1;
                } else {
                    newVal = newVal + 1;
                    carry = 0;
                }

            } else {
                if (newVal >= 10) {
                    carry = 1;
                    newVal = newVal - 10;
                } else {
                    carry = 0;
                }
            }
            ListNode newNode = new ListNode(newVal);
            newNode.next = preNode;
            preNode = newNode;
        }

        if (carry == 1) {
            preNode.val = preNode.val - 10;
            ListNode res =  new ListNode(1);
            res.next = preNode;
            return res;
        }

        return preNode;




    }

    public static Boolean isPalindrome02(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head, fast = head;
        ListNode pre = head, prepre = null;

        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;

            // reverse first half
            pre.next = prepre;
            prepre = pre;
        }

        if (fast != null) {
            slow = slow.next;
        }

        while (pre != null && slow != null) {
            if (pre.val != slow.val) {
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }

        return true;
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode pre = dummyHead;
        ListNode cur = head;

        while (cur != null) {
            ListNode explorer = cur;
            int i = 0;
            while (i < k) {

                if (explorer == null) {
                    return dummyHead.next;
                } else {
                    explorer = explorer.next;
                }

                i++;
            }



            for (int j = 0; j < k - 1; j++) {
                ListNode curNext = cur.next;
                cur.next = cur.next.next;
                curNext.next = pre.next;
                pre.next = curNext;

            }
            pre = cur;
            cur = cur.next;



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
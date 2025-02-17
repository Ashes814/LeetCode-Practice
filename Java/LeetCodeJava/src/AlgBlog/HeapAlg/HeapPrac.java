package AlgBlog.HeapAlg;

import java.util.Comparator;
import java.util.PriorityQueue;

public class HeapPrac {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode node2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode node3 = new ListNode(2, new ListNode(6));
        ListNode[] lists = {node1, node2, node3};
        mergeKLists(lists);
    }

    // Using heap to find Ktg largest
    public int findKthLargest(int[] nums, int k) {
        if (k > nums.length) {
            return -1;
        }

        int len = nums.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, (a, b) -> a - b);
        for (int i = 0; i < k; i++) {
            minHeap.add(nums[i]);
        }

        for (int i = k; i < len; i++) {
            Integer topEle = minHeap.peek();
            if (nums[i] > topEle) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
        return minHeap.peek();
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> q = new PriorityQueue<>(Comparator.comparing(node -> node.val));

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                q.add(lists[i]);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (!q.isEmpty()) {
            tail.next = q.poll();
            tail = tail.next;
            if (tail.next != null) {
                q.add(tail.next);
            }
        }

        return dummy.next;
    }
}

class ListNode {
        int val;ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next;}
}

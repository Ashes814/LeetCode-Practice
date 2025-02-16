package AlgBlog.HeapAlg;

import java.util.PriorityQueue;

public class HeapPrac {
    public static void main(String[] args) {

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
}

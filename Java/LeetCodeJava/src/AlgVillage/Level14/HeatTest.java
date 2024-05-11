package AlgVillage.Level14;
import java.util.PriorityQueue;

public class HeatTest {
    public static void main(String[] args) {

    }

    public int findKthLargest(int[] nums, int k) {
        if (k > nums.length) {
            return -1;
        }
        int len = nums.length;
        // Use a min heap with k elements
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

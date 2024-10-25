package AlgBlog.HashQueue;

import java.util.*;

public class HashQueueAlg {
    public static void main(String[] args) {

    }
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hs = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hs.containsKey(target - nums[i])) {
                return new int[] {i, hs.get(target - nums[i])};
            }

            hs.put(nums[i], i);
        }

        return null;

    }

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);

        for (int first = 0; first < n; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }

            int third = n - 1;


            for (int second = first + 1; second < n; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }

                int target = -nums[first] - nums[second];

                while (second < third && nums[third] > target) {
                    third--;
                }

                if (second == third) {
                    break;
                }

                if (nums[third] == target) {
                    ArrayList<Integer> res = new ArrayList<>();
                    res.add(nums[first]);
                    res.add(nums[second]);
                    res.add(nums[third]);
                    ans.add(res);
                }




            }


        }

        return ans;
    }
}



// Using stack to achieve queue
class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;


    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);

    }

    public int pop() {
        if (stack2.isEmpty()) {
            outAndIn();
        }
        return stack2.pop();

    }

    public int peek() {
        if (stack2.isEmpty()) {
            outAndIn();
        }
        return stack2.peek();
    }

    public boolean empty() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public void outAndIn() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }
}

class MyStack {

    Queue<Integer> queueMain;
    Queue<Integer> queueSub;
    public MyStack() {
        queueMain = new LinkedList<Integer>();
        queueSub = new LinkedList<Integer>();
    }

    public void push(int x) {
        queueSub.add(x);
        reverseAndInsert();
    }

    public int pop() {
        return queueMain.poll();
    }

    public int top() {

        return queueMain.peek();
    }

    public boolean empty() {
        if (queueMain.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public void reverseAndInsert() {
        while (!queueMain.isEmpty()) {
            queueSub.add(queueMain.poll());
        }
        Queue<Integer> temp = queueMain;
        queueMain = queueSub;
        queueSub = temp;
    }

}
package AlgVillage.Level5;

import java.math.BigInteger;
import java.util.*;

/**
 * @author 欧欧
 * @version 1.0
 */
public class HashAndQueue {
    public static void main(String[] args) {
//        MyQueue obj = new MyQueue();
//        obj.push(1);
//        obj.push(2);
//        int param_3 = obj.peek();
//        int param_2 = obj.pop();
//
//        boolean param_4 = obj.empty();
//        System.out.println(param_2);
//        System.out.println(param_2);
//        System.out.println(param_4);
        int[] nums = {1,0,-1,0,-2,2};
        int[] nums1 = {2,2,2,2,2};
        int[] nums2 = {1000000000,1000000000,1000000000,1000000000};
//        System.out.println(1000000000+1000000000+1000000000+1000000000);
        System.out.println(fourSum(nums2, -294967296));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for (int first = 0; first < n; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            for (int second = first + 1; second < n; second++) {
                 if (second > first + 1 && nums[second] == nums[second - 1]) {
                     continue;
                 }

//                 int forth = n - 1;

                for (int third = second + 1; third < n; third++) {
                    if (third > second + 1 && nums[third] == nums[third - 1]) {
                        continue;
                    }

                    for (int forth = third + 1; forth < n; forth++) {
                        if (forth > third + 1 && nums[forth] == nums[forth - 1]) {
                            continue;
                        }
                        long res = (long) nums[first] +(long) nums[second] +(long) nums[third] + (long) nums[forth];


                        if (res == target) {
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[first]);
                            list.add(nums[second]);
                            list.add(nums[third]);
                            list.add(nums[forth]);
                            ans.add(list);

                        }
                    }



                }

            }

        }

        return ans;

    }
}

class MyQueue {
    Stack<Integer> inputStack = new Stack<>();
    Stack<Integer> outputStack = new Stack<>();
    public MyQueue() {

    }

    public void push(int x) {
        while (!outputStack.isEmpty()) {
            inputStack.push(outputStack.pop());
        }
        inputStack.push(x);
    }

    public int pop() {
        while (!inputStack.isEmpty()) {
            outputStack.push(inputStack.pop());
        }
        return outputStack.pop();

    }

    public int peek() {
        while (!inputStack.isEmpty()) {
            outputStack.push(inputStack.pop());
        }
        return outputStack.peek();

    }

    public boolean empty() {
        return inputStack.isEmpty() && outputStack.isEmpty();

    }
}
class MyStack {
    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();

    public MyStack() {

    }

    public void push(int x) {
        queue2.offer(x);
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());


        }
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public int pop() {
        return queue1.poll();
    }

    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();

    }
}

class LRUCache {

    public LRUCache(int capacity) {

    }

    public int get(int key) {

    }

    public void put(int key, int value) {

    }
}

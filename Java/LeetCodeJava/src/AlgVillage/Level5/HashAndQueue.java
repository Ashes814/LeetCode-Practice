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
//        int[] nums = {1,0,-1,0,-2,2};
//        int[] nums1 = {2,2,2,2,2};
//        int[] nums2 = {1000000000,1000000000,1000000000,1000000000};
////        System.out.println(1000000000+1000000000+1000000000+1000000000);
//        System.out.println(fourSum(nums2, -294967296));
        Company testCompany = new Company();
        testCompany.addDemand(1);
        testCompany.addDemand(2);
        testCompany.addDemand(3);
        testCompany.addDemand(4);
        testCompany.addDemand(5);
        testCompany.printQueue();
        testCompany.work();
        testCompany.work();
        testCompany.work();
        testCompany.printQueue();
        testCompany.addDemand(6);
        testCompany.addDemand(7);
        testCompany.addDemand(8);
        testCompany.addDemand(9);
        testCompany.printQueue();
        testCompany.work();
        testCompany.work();
        testCompany.work();
        testCompany.work();
        testCompany.printQueue();
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
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {

        }

        public DLinkedNode(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }

    private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;

    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }

        moveToHead(node);
        return node.value;

    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            DLinkedNode newNode = new DLinkedNode(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                DLinkedNode tail = removeTail();
                cache.remove(tail.key);
                --size;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }
}

class Company {
    Queue<Integer> newQueue = new LinkedList<Integer>();
    Queue<Integer> finishQueue = new LinkedList<Integer>();

    public void addDemand(int demand){
        newQueue.add(demand);
    }
    public void work() {
        finishQueue.add(newQueue.poll());
    }
    public void printQueue() {
        System.out.println("New Queue");
        for (int i = 0; i < newQueue.size(); i++) {
            int res = newQueue.poll();
            System.out.println(res);
            newQueue.add(res);


        }

        System.out.println("Finish Queue");
        for (int i = 0; i < finishQueue.size(); i++) {
            int res = finishQueue.poll();
            System.out.println(res);
            finishQueue.add(res);


        }
    }


}

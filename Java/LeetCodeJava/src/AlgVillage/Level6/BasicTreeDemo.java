package AlgVillage.Level6;

import java.sql.Array;
import java.util.*;

/**
 * @author 欧欧
 * @version 1.0
 */
public class BasicTreeDemo {
    public static void main(String[] args) {
        int[] preorder = {9,15,7,20,3};
        int[] inorder = {9,3,15,20,7};
        int[] preorder1 = {8,7,6,5,4,3,2,10,15,14,13,12,11,9,1};
        int[] inorder1 = {3,4,8,6,7,5,2,1,10,9,11,15,13,14,12};
        int[] preorder2 = {-1};
        int[] inorder2 = {-1};
        int[] preorder3 = {1,2,4,5,3};
        int[] inorder3 = {4,2,5,1,3};
        int[] preorder4 = {1,2,4,3,5};
        int[] inorder4 = {4,2,1,3,5};
//        TreeNode tree = buildTree(preorder3, inorder3);
//        System.out.println(tree);
//        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3, null, new TreeNode(5)));
//        List<List<Integer>> level = zigzagLevelOrder(root);
//        System.out.println(level);
        Node NTree = new Node(1, new ArrayList<Node>())
    }

    public static TreeNode buildTree(int[] pre, int[] in) {
        int preLen = pre.length;
        int inLen = in.length;

        if (preLen != inLen) {
            throw new RuntimeException("Incorrect input data.");
        }

        Map<Integer, Integer> map = new HashMap<>(preLen);
        for (int i = 0; i < inLen; i++) {
            map.put(in[i], i);
        }

        return buildTree(pre, 0, preLen - 1, map, 0, inLen - 1);
    }

    private static TreeNode buildTree(int[] pre, int preLeft, int preRight, Map<Integer, Integer> map, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }

        int rootVal = pre[preLeft];
        TreeNode root = new TreeNode(rootVal);
        int pIndex = map.get(rootVal);
        root.left = buildTree(pre, preLeft + 1, pIndex - inLeft + preLeft , map, inLeft, pIndex - 1);
        root.right = buildTree(pre, pIndex - inLeft + preLeft + 1, preRight , map, pIndex + 1, inRight);
        return root;
    }

    public static TreeNode buildTreeBack(int[] back, int[] in) {
        int backLen = back.length;
        int inLen = in.length;

        if (backLen != inLen) {
            throw new RuntimeException("Incorrect input data.");
        }

        Map<Integer, Integer> map = new HashMap<>(backLen);
        for (int i = 0; i < inLen; i++) {
            map.put(in[i], i);
        }

        return buildTreeBack(back, 0, backLen - 1, map, 0, inLen - 1);
    }

    private static TreeNode buildTreeBack(int[] back, int backLeft, int backRight, Map<Integer, Integer> map, int inLeft, int inRight) {
        if (backLeft > backRight || inLeft > inRight) {
            return null;
        }

        int rootVal = back[backRight];
        TreeNode root = new TreeNode(rootVal);
        int pIndex = map.get(rootVal);
        root.left = buildTreeBack(back, backLeft, backRight - inRight + pIndex - 1 , map, inLeft, pIndex - 1);
        root.right = buildTreeBack(back, backRight - inRight + pIndex, backRight - 1 , map, pIndex + 1, inRight);


        return root;
    }

    public static List<List<Integer>> simpleLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();

        }

        List<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> inner = new ArrayList<>();

        int size = 0;
        queue.add(root);
        size++;
        while (!queue.isEmpty()) {

            root = queue.poll();


            inner.add(root.val);
            size--;


            if (root.left != null) {
                queue.add(root.left);
            }

            if (root.right != null) {
                queue.add(root.right);
            }

            if (size == 0) {
                res.add(inner);
                size = queue.size();
                inner = new ArrayList<>();
            }
        }


        return res;

    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> levelOrder = new LinkedList<>();
        if (root == null) {
            return levelOrder;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                TreeNode left = node.left;
                TreeNode right = node.right;
                if (left != null) {
                    queue.offer(left);
                }
                if (right != null) {
                    queue.offer(right);
                }

            }
            levelOrder.add(0, level); //栈, 把前面添加的挪到后面出

        }
        return levelOrder;
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        boolean isOrderLeft = true;
        while (!queue.isEmpty()) {
            Deque<Integer> levelList = new LinkedList<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                if (isOrderLeft) {
                    levelList.offerLast(curNode.val);
                } else {
                    levelList.offerFirst(curNode.val);
                }
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }
            res.add(new LinkedList<Integer>(levelList));
            isOrderLeft = !isOrderLeft;
        }


        return res;
    }

    public List<List<Integer>> levelOrderN(Node root) {
       List<List<Integer>> value = new ArrayList<>();
       Deque<Node> q = new ArrayDeque<>();
       if (root != null) {
           q.addLast(root);
       }
       while (!q.isEmpty()) {
           Deque<Node> next = new ArrayDeque<>();
           List<Integer> nd = new ArrayList<>();
           while (!q.isEmpty()) {
               Node cur = q.pollFirst();
               nd.add(cur.val);
               for (Node chd: cur.children) {
                   if (chd != null) {
                       next.add(chd);
                   }
               }
           }
           q = next;
           value.add(nd);
       }
       return value;
    }


}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

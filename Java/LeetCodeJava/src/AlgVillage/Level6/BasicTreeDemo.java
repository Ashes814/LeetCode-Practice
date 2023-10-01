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
        TreeNode tree = buildTreeBack(preorder, inorder);
        List<List<Integer>> level = simpleLevelOrder(tree);
        System.out.println(level);
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
}

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

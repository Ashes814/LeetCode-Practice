package AlgVillage.Level6;

import java.sql.Array;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 欧欧
 * @version 1.0
 */
public class BasicTreeDemo {
    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        int[] preorder1 = {1,2,3,4,5,6,8,7,9,10,11,12,13,15,14};
        int[] inorder1 = {3,4,8,6,7,5,2,1,10,9,11,15,13,14,12};
        int[] preorder2 = {-1};
        int[] inorder2 = {-1};
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

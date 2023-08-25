package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 欧欧
 * @version 1.0
 */
public class P94 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));



    }
}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }


class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    public TreeNode createTree(List<Integer> values) {
        if (values == null || values.isEmpty()) {
            return null;
        }

        ArrayList<TreeNode> nodes = new ArrayList<>();
        for (Integer value: values) {
            nodes.add(value != null ? new TreeNode(value) : null);
        }

        int parentIndex = 0;
        for (int i = 0; i < nodes.size(); i++) {
            TreeNode parent = nodes.get(parentIndex);
            if (parent != null) {
                int leftChildIndex = 2 * i + 1;
                int rightChildIndex = 2 * i + 2;
                if (leftChildIndex < nodes.size()) {
                    parent.left = nodes.get(leftChildIndex);
                }
                if (rightChildIndex < nodes.size()) {
                    parent.right = nodes.get(rightChildIndex);
                }
            }
            parentIndex++;
        }
        return nodes.get(0);
    }
 }
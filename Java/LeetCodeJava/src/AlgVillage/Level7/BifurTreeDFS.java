package AlgVillage.Level7;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 欧欧
 * @version 1.0
 */
public class BifurTreeDFS {
    public static void main(String[] args) {

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);


    }

    public static void preOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        res.add(root.val);
        preOrder(root.left, res);
        preOrder(root.right, res);

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
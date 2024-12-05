package AlgBlog.DFS;

import java.util.List;

public class DFSTree {
    public static void main(String[] args) {
        TreeNode rootTest = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(2, new TreeNode(4), new TreeNode(3)));
        System.out.println(isSymmetric(rootTest));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
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

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return check(root.left, root.right);
    }

    public static boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }


        if (p.val == q.val) {
            return check(p.left, q.right) && check(p.right, q.left);
        } else {
            return false;
        }


    }

    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }

        if (root2 == null) {
            return root1;
        }

        TreeNode merged = new TreeNode(root1.val + root2.val);
        merged.left = mergeTrees(root1.left, root2.left);
        merged.right = mergeTrees(root1.right, root2.right);
        return merged;



    }

//    public static TreeNode mergeTreeNode(TreeNode root1, TreeNode root2, TreeNode resTree) {
//        if (root1 == null && root2 == null) {
//            resTree = null;
//        }
//
//        if (root1 != null && root2 == null) {
//            resTree = new TreeNode(root1.val);
//        }
//
//        if (root1 == null && root2 != null) {
//            resTree = new TreeNode(root2.val);
//        }
//
//        if (root1 != null && root2 != null) {
//            resTree =  new TreeNode(root1.val + root2.val);
//        }
//
//        resTree.left = mergeTreeNode(root1.left, root2.left, resTree);
//        resTree.right = mergeTreeNode(root1.right, root2.right, resTree);
//
//    }
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
}
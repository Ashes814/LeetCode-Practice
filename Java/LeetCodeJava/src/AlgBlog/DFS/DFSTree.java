package AlgBlog.DFS;

import java.util.ArrayList;
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

    public static List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<String> res = new ArrayList<String>();
        dfs(root, "", res);
        return res;


    };

    public static void dfs(TreeNode root, String path, List<String> res) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            // root is a leaf node
            res.add(path + root.val);
        }
        dfs(root.left, path +root.val + "->", res);
        dfs(root.right, path +root.val + "->", res);

    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {

        return dfsPathNum(root, 0, targetSum);
    }

    public static boolean dfsPathNum(TreeNode root, int curSum, int targetSum) {

        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            curSum += root.val;
            if (targetSum == curSum) {
                return true;
            } else {
                return false;
            }
        }

        return dfsPathNum(root.left, curSum + root.val, targetSum) || dfsPathNum(root.right, curSum + root.val, targetSum);



    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    public static int height(TreeNode root) {
        if (root == null) {
            return 0;
        };

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if (Math.abs(leftHeight - rightHeight) > 1 || leftHeight == -1 || rightHeight == -1) {
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    };

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
package AlgBlog.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLeetcode {
    public static void main(String[] args) {
//        int[] preorder = {3,9,20,15,7};
//        int[] inorder = {9,3,15,20,7};//
        int[] preorder = {-1};
        int[] inorder = {-1};
        buildTree(preorder, inorder);

    }

    public static int[] convertArrayListToIntArray(ArrayList<Integer> arrayList) {
        // Initialize an int array with the size of the ArrayList
        int[] intArray = new int[arrayList.size()];

        // Fill the int array with values from the ArrayList
        for (int i = 0; i < arrayList.size(); i++) {
            intArray[i] = arrayList.get(i); // Auto-unboxing occurs here
        }

        return intArray;
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length <= 0) {
            return null;
        }
        TreeNode rootNode = new TreeNode(preorder[0]);
        ArrayList<Integer> inorderLeft = new ArrayList<>();
        ArrayList<Integer> inorderRight = new ArrayList<>();
        ArrayList<Integer> preorderLeft = new ArrayList<>();
        ArrayList<Integer> preorderRight = new ArrayList<>();

        int rootIndexInorder = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (preorder[0] == inorder[i]) {
                rootIndexInorder = i;
                break;
            } else {
                inorderLeft.add(inorder[i]);
            }
        }

        for (int j = rootIndexInorder + 1; j < inorder.length; j++) {
            inorderRight.add(inorder[j]);
        }

        for (int k = 1; k < preorder.length; k++) {
            if (inorderLeft.contains(preorder[k])) {
                preorderLeft.add(preorder[k]);
            }

            if (inorderRight.contains(preorder[k])) {
                preorderRight.add(preorder[k]);
            }
        }

        rootNode.left = buildTree(convertArrayListToIntArray(preorderLeft), convertArrayListToIntArray(inorderLeft));
        rootNode.right = buildTree(convertArrayListToIntArray(preorderRight), convertArrayListToIntArray(inorderRight));
        return rootNode;

    }

    public static List<Integer> simpleLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }

        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (queue.size() > 0) {
            TreeNode t = queue.remove();
            res.add(t.val);

            if (t.left != null) {
                queue.add(t.left);
            }

            if (t.right != null) {
                queue.add(t.right);
            }
        }
        return res;


    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();

        if (root == null) {
            return new ArrayList<>();
        }

        queue.add(root);

        while (queue.size() > 0) {

            LinkedList<TreeNode> subQueue = new LinkedList<>();
            List<Integer> tempRes = new ArrayList<>();
            while (queue.size() > 0) {
                TreeNode t = queue.remove();

                if (t.left != null) {
                    subQueue.add(t.left);
                }

                if (t.right != null) {
                    subQueue.add(t.right);
                }


                tempRes.add(t.val);

            }

            res.add(tempRes);

            while (subQueue.size() > 0) {
                queue.add(subQueue.remove());
            }



        }
        return res;


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

package AlgVillage.Level18;
import java.util.*;

public class BackTracing {
    public static void main(String[] args) {



    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (k <= 0 || n < k) {
            return resultList;
        }

        Deque<Integer> path = new ArrayDeque<>();
        dfs(n, k, 1, path, resultList);
        return resultList;
    }

    public static void dfs(int n, int k, int startIndex, Deque<Integer> path, List<List<Integer>> resultList) {
        if (path.size() == k) {
           resultList.add(new ArrayList<>(path));
           return;
        }

        for (int i = startIndex; i <= n ; i++) {
            path.addLast(i);
            dfs(n, k, i + 1, path, resultList);
            path.removeLast();

        }
    }

    public void dfs2(TreeNode root, List<Integer> temp, List<String> ans) {
        if (root == null) return;
        temp.add(root.val);
        if (root.left == null && root.right == null) {
            ans.add(getPathString(temp));
        }
        dfs2(root.left, temp, ans);
        dfs2(root.right, temp, ans);
        temp.remove(temp.size() - 1);

    }

    public String getPathString(List<Integer> temp) {
        StringBuilder sb = new StringBuilder();
        sb.append(temp.get(0));
        for (int i = 1; i < temp.size(); i++) {
            sb.append("->").append(temp.get(i));
        }
        return sb.toString();
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        dfs2(root, new ArrayList<>(), ans);
        return ans;


    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        dfs3(root, targetSum, path, res);
        return res;

    }

    public void dfs3(TreeNode root, int targetSum, LinkedList<Integer> path, List<List<Integer>> res) {
        if (root == null) {
            return;
        }

        targetSum -= root.val;
        path.add(root.val);
        if (targetSum == 0 && root.left == null && root.right == null) {
            res.add(new LinkedList(path));
        }

        dfs3(root.left, targetSum, path, res);
        dfs3(root.right, targetSum, path, res);
        path.removeLast();

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


package AlgBlog.BackTracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BackTrackAlg {

    public static void main(String[] args) {
        combine(4, 2);
    }

    // Template
//    void backtracking(int args) {
//        if (args == 0) {
//            // store data
//            return;
//        }
//
//        for (int i = 0; i < args; i++) {
//            // handle nodes
//            backtracking(args);
//            // backtracking, recall result
//        }
//    }

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

        for (int i = startIndex; i <= n; i++) {
            path.addLast(i);
            dfs(n, k, i + 1, path, resultList);
            path.removeLast();

        }
    }





}

class CombinationSum {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, 0, target);
        return res;
    }

    public void dfs(int[] c, int u, int target) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = u; i < c.length ; i++) {
            if (c[i] <= target) {
                path.add(c[i]);
                dfs(c, i, target - c[i]);
                path.remove(path.size() - 1);
            }

        }
    }
}

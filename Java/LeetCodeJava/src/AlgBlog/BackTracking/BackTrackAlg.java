package AlgBlog.BackTracking;

import java.util.*;

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

class Partition {
    List<List<String>> lists = new ArrayList<>();
    Deque<String> deque = new LinkedList<>();

    public List<List<String>> partition(String s) {
        backTracking(s, 0);
        return lists;
    }

    public void backTracking(String s, int startIndex) {
        if (startIndex >= s.length()) {
            lists.add(new ArrayList<>(deque));
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            if (isPalindrome(s, startIndex, i)) {
                String str = s.substring(startIndex, i + 1);
                deque.addLast(str);
            } else {
                continue;
            }
            backTracking(s, i + 1);
            deque.removeLast();

        }
    }

    private boolean isPalindrome(String s, int startIndex, int end) {
        for (int i = startIndex, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }

        }
        return true;
    }
}

class Subsets {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> temp = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0) {
            res.add(new ArrayList<>());
            return res;
        }

        subsetsHelper(nums, 0);
        return res;

    }

    public void subsetsHelper(int[] nums, int startIndex) {
        res.add(new ArrayList<>(temp));
        if (startIndex >= nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            temp.add(nums[i]);
            subsetsHelper(nums, i + 1);
            temp.removeLast();

        }
    }
}

class Permute {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> temp = new LinkedList<>();
    boolean[] used;
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return res;
        }
        used = new boolean[nums.length];
        permuteHelper(nums);
        return res;

    }

    public void permuteHelper(int[] nums) {
        res.add(new ArrayList<>(temp));
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            temp.add(nums[i]);

            permuteHelper(nums);


            temp.removeLast();
            used[i] = false;

        }
    }
}
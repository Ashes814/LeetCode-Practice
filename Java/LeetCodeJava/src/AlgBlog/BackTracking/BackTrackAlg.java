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

class ABCPermute {

    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<String>();
        helper(s.toCharArray(), 0, ans);
        return ans;
    }

    public void helper(char[] arr, int pos, List<String> res) {
        while (pos < arr.length && Character.isDigit(arr[pos])) {
            pos++;
        }

        if (pos == arr.length) {
            res.add(new String(arr));
            return;
        }
        arr[pos] ^= 32;
        helper(arr, pos + 1, res);
        arr[pos] ^= 32;
        helper(arr, pos + 1, res);

    }

}

class FindWord {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0)) {
                    return true;
                }
            }

        }
        return false;
    }

    public boolean dfs(char[][] board, char[] words, int i, int j, int k) {
        if (i >= board.length || i < 0 ||j >= board[0].length || j < 0 || board[i][j] != words[k]) {
            return false;
        }

        if (k == words.length - 1) {
            return true;
        }

        board[i][j] = '\0';

        boolean res = dfs(board, words, i + 1, j, k + 1) ||
                      dfs(board, words, i - 1 , j, k + 1) ||
                      dfs(board, words, i, j + 1, k + 1) ||
                      dfs(board, words, i, j - 1, k + 1);

        board[i][j] = words[k];
        return res;
    }
}
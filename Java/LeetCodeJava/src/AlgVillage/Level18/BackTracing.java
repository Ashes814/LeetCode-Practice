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
        dfs(n, k, 1, path, res);
        return res;
    }

    public static void dfs(int n, int k, int startIndex, Deque<Integer> path, List<List<Integer>> resultList) {

    }
}

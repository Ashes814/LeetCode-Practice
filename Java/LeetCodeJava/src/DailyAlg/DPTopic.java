package DailyAlg;

import java.util.List;

public class DPTopic {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        for (int i = 0; i < m - 1; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j - 1] + dp[j];
            }
        }

        return dp[n - 1];


    }

    public int search(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }

        return search(m - 1, n) + search(m, n - 1);
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] f = new int[m][n];
        f[0][0] = grid[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0 && j > 0) {
                    f[i][j] = Math.min(f[i - 1][j], f[i][j - 1]) + grid[i][j];
                } else if (j > 0) {
                    f[i][j] = f[i][j - 1] + grid[i][j];
                } else if (i > 0) {
                    f[i][j] = f[i - 1][j] + grid[i][j];
                }
            }
        }
        return f[m-1][n-1];
    }

    public int minimumTotal(List<List<Integer>> tri) {
        int n = tri.size();
        int[][] f = new int[n][n];
        for (int i = 0; i < n; i++) {
            int m = tri.get(i).size();
            for (int j = 0; j < m; j++) {
                if (i == 0) {
                    f[i][j] = tri.get(i).get(j);
                } else if (j == 0) {
                    f[i][j] = tri.get(i - 1).get(j) + tri.get(i).get(j);
                } else {
                    f[i][j] = Math.min(tri.get(i - 1).get(j - 1),tri.get(i - 1).get(j)) + + tri.get(i).get(j);
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (f[n-1][i] < ans) {
                ans = f[n-1][i];
            }
        }
        return ans;
    }

    // leetcode 931
    public int minFallingPathSum(int[][] matrix) {

    }
}

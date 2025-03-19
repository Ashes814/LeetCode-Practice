package AlgBlog.Dynamic;

import java.util.Arrays;
import java.util.List;

public class DynamicCode {
    public static void main(String[] args) {

    }

    public int uniquePaths(int m, int n) {
        return search(m, n);

    }

    public int search(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }

        return search(m - 1, n) + search(m, n - 1);
    }

    public int uniquePaths2(int m, int n) {
        int[][] f = new int[m][n];
        f[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0 && j > 0) {
                    f[i][j] = f[i - 1][j] + f[i][j - 1];
                } else if (i > 0) {
                    f[i][j] = f[i - 1][j];
                } else if (j > 0) {
                    f[i][j] = f[i][j - 1];
                }
            }
        }
        return f[m - 1][n - 1];
    }


    // Using a rolling array
    public int uniquePaths3(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j - 1] + dp[j];
            }

        }
        return dp[n - 1];
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[][] f = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    f[i][j] = grid[i][j];
                } else {
                    int top = i - 1 >= 0 ? f[i - 1][j] + grid[i][j] : Integer.MAX_VALUE;
                    int bottom = j - 1 >= 0 ? f[i][j - 1] + grid[i][j] : Integer.MAX_VALUE;
                    f[i][j] = Math.min(top, bottom);
                }

            }

        }
        return f[m - 1][n - 1];
    }

    public int minimumTotal(List<List<Integer>> tri) {
        int n = tri.size();
        int ans = Integer.MAX_VALUE;
        int[][] f = new int[n][n];
        f[0][0] = tri.get(0).get(0);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                int val = tri.get(i).get(j);
                f[i][j] = Integer.MAX_VALUE;
                if (j != 0) {
                    f[i][j] = Math.min(f[i][j], f[i - 1][j - 1] + val);
                }
                if (j != i) {
                    f[i][j] = Math.min(f[i][j], f[i - 1][j] + val);
                }
            }

        }
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, f[n - 1][i]);

        }
        return ans;
    }
}

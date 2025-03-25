package AlgBlog.Dynamic;

import java.util.ArrayList;
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

    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }

        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] f = new int[n];
        int i, j, res = 0;
        for (j = 0; j < n; j++) {
            f[j] = 1;
            for (i = 0; i < j; i++) {
                if (nums[i] < nums[j] && f[i] + 1 > f[j]) {
                    f[j] = f[i] + 1;
                }
            }
            res = Math.max(res, f[j]);
        }
        return res;

    }

    public int numSquares(int n) {
        int[] f = new int[n + 1];
        f[0] = 0;
        for (int i = 1; i <= n; i++) {
            f[i] = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                if (f[i - j * j] + 1 < f[i]) {
                    f[i] = f[i - j * j] + 1;
                }

            }

        }
        return f[n];
    }

    public int numDecodings(String s) {
        int n = s.length();
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (s.charAt(i - 1) != '0') {
                f[i] += f[i - 1];
            }

            if (i > 1 && (check(s, i))) {
                f[i] += f[i - 2];
            }


        }
        return f[n];
    }

    public boolean check(String s, int i) {
        if (s.charAt(i - 2) == '0') {
            return false;
        }
        if ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') > 26) {
            return false;
        }
        return true;
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[] dp = new int[m];
        dp[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                    continue;
                }

                if (j - 1 >= 0 && obstacleGrid[i][j - 1] == 0) {
                    dp[j] += dp[j - 1];
                }

            }

        }
        return dp[m - 1];
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<Integer>();
        row.add(1);
        for (int i = 1; i <= rowIndex ; i++) {
            row.add(0);
            for (int j = i; j > 0 ; j--) {
                row.set(j, row.get(j) + row.get(j - 1));

            }
        }
        return row;
    }

    public static String longestPalindrome(String s) {
        int sLen = s.length();
        if (sLen <= 1) {
            return s;
        }

        int[] dp = new int[sLen];
        dp[0] = 0;
        for (int i = 1; i < sLen; i++) {
            dp[i] = 0;
            for (int j = 0; j < i; j++) {

            }

        }
    }
}




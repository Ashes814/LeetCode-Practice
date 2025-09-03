package DailyAlg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DPTopic {
    public static void main(String[] args) {
//        int[][] matrix = {{-19,57},{-40, 5}};
//        minFallingPathSum(matrix);
        numDecodings("06");
    }
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
    public static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] f = new int[n][n];

        for (int i = 0; i < n; i++) {
            f[0][i] = matrix[0][i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int m = matrix[i][j];
                if (j == 0) {
                    f[i][j] = Math.min(f[i-1][j], f[i-1][j+1]) + m;
                } else if (j == n - 1) {
                    f[i][j] = Math.min(f[i-1][j], f[i-1][j-1]) + m;
                }
                else {
                    f[i][j] = Math.min(Math.min(f[i-1][j], f[i-1][j-1]),  f[i-1][j+1]) + m;
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.min(res, f[n - 1][i]);
        }

        return res;
    }

    public static int coinChange(int[] coins, int M) {
        int max = M + 1;
        int[] dp = new int[M + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i < max; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }

        }
        return dp[M] > M ? -1 : dp[M];
    }

    public static int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];
        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                dp[i] = 1;
            }
            if (i > 0 && nums[i - 1] < nums[i]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }
            res = Math.max(res, dp[i]);
        }

        return res;
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n];
        int i, j, res = 0;
        for (j = 0; j < n; j++) {
            dp[j] = 1;
            for (i = 0; i < j; i++) {
                if (nums[i] < nums[j] && dp[i] + 1 > dp[j]) {
                    dp[j] = dp[i] + 1;
                }
            }
            res = Math.max(res, dp[j]);
        }

        return res;

    }

    public int numSquares(int n) {
        int[] f = new int[n + 1];
        f[0] = 0;

        for (int i = 1; i < n + 1; i++) {
            f[i] = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                if (f[i - j * j] + 1 < f[i] ) {
                    f[i] = f[i - j * j] + 1;
                }
            }
        }

        return f[n];
    }

    public boolean canJump(int[] nums) {
        boolean[] f = new boolean[nums.length];
        f[0] = true;
        int i = 0;
        while (i < nums.length && f[i]) {
            for (int j = 0; j <= nums[i]; j++) {
                if (i + j < nums.length) {
                    f[i + j] = true;
                }

            }
            i++;
        }
        return f[nums.length - 1];
    }

    public static int numDecodings(String s) {
        int n = s.length();
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (s.charAt(i - 1) != '0') {
                f[i] += f[i - 1];
            }

            if (i > 1 &&
                s.charAt(i - 2) != '0'
                && (s.charAt(i - 2) - '0') *10 + (s.charAt(i - 1) - '0') <= 26)
            {
                f[i] += f[i - 2];

            }
        }
        return f[n];
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

    public List<List<Integer>> generate(int numRows) {
        List<Integer> pre = new ArrayList<Integer>();
        for (int i = 0; i <= numRows; i++) {
            List<Integer> cur = new ArrayList<Integer>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    cur.add(1);
                } else {
                    cur.add(pre.get(j - 1) + pre.get(j));
                }
            }
            pre = cur;
        }
        return pre;
    }

}

package AlgVillage.Level19;

public class DynamicOptimization {
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

    public int uniquePathsLevel2(int m, int n) {
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

        return f[m - 1][n - 1]
    }
}

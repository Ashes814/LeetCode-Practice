package DailyAlg;

public class DPTopic {
    public int uniquePaths(int m, int n) {
        return search(m, n);
    }

    public int search(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }

        return search(m - 1, n) + search(m, n - 1);
    }
}

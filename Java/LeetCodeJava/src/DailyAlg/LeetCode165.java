package DailyAlg;

public class LeetCode165 {
    public static void main(String[] args) {

    }

    public int compareVersion(String version1, String version2) {
        String[] v1Arr = version1.split("\\.");
        String[] v2Arr = version2.split("\\.");
        int left = 0;
        int right = 0;

        while (left < v1Arr.length && right < v2Arr.length) {


            if (Integer.valueOf(v1Arr[left]) > Integer.valueOf(v2Arr[right])) {
                return 1;
            } else if (Integer.valueOf(v1Arr[left]) < Integer.valueOf(v2Arr[right])) {
                return -1;
            }

            left++;
            right++;
        }

        if (left == v1Arr.length && right < v2Arr.length) {
            while (right < v2Arr.length) {
                if (Integer.valueOf(v2Arr[right]) > 0) {
                    return -1;
                }
                right++;
            }
        }

        if (right == v2Arr.length && left < v1Arr.length) {
            while (left < v1Arr.length) {
                if (Integer.valueOf(v1Arr[left]) > 0) {
                    return 1;
                }
                left++;
            }
        }

        return 0;

    }
}

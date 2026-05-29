package DailyAlg;

public class Leetcode28 {
    public static void main(String[] args) {
        String haystack = "leetcode";
        String needle = "leeto";
        System.out.println(strStr(haystack, needle));
    }

    public static int strStr(String haystack, String needle) {
        int needleLen = needle.length();
        char[] needleArray = needle.toCharArray();
        char[] haystackArray = haystack.toCharArray();

        for (int i = 0; i <= haystack.length() - needleLen; i++) {
            for (int j = 0; j < needleLen; j++) {
                if (haystackArray[i + j] != needleArray[j]) {
                    break;
                }

                if (j == needleLen - 1) {
                    return i;
                }
            }
        }
        return -1;
    }
}

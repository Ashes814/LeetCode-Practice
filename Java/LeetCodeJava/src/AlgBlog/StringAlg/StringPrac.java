package AlgBlog.StringAlg;

public class StringPrac {
    public static void main(String[] args) {


    }

    public String toLowerCase(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        for (int i = 0; i < n; i++) {
            if (chars[i] >= 65 && chars[i] <= 90) {
                chars[i] += 32;
            }

        }
        return new String(chars);
    }
}

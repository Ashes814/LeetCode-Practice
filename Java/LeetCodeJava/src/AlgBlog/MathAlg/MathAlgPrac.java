package AlgBlog.MathAlg;

public class MathAlgPrac {
    public static void main(String[] args) {

    }

    public int arraySign(int[] nums) {
        int sign = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                sign *= -1;
            } else if (nums[i] > 0) {
                sign *= 1;

            } else {
                return 0;
            }
        }
        return sign;
    }
}

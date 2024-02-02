package AlgVillage.Level13;

/**
 * @author 欧欧
 * @version 1.0
 */
public class MathAlgorithms {
    public static void main(String[] args) {

    }

    public static int arraySign(int[] nums) {
        int negCount = 0;
        for (int n: nums) {
            if (n == 0) {
                return 0;
            }
            if (n < 0) {
                negCount++;
            }
        }

        if ((negCount % 2) == 0) {
            return 1;
        } else {
            return -1;
        }
    }


}

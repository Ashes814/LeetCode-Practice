package AlgBlog.Greedy;

public class GreedyCode {
    public static void main(String[] args) {
        int[] testArray = {3,2,1,0,4};
        System.out.println(canJump(testArray));
    }

    public static boolean canJump(int[] nums) {
        int cover = 0;
        for (int i = 0; i < nums.length;) {
            cover = Math.max(cover, i + nums[i]);
            if (cover >= nums.length - 1) {
                return true;
            }
            if (nums[i] >= 1 || cover > i) {
                i++;
            } else {
                break;
            }
        }
        return false;
    }


}

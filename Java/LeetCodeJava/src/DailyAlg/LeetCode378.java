package DailyAlg;
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;


public class LeetCode378 {
    public static void main(String[] args) {
        int[][] testMatrix = {{1,5,9},{10,11,13},{12,13,15}};
        System.out.println(kthSmallest(testMatrix, 8));
        
    }

    public static int kthSmallest(int[][] matrix, int k) {
        ArrayList<Integer> temp = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;
<<<<<<< HEAD
        int t = 0;
        for (int i = 0; i < rows; i++) {
            if (t >= k) {
                break;
            }
            for (int j = 0; j < cols; j++) {
                if (t < k) {
                    temp.add(matrix[i][j]);
                    t++;
                } else {
                    break;
                }
=======
 
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                temp.add(matrix[i][j]);


>>>>>>> 993b461 (pass 389)
            }
        }

        Collections.sort(temp);
        return temp.get(k - 1);

    }
}

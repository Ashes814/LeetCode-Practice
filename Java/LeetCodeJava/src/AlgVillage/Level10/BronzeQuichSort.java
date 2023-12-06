package AlgVillage.Level10;

/**
 * @author 欧欧
 * @version 1.0
 */
public class BronzeQuichSort {
    public static void main(String [] args) {

    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = arr[right];
            int i = left - 1;
            for (int j = left; j < right; j++) {
                if (arr[j] < pivot) {
                    i++;
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;

                }
            }


        }

    }
}

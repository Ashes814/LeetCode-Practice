package AlgVillage.Level10;

/**
 * @author 欧欧
 * @version 1.0
 */
public class BronzeQuichSort {
    public static void main(String [] args) {

        int[] testArray = {26, 53, 48,15,13,48,32,15};
        quickSort(testArray, 0, testArray.length - 1);
        for (int i = 0; i < testArray.length - 1; i++) {
            System.out.println(testArray[i]);
        }

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

            int pivotIndex = i + 1;
            int temp = arr[pivotIndex];
            arr[pivotIndex] = arr[right];
            arr[right] = temp;

            quickSort(arr, left, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, right);
        }

    }
}

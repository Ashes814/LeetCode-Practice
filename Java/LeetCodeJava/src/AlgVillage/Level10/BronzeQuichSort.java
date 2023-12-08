package AlgVillage.Level10;

/**
 * @author 欧欧
 * @version 1.0
 */
public class BronzeQuichSort {
    public static void main(String [] args) {

        int[] testArray = {26, 53, 48,15,13,48,32,15};
        quickSort2(testArray, 0, testArray.length - 1);
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

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= pivot) {
                high--;

            }
            arr[low] = arr[high];

            while (low < high && arr[low] <= pivot) {
                low++;

            }
            arr[high] = arr[low];
        }
        arr[low] = pivot;
        return low;
    }

    public static void quickSort2(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort2(arr, low, pivotIndex - 1);
            quickSort2(arr, pivotIndex + 1, high);

        }
    }
}

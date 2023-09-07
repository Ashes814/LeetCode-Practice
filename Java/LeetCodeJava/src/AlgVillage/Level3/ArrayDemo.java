package AlgVillage.Level3;

/**
 * @author 欧欧
 * @version 1.0
 */
public class ArrayDemo {
    public static void main(String[] args) {
        int[] testArr = {1,3,5,7,9,0, 0, 0, 0};
        System.out.println(removeByElement(testArr, 5, 1));
        for (int i = 0; i < testArr.length; i++) {
            System.out.println(testArr[i]);

        }

    }

    public static int findByElement(int[] arr, int size, int key) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == key) {
                return i;
            }


        }
        return -1;
    }
    public static int findBig(int[] arr, int size, int key) {
        for (int i = 0; i < size; i++) {
            if (arr[i] >= key) {
                return i;
            }


        }
        return -1;
    }

    public static int addByElementSequence(int[] arr, int size, int element) {
        if (arr.length <= size) {
            return -1;

        }

        int index = size;
        for (int i = 0; i < size; i++) {
            if (element < arr[i]) {
                index = i;
                break;
            }

        }

        for (int j = size; j > index ; j--) {
            arr[j] = arr[j - 1];

        }
        arr[index] = element;
        return index;

    }
    public static int addByElementSequence2(int[] arr, int size, int element) {
        if (arr.length <= size) {
            return -1;

        }


        for (int i = size; i > 0; i--) {
            if (element > arr[i - 1]) {
                arr[i] = element;
                return i;
            } else {
                arr[i] = arr[i - 1];
                arr[i - 1] = element;
            }
        }
        return 0;


    }

    public static int removeByElement(int[] arr, int size, int key) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (arr[i] == key) {
                index = i;
                break;
            }

        }

        if (index == -1) {
            return -1;
        }
        for (int i = index; i < size; i++) {
            arr[i] = arr[i + 1];
        }
        return index;
    }
}

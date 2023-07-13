package com.demo;

/**
 * @author 欧欧
 * @version 1.0
 */
public class QuickSort {
    public static void startSort(SqList L) {
        SqList newL = new SqList(new int[L.length + 1]);
        newL.r[0] = 0;
        for (int i = 1; i < L.length + 1; i++) {
            newL.r[i] = L.r[i - 1];

        }
        L.r = newL.r;
        QSort(L, 1, L.length);
    }

    public static void QSort(SqList L, int low, int high) {
        int pivot;
        if (low < high) {
            pivot = Partition(L, low, high); // 将low-high一分为二，计算pivot
            QSort(L, low, pivot - 1);
            QSort(L, pivot + 1, high);

        }
    }

    public static int Partition(SqList L, int low, int high) {
        int pivotkey;
        pivotkey = L.r[low];
        while (low < high) {
            while (low < high && L.r[high] >= pivotkey) {
                high--;

            }
            SqList.swap(L, low, high);
            while (low < high && L.r[low] <= pivotkey) {
                low++;

            }
            SqList.swap(L, low, high);
        }
        return low;
    }

}

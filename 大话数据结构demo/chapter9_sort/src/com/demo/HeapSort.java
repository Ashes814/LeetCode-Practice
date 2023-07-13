package com.demo;

/**
 * @author 欧欧
 * @version 1.0
 */
public class HeapSort {

    public static void startSort(SqList L) {
        SqList newL = new SqList(new int[L.length + 1]);
        newL.r[0] = 0;
        for (int i = 1; i < L.length + 1; i++) {
            newL.r[i] = L.r[i - 1];

        }
        L.r = newL.r;

        for (int i = L.length / 2; i > 0; i--) {
            HeapAdjust(L, i, L.length);
        }

        for (int i = L.length; i > 1 ; i--) {
            SqList.swap(L, 1, i);
            HeapAdjust(L, 1, i - 1);
        }
    }

    public static void HeapAdjust(SqList L, int s, int m) {
        int temp = L.r[s];
        for (int j = 2 * s; j <= m; j *= 2) {
            System.out.println(j);
            if (j < m && L.r[j] < L.r[j + 1]) {
                j = j + 1;
            }

            if (temp >= L.r[j]) {
                break;
            }

            L.r[s] = L.r[j];
            s = j;
        }
        L.r[s] = temp;

    }
}

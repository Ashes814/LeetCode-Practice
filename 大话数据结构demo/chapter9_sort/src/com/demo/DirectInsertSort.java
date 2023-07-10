package com.demo;

/**
 * @author 欧欧
 * @version 1.0
 */
public class DirectInsertSort {
    public static void startSort(SqList L) {

        for (int i = 1; i < L.length ;i++) {
            if (L.r[i] < L.r[i - 1]) {
                L.r[0] = L.r[i];
                for (int j = i - 1; L.r[j] > L.r[0] ; j--) {
                    L.r[j+1] = L.r[j];
                }
            }
        }

    }

}

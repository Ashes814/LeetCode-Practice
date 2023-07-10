package com.demo;

/**
 * @author 欧欧
 * @version 1.0
 */
public class ShellSort {
    public static void startSort(SqList L) {
        int increment = L.length;
        int j;
        do {
            increment = increment / 3 + 1;
            for (int i = increment + 1; i <= L.length ; i++) {
                if (L.r[i] < L.r[i - increment]) {
                    L.r[0] = L.r[i];

                    for (j = i - increment; j>0&&L.r[0]<L.r[j];j-=increment) {
                        L.r[j+increment] = L.r[j];

                    }
                    L.r[j+increment] = L.r[0];
                }

            }
        } while (increment > 1);

    }
}

package com.demo;

/**
 * @author 欧欧
 * @version 1.0
 */
public class BubbleSort {
    public static void startSort(SqList L) {
        boolean flag = true;
        int count = 0;
        for (int i = 0; i < L.length & flag; i++) {
            flag = false;
            for (int j = 0; j < L.length - i - 1; j++) {
                count++;
                if (L.r[j + 1] < L.r[j]) {
                    SqList.swap(L, j, j + 1);
                    flag = true;
                }

            }

        }
        System.out.println(count);
    }

    public static void main(String[] args) {
//        int[] testArr = {3,2,4,1,1,1,5,7,8};
        int[] testArr = {0,1,2,3,4,5, 6,7,8};
        SqList test = new SqList(testArr);
        System.out.println(test);
        startSort(test);
        System.out.println(test);
    }
}

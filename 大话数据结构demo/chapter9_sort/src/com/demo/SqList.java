package com.demo;

/**
 * @author 欧欧
 * @version 1.0
 */
public class SqList {
    int[] r;
    int length;

    public SqList(int[] r) {
        this.r = r;
        this.length = r.length;
    }

    public static void swap(SqList L, int i, int j) {
        int temp = L.r[i];
        L.r[i] = L.r[j];
        L.r[j] = temp;
    }

    @Override
    public String toString() {
        for (int i = 0; i < this.length; i++) {
            System.out.print(this.r[i] + " ,");

        }
        return "Ok";
    }
}

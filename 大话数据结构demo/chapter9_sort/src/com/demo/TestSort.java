package com.demo;

/**
 * @author 欧欧
 * @version 1.0
 */
public class TestSort {
    public static void main(String[] args) {
        int[] testArr = {50, 10, 90, 30, 70, 40, 80, 60, 20};
        SqList test = new SqList(testArr);
        QuickSort.startSort(test);
        System.out.println(test);
    }
}

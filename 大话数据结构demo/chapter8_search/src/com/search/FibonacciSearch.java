package com.search;

/**
 * @author 欧欧
 * @version 1.0
 */
public class FibonacciSearch {
    static int[] F = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34};

    public static int startSearch(int[] a, int n, int key) {
        int low, high, mid, i, k;
        low = 1;
        high = n;
        k = 0;

        while (n > F[k] - 1) {
            k++;
        }
        for (i = n; i < F[k] - 1; i++) {
//            System.out.println(i);
//            System.out.println(n);
            a[i] = a[n];
        }

        while (low <= high) {
            mid = low + F[k-1] - 1;
            if (key < a[mid]) {
                high = mid - 1;
                k -= 1;

            } else if (key > a[mid]) {
                low = mid + 1;
                k -= 2;
            } else {
                if (mid <= n) {
                    return mid;
                } else {
                    return n;
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        int[] a = {0, 1, 16, 24, 35, 47, 59, 62, 73, 88, 99, 0, 0, 0, 0, 0, 0};
        int res = startSearch(a, 10, 59);
        System.out.println(res);
    }


}

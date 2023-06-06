package com.chapter5;

import java.sql.Array;

/**
 * @author 欧欧
 * @version 1.0
 */
public class KMP {
    public static void main(String[] args) {
        KMPstringMatch kmPstringMatch1 = new KMPstringMatch("abcdefgh", "def");
        KMPstringMatch kmPstringMatch2 = new KMPstringMatch("abcdefgh", "gh");
        KMPstringMatch kmPstringMatch3 = new KMPstringMatch("abcdefgh", "abc");
        KMPstringMatch kmPstringMatch4 = new KMPstringMatch("abcdefgh", "d");

        System.out.println(kmPstringMatch1.indexKMP());
        System.out.println(kmPstringMatch2.indexKMP());
        System.out.println(kmPstringMatch3.indexKMP());
        System.out.println(kmPstringMatch4.indexKMP());

    }
}

class KMPstringMatch {
    String string1;
    String string2;
    int pos = 0;
    int[] next;

    public KMPstringMatch(String string1, String string2) {
        this.string1 = string1;
        this.string2 = string2;
        next =new int[string2.length()];


    }

    public void getNext() {

        int i = 0;
        int j = -1;
        next[0] = -1;

        while (i < string2.length() - 1 ) {
            if (j == -1 || string2.charAt(i) == string2.charAt(j)) {
                i++;
                j++;
                next[i] = j;

            } else {
                j = next[j];
            }
        }


    }

    public int indexKMP() {
        int sIndex = pos;
        int tIndex = 0;

//        getNext();
        getNextOptim();
        while (sIndex <= string1.length() - 1 && tIndex <= string2.length() - 1) {
            if (tIndex == -1 || string1.charAt(sIndex) == string2.charAt(tIndex) ) {
                sIndex++;
                tIndex++;

            } else {
                tIndex = next[tIndex];
            }
        }

        if (tIndex > string2.length() - 1) {
            return sIndex - string2.length();
        } else {
            return -1;
        }

    }

    public void getNextOptim() {

        int i = 0;
        int j = -1;
        next[0] = -1;

        while (i < string2.length() - 1 ) {
            if (j == -1 || string2.charAt(i) == string2.charAt(j)) {
                i++;
                j++;

                // 当前缀字符与当前字符相同时，将当前next数组位保持与前缀一致
                if (string2.charAt(i) != string2.charAt(j)) {
                    next[i] = j;
                } else {
                    next[i] = next[j];
                }


            } else {
                j = next[j];
            }
        }


    }
}

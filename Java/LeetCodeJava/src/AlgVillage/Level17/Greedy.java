package AlgVillage.Level17;

import java.util.*;
public class Greedy {
    public static void main(String[] args) {


        int[] testG = {1, 2};
        int[] testS = {1,2,3};
        System.out.println(findContentChildren(testG, testS));

    }

    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int maxChild = 0;

        int curBis = 0;
        for (int i = 0; i < g.length; i++) {
            for (int j = curBis; j < s.length; j++) {
                if (g[i] <= s[j]) {
                    maxChild++;
                    curBis = j + 1;
                    break;
                }
                curBis++;
            }

            if (curBis == s.length) {
                return maxChild;
            }

        }
        return maxChild;
    }
}

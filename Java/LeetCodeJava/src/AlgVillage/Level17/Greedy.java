package AlgVillage.Level17;

import java.util.*;
public class Greedy {
    public static void main(String[] args) {


        int[][] testG ={{1,3},{6,9}};
        int[] testS = {2,5};
//        System.out.println(findContentChildren(testG, testS));
//        System.out.println(insert(testG, testS));
        System.out.println(partitionLabels(new String("ababcbacadefegdehijhklij")));
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

    public static boolean lemonadeChange(int[] bills) {
        int curMoney5 = 0;
        int curMoney10 = 0;
        int curMoney20 = 0;
        int repay = 0;
        int curBill = 0;
        for (int i = 0; i < bills.length; i++) {
            curBill = bills[i];
            if (curBill == 5) {
                curMoney5++;
            } else if (curBill == 10) {
                curMoney10++;
            } else {
                curMoney20++;
            }

            repay = curBill - 5;
            if (repay == 0) {
                continue;
            } else if (repay == 5) {
                if (curMoney5 > 0) {
                    curMoney5--;
                    continue;

                } else {
                    return false;
                }
            } else if (repay == 15) {
                if ((curMoney10 > 0) && (curMoney5 > 0)) {
                    curMoney10--;
                    curMoney5--;
                    continue;
                } else if ((curMoney10 == 0) && (curMoney5 >= 3)) {
                    curMoney5 = curMoney5 -3;
                    continue;
                } else {
                    return false;
                }
            }

        }
        return true;
    }

    public static int candy(int[] ratings) {
        int[] candyVec = new int[ratings.length];
        candyVec[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] <= ratings[i - 1]) {
                candyVec[i] = 1;
            } else {
                candyVec[i] = candyVec[i - 1] + 1;
            }
        }

        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candyVec[i] = Math.max(candyVec[i], candyVec[i + 1] + 1);
            }
        }

        int res = 0;
        for (int i: candyVec) {
            res += i;
        }

        return res;

    }

    public static boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);

        int curEnd = 0;
        for (int i = 0; i < intervals.length - 1; i++) {
            curEnd = intervals[i][1];
            if (curEnd > intervals[i + 1][0]) {
                return false;
            }

        }
        return true;
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);

        int[][] res = new int[intervals.length][2];
        int idx = -1;
        for (int[] interval: intervals) {
            if (idx == -1 || res[idx][1] < interval[0]) {
                res[++idx] = interval;
            } else {
                res[idx][1] = Math.max(res[idx][1], interval[1]);
            }
        }

        return Arrays.copyOf(res, idx+1);

    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] res = new int[intervals.length + 1][2];
        int idx = 0;
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            res[idx++] = intervals[i++];
        }

        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res[idx++] = newInterval;

        while (i < intervals.length && intervals[i][0] > newInterval[1]) {
            res[idx++] = intervals[i++];
        }

        return Arrays.copyOf(res, idx);

    }

    public static List<Integer> partitionLabels(String s) {
        char[] sArray = s.toCharArray();
        int[] endCharIndex = new int[26];
        for (int i = 0; i < sArray.length; i++) {
            endCharIndex[sArray[i] - 'a'] = i;
        }

        List<Integer> res = new ArrayList<>();
        int idx = 0;
        int last = -1;
        for (int i = 0; i < sArray.length; i++) {
            idx = Math.max(idx, endCharIndex[sArray[i] - 'a']);
            if (i == idx) {
                res.add(i - last);
                last = i;
            }

        }

        return res;

    }
}

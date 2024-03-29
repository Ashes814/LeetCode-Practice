package AlgVillage.Level12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author 欧欧
 * @version 1.0
 */
public class StringAlgorithm {
    public static void main(String[] args) {
        String testString = "abcd";
//        System.out.println(isAlp('a') && isAlp('c'));
//        System.out.println(myAtoi("       -123213"));
//        reverseString(testString);
//        System.out.println(reverseOnlyLetters("Test1ng-Leet=code-Q!"));
//        System.out.println(reverseWords("the sky is blue"));
//        System.out.println(reverseWords("  hello world  "));
//        System.out.println(reverseWords("a good   example"));
//        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        String[] testArray = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(testArray));
    }


    public static String toLowerCase(String s) {
        ArrayList<Character> res = new ArrayList<>();
        for (char c: s.toCharArray()) {
            if (c <= 90 && c >=65) {
                char newC = (char) (c + 32);
                res.add(newC);
            } else {
                res.add(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : res) {
            sb.append(c);
        }


        return sb.toString();
    }

    public static int myAtoi(String str) {
       int len = str.length();
       char[] charArray = str.toCharArray();

       int index = 0;
       while (index < len && charArray[index] == ' ') {
           index++;
       }
       if (index == len) {
           return 0;
       }

       int sign = 1;
       char firstChar = charArray[index];
       if (firstChar == '+') {
           index++;
       } else if (firstChar == '-') {
           index++;
           sign = -1;
       }

       int res = 0;
       while (index < len) {
           char currChar = charArray[index];
           if (currChar > '9' || currChar < '0') {
               break;
           }

           if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (currChar - '0') > Integer.MAX_VALUE % 10)) {
               return Integer.MAX_VALUE;
           }
           if (res < Integer.MIN_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (currChar - '0') > Integer.MAX_VALUE % 10)) {
               return Integer.MAX_VALUE;
           }

           res = res * 10 + sign * (currChar - '0');
           index++;
       }
       return res;
    }

    public static void reverseString(char[] s) {
        int head = 0;
        int tail = s.length - 1;
        char temp;
        while (tail > head) {
            temp = s[head];
            s[head] = s[tail];
            s[tail] = temp;
            tail--;
            head++;
        }
    }

    public static String reverseStr(String s, int k) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int n = s.length();
        char[] arr = s.toCharArray();
        for (int i = 0; i < n; i += 2*k) {
            reverse(arr, i, Math.min(i + k, n) - 1);
        }
        return new String(arr);
    }

    public static void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static boolean isAlp(char c) {
        if ((c <= 90 && c >= 65) || (c <= 122 && c >= 97)) {
            return true;
        } else {
            return false;
        }

    }

    public static String reverseOnlyLetters(String s) {
        char[] sArray = s.toCharArray();
        int head = 0;
        int tail = sArray.length - 1;
        char temp;
        while (tail > head) {
            if (isAlp(sArray[head]) && isAlp(sArray[tail])) {
                temp = sArray[head];
                sArray[head] = sArray[tail];
                sArray[tail] = temp;
            } else if (isAlp(sArray[head]) && !isAlp(sArray[tail])) {
                tail--;
                continue;
            } else if (!isAlp(sArray[head]) && isAlp(sArray[tail])) {
                head++;
                continue;
            }
            head++;
            tail--;

        }
        return new String(sArray);
    }

    public static String reverseWords(String s) {
        char[] sArrayTemp = s.toCharArray();
        int arrayStart = 0;
        int arrayEnd = sArrayTemp.length - 1;
        for (char c: sArrayTemp) {
            if (c == ' ') {
                arrayStart++;
            } else {
                break;
            }
        }
        for (int i = sArrayTemp.length - 1; i >= 0; i--){
            if (sArrayTemp[arrayEnd] == ' ') {
                arrayEnd--;
            } else {
                break;
            }
        }
        int length = arrayEnd - arrayStart + 1;
        char[] sArray = new char[length];
        System.arraycopy(sArrayTemp, arrayStart, sArray, 0, length);
        List<Character> newS = new ArrayList<Character>();
        for (int i = sArray.length - 1; i >= 0;) {
            int end = i;
            while (sArray[end] == ' ') {
                end--;
            }
            int start = end;
            while ((start > 0) && (sArray[start] != ' ') ) {
                start--;
            }
            if (start == 0) {
                start--;
            }


            for (int j = start + 1; j <= end; j++) {
                newS.add(sArray[j]);
            }
            if (start > 0) {
                newS.add(' ');
            }

            i = start - 1;

        }
        StringBuilder sb = new StringBuilder();
        for (Character ch: newS) {
            sb.append(ch);
        }

        return sb.toString();
    }

    public static boolean isPalindrome(String s) {
        // Leetcode 125 - double pointer
        char[] sArray = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;

        while (end >= start) {
            if (sArray[start] < 48 ||
                    (sArray[start] < 65 && sArray[start] > 57) ||
                     sArray[start] > 122 ||
                    (sArray[start] < 97 && sArray[start] > 90)) {
                start++;
                continue;
            }
            if (sArray[end] < 48 ||
                    (sArray[end] < 65 && sArray[end] > 57) ||
                    sArray[end] > 122 ||
                    (sArray[end] < 97 && sArray[end] > 90)) {
                end--;
                continue;
            }
            if (Character.toLowerCase(sArray[start]) != Character.toLowerCase(sArray[end])) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static int firstUniqChar(String s) {
        char[] sArray = s.toCharArray();
        HashMap<Character, Integer> charMap = new HashMap<>();
        for (char c: sArray) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (charMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;

    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> charMapS = new HashMap<>();
        HashMap<Character, Integer> charMapT = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            charMapS.put(s.charAt(i), charMapS.getOrDefault(s.charAt(i), 0) + 1);
            charMapT.put(t.charAt(i), charMapT.getOrDefault(t.charAt(i), 0) + 1);

        }
        for (int i = 0; i < s.length(); i++) {
            if (charMapS.get(s.charAt(i)).equals(charMapT.get(s.charAt(i)))) {
                continue;
            } else {
                return false;
            }
        }
        return true;

    }

    public static String longestCommonPrefix(String[] strs) {

       for (int j = 0; j < strs[0].length(); j++) {
           for (int i = 0; i < strs.length - 1; i++) {
               if (j >= strs[i + 1].length()) {
                   return strs[0].substring(0, j);
               }
               if (strs[i].charAt(j) == strs[i + 1].charAt(j)) {
                    continue;
               } else {
                   return strs[0].substring(0, j);
               }
           }
       }
       return strs[0];

    }

    public static int compress(char[] chars) {
        int n = chars.length;
        int write = 0, left = 0;
        for (int read = 0; read < n; read++) {
            if (read == n - 1 || chars[read] != chars[read + 1]) {
                chars[write++] = chars[read];
                int num = read - left + 1;
                if (num > 1) {
                    int anchor = write;
                    while (num > 0) {
                        chars[write++] = (char) (num % 10 + '0');
                        num /= 10;

                    }
//                    reverse2(chars, anchor, write - 1);
                }
                left = read + 1;
            }
        }
        return write;


    }

    public void reverse2(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}

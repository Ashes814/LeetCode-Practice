package DailyAlg;

import java.util.ArrayList;

public class Leetcode38 {
    public static void main(String[] args) {
        String r = countAndSay(4);
        System.out.println(r);
    }
    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        } else {
            return RLE(countAndSay(n - 1));
        }
    }

    public static String RLE(String string) {
        if (string == null || string.isEmpty()) {
            return "";
        }

        char[] chars = string.toCharArray();
        ArrayList<Character> res = new ArrayList<>();

        int counts = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i-1]) {
                counts++;
            } else {
                res.add((char) (counts + '0'));
                res.add(chars[i - 1]);

                counts = 1;
            }
        }

        res.add((char) (counts + '0'));
        res.add(chars[chars.length - 1]);

        StringBuilder sb = new StringBuilder();
        for (char c : res) {
            sb.append(c);
        }

        return sb.toString();


    }
}


//#include <iostream>
//#include <vector>
//#include <string>
//using namespace std;
//
//// 递归入口：外观数列
//        string countAndSay(int n) {
//        // 基线条件：n=1 直接返回 "1"
//        if (n == 1) {
//        return "1";
//        }
//        // 否则递归计算 n-1，然后进行 RLE 编码
//        else {
//        return RLE(countAndSay(n - 1));
//        }
//        }
//
//// RLE 压缩：统计连续字符 => 个数+字符
//        string RLE(string s) {
//        // 如果字符串为空，直接返回空
//        if (s.empty()) {
//        return "";
//        }
//
//        // 用来保存结果（相当于 Java 的 ArrayList<Character>）
//        vector<char> res;
//        // 连续字符计数，初始为 1
//        int count = 1;
//
//        // 从第 2 个字符开始遍历（i=1）
//        for (int i = 1; i < s.size(); i++) {
//        // 当前字符 == 上一个字符 → 计数+1
//        if (s[i] == s[i-1]) {
//        count++;
//        }
//        // 字符不同 → 把之前的 计数+字符 加入结果
//        else {
//        // 把数字 count 转成字符（如 3 → '3'）
//        res.push_back(count + '0');
//        // 加入上一个字符
//        res.push_back(s[i-1]);
//        // 重置计数为 1
//        count = 1;
//        }
//        }
//
//        // 最后一组字符一定要加入（循环里没处理最后一段）
//        res.push_back(count + '0');
//        res.push_back(s.back()); // 最后一个字符
//
//        // 把 vector 拼成字符串
//        string ans = "";
//        for (char c : res) {
//        ans += c;
//        }
//
//        return ans;
//        }
//
//// 测试主函数
//        int main() {
//        cout << countAndSay(4) << endl; // 输出 1211
//        return 0;
//        }

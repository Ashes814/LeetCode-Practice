#include <iostream>   // 输入输出头文件
#include <string>     // 字符串要用
#include <vector>     // 存数字和罗马对应关系
using namespace std;  // 让代码更简单，不用写 std::

// 函数：输入整数，返回罗马字符串
string intToRoman(int num) {
    // 1. 创建两个数组：数字 + 对应的罗马数字
    // 从大到小排！！！这是算法核心
    vector<int> values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    vector<string> symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    string res = "";  // 最终结果字符串

    // 2. 遍历所有数字，从大到小减
    for (int i = 0; i < values.size(); i++) {
        // 当 num 比当前数字大，就一直加符号、减数字
        while (num >= values[i]) {
            res += symbols[i];   // 把罗马符号加到结果里
            num -= values[i];    // 从数字里减去这个值
        }
    }

    return res;  // 返回最终罗马数字
}

// 主函数：程序入口
int main() {
    int num;
    cout << "请输入一个数字：";
    cin >> num;

    string result = intToRoman(num);
    cout << "罗马数字是：" << result << endl;

    return 0;
}
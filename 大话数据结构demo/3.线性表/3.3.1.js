"use strict";
// 将所有的在线性表listB中但不在listA中的数据元素插入到listA中
let listA = [1, 2, 3, 4, 5, 6];
let listB = [3, 4, 5, 6, 7, 8];
let element; // 声明listA与listB相同的数据元素e
let lengthA = listA.length; // 求线性表的长度
let lengthB = listB.length;
let insertIndex = lengthA;
for (let i = 0; i < lengthB; i++) {
    element = listB[i]; // 取listB中的第i个数据元素赋值给e
    if (!listA.includes(element)) {
        // listA中不存在和e相同的元素
        listA[insertIndex] = element; // 插入
        insertIndex++;
    }
}
console.log(listA);

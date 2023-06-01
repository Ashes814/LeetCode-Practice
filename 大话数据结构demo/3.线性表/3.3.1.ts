// 将所有的在线性表listB中但不在listA中的数据元素插入到listA中
let listA: number[] | string[] = [1, 2, 3, 4, 5, 6];
let listB: number[] | string[] = [3, 4, 5, 6, 7, 8];
let element: number; // 声明listA与listB相同的数据元素e
let lengthA: number = listA.length; // 求线性表的长度
let lengthB: number = listB.length;
let insertIndex: number = lengthA;
for (let i: number = 0; i < lengthB; i++) {
  element = listB[i]; // 取listB中的第i个数据元素赋值给e
  if (!listA.includes(element)) {
    // listA中不存在和e相同的元素
    listA[insertIndex] = element; // 插入
    insertIndex++;
  }
}

console.log(listA);

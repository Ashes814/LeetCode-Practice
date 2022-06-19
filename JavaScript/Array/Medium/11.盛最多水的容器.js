/**
 * @param {number[]} height
 * @return {number}
 */

/*
解题思路: 暴力算法
遍历每一个数字间的两两组合,计算最大的面积,时间复杂度为o(n^2), 空间复杂度o(1)

*/
let maxAreaNaive = function(height) {
    let maxA = 0;
    let currentArea = 0;
    for (let i = 0; i < height.length - 1; i++) {
        for (let j = i + 1; j < height.length; j++) {
            currentArea = (height[j] >= height[i]) ? (j - i) * height[i] : (j - i) * height[j];
            maxA = (currentArea >= maxA) ? currentArea : maxA;
        }
    }

    return maxA;
};


/*
解题思路: 双指针
从最左边和最右边两个数字开始,每次将数字小的那个向内部移动1,计算最大的面积,时间复杂度为o(n), 空间复杂度o(1)

*/

let maxArea = function(height) {
    let maxA = 0;
    let leftPointer = 0;
    let rightPointer = height.length - 1;
    let currentArea = 0;

    while (rightPointer > leftPointer) {


        currentArea = (rightPointer - leftPointer) * Math.min(height[leftPointer], height[rightPointer]);
        maxA = (currentArea >= maxA) ? currentArea : maxA;

        if (height[leftPointer] >= height[rightPointer]) {
            rightPointer -= 1;

        } else {
            leftPointer += 1;
        }

    }


    return maxA;
};
/*
时间复杂度:
    O(n)
基本思路: 
    对数组的每一个元素进行循环,获取当前数组元素位置的前n项和,
    计算当前是否为最低值,
    如果是则记录为minSum,
    如果不是则pass,
    计算maxSub, 即当前sum值与最小minsum值的差值,这个差值的最大值就是所求结果.
*/

function maxSubArray(nums) {
    let sum = 0;
    let minSum = 0;
    let maxSub = 0
    if (nums[0] >= 0) {
        maxSub = 0;
    } else {
        maxSub = nums[0];
    }
    for (let num of nums) {
        sum += num;

        if (maxSub <= sum - minSum) {
            maxSub = sum - minSum            
        }

        if (sum <= minSum) {
            minSum = sum;
        }
    }

    return maxSub;
}
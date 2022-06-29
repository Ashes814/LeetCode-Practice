/* 不考虑暴力破解, 考虑双指针
解题思路:双指针
先排序
固定第一个数字不变,双指针确定后面两个数字
计算三个数与目标值的差值绝对值,如果大于之前的最小值,则更新最小值,
在minSymbol中记录三数之和是大于target(1)还是小于target(-1)
若大于target,则将尾指针向前移动到更小的数,如果小于target,则将首指针移动到后面一个更大的数
最好返回差值绝对值*(1或-1) + target.

*/

function threeSumClosest(nums, target) {
    let minSymbol = 0
    nums.sort((a, b) => a - b);
    let minDiff = Math.abs(nums[0] + nums[1] + nums[2] - target);
    if ((nums[0] + nums[1] + nums[2] - target) >= 0) {
        minSymbol = 1;
    } else {
        minSymbol = -1;
    }
    let tempDiff = Math.abs(nums[0] + nums[1] + nums[2] - target);
    
    for (let i = 0; i < nums.length - 2; i++) {
        let k = nums.length - 1;
        if (nums[i] === nums[i - 1]) {
            continue;
        }
        for (let j = i + 1; j < k;) {
            x = nums[i];
            y = nums[j];
            z = nums[k];
            
            tempDiff = x + y + z - target;
            if (minDiff === 0) {
                return target;
            } else if (minDiff > Math.abs(tempDiff)) {
                minDiff = Math.abs(tempDiff);
                minSymbol = (tempDiff >= 0) ? 1 : -1
            // } else if (minDiff < Math.abs(tempDiff)) {
            //     pass
            }

            if (tempDiff > 0) {
                k--;
                while (nums[k + 1] === nums[k] && (k - 1) > j) {
                    k--;
                }
            } else if (tempDiff < 0) {
                j++;
                while (nums[j - 1] === nums[j] && (j + 1) < k) {
                    j++;
                }
            }
        }
    }
    return target + minDiff * minSymbol;
}
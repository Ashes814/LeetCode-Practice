/*
解题思路: 双指针
首先将数组从小到大排序;
然后固定第一个数字不变,首指针指向后一个数字,尾指针指向最后一个数字
三个数相加为0则加入答案,首指针移动到后一个与其不相等的数字,尾指针移动到前一个与其不相等的答案;
大于0则首指针移动到后一个与其不相等的数字;
小于0则尾指针移动到前一个与其不相等的数字;
尾指针大于首指针
将第一个数字移动到后一个与其不相等的数字,进行下一个循环
时间复杂度为o(n^2), 空间复杂度o(1)
 */
let threeSum = function (nums) {
    let result = []
    let x = 0;
    if (nums.length < 3) {
        return []
    }

    nums.sort((a, b) => a - b)

    for (let i = 0; i <= nums.length - 3; i++) {
        if (nums[i] === nums[i - 1]) {
            continue
        }
        let x = nums[i];

        let k = nums.length - 1;
        for (let j = i + 1; j < k;) {
            if ((nums[j] + nums[k]) === -x) {
                result.push([x, nums[j], nums[k]]);
                while (nums[j + 1] === nums[j]) {
                    j++;
                }
                while (nums[k - 1] === nums[k]) {
                    k--
                }

                j++;
                k--;
            } else if ((nums[j] + nums[k]) > -x) {
                while (nums[k - 1] === nums[k]) {
                    k--
                }
                k--;
            } else {
                while (nums[j + 1] === nums[j]) {
                    j++;
                }
                j++;
            }

        }
        
    }

    return result
}

// console.log(threeSum([-1,0,1,2,-1,-4,-2,-3,3,0,4]))
console.log(threeSum([-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6]))
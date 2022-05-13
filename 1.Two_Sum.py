class Solution:
    def twoSum(self, nums, target):# -> List[int]:

        for i in range(len(nums)):
            for j in range(i+1, len(nums)):
                if nums[i] + nums[j] == target:
                    return [i, j]
        pass 




input1 = [2, 7, 11, 15]
target1 = 9
test1 = Solution()
print(test1.twoSum(input1,target1))


input2 = [3,2,4]
target2 = 6
test2 = Solution()
print(test2.twoSum(input2,target2))

input3 = [3,3]
target3 = 6
test3 = Solution()
print(test3.twoSum(input3,target3))


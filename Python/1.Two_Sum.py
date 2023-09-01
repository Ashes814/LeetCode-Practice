class Solution:
    def twoSum(self, nums, target):# -> List[int]:

        for i in range(len(nums)):
            for j in range(i+1, len(nums)):
                if nums[i] + nums[j] == target:
                    return [i, j]
    
    def twoSum2(self, nums, target):

        hashtable = {}
        for i in range(len(nums)):
            hashtable[nums[i]] = i
        for i in range(len(nums)):
            complement = target - nums[i]
            if complement in hashtable and hashtable[complement] != i:

                return [i, hashtable[complement]]
            


        return 




input1 = [2, 7, 11, 15]
target1 = 9
test1 = Solution()
print(test1.twoSum(input1,target1))
print(test1.twoSum2(input1,target1))

input2 = [3,2,4]
target2 = 6
test2 = Solution()
print(test2.twoSum(input2,target2))
print(test2.twoSum2(input2,target2))
input3 = [3,3]
target3 = 6
test3 = Solution()
print(test3.twoSum(input3,target3))
print(test3.twoSum2(input3,target3))


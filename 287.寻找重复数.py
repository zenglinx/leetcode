#
# @lc app=leetcode.cn id=287 lang=python3
#
# [287] 寻找重复数
#

# @lc code=start
from typing import List


class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        for i in range(len(nums)):
            while nums[i] - 1 != i:
                if nums[i] == nums[nums[i] - 1]:
                    return nums[i]
                else:
                    temp = nums[i]
                    nums[i] = nums[nums[i] - 1]
                    nums[temp - 1] = temp
        return -1

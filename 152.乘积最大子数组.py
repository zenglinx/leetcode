#
# @lc app=leetcode.cn id=152 lang=python3
#
# [152] 乘积最大子数组
#

# @lc code=start


from typing import List


class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        if not nums:
            return 0

        if len(nums) == 1:
            return nums[0]

        max_prod = nums[0]
        min_prod = nums[0]
        ret = nums[0]

        for i in range(1, len(nums)):
            if nums[i] < 0:
                max_prod, min_prod = min_prod, max_prod

            max_prod = max(max_prod * nums[i], nums[i])
            min_prod = min(min_prod * nums[i], nums[i])
            ret = max(ret, max_prod)

        return ret


# @lc code=end

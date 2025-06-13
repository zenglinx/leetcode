#
# @lc app=leetcode.cn id=312 lang=python3
#
# [312] 戳气球
#

# @lc code=start
class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        n = len(nums)
        # 添加边界气球
        nums = [1] + nums + [1]
        dp = [[0] * (n + 2) for _ in range(n + 2)]

        # 枚举区间长度
        for length in range(1, n + 1):
            for left in range(1, n - length + 2):
                right = left + length - 1
                # 枚举最后戳破的气球
                for last in range(left, right + 1):
                    dp[left][right] = max(
                        dp[left][right],
                        dp[left][last - 1]
                        + dp[last + 1][right]
                        + nums[left - 1] * nums[last] * nums[right + 1],
                    )

        return dp[1][n]


# @lc code=end

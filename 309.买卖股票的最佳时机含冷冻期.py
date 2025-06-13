#
# @lc app=leetcode.cn id=309 lang=python3
#
# [309] 买卖股票的最佳时机含冷冻期
#

# @lc code=start
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if not prices:
            return 0

        n = len(prices)
        # dp[i][0]: 持有股票的最大收益
        # dp[i][1]: 不持有股票，处于冷冻期的最大收益
        # dp[i][2]: 不持有股票，不处于冷冻期的最大收益
        dp = [[0] * 3 for _ in range(n)]

        # 初始状态
        dp[0][0] = -prices[0]  # 第一天买入
        dp[0][1] = 0  # 第一天不可能处于冷冻期
        dp[0][2] = 0  # 第一天什么都不做

        for i in range(1, n):
            # 持有股票的状态：前一天持有股票，或者前一天不持有股票且不在冷冻期今天买入
            dp[i][0] = max(dp[i - 1][0], dp[i - 1][2] - prices[i])

            # 不持有股票且在冷冻期：前一天持有股票，今天卖出
            dp[i][1] = dp[i - 1][0] + prices[i]

            # 不持有股票且不在冷冻期：前一天不持有股票（可能在冷冻期，也可能不在）
            dp[i][2] = max(dp[i - 1][1], dp[i - 1][2])

        # 最后一天不持有股票的最大值（可能在冷冻期，也可能不在）
        return max(dp[n - 1][1], dp[n - 1][2])


# @lc code=end

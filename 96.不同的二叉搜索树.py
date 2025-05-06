#
# @lc app=leetcode.cn id=96 lang=python3
#
# [96] 不同的二叉搜索树
#


# @lc code=start
class Solution:
    def numTrees(self, n: int) -> int:
        """
        :type n: int
        :rtype: int
        """
        G = [0] * (n + 1)
        G[0] = 1
        G[1] = 1

        for i in range(2, n + 1):
            for j in range(1, i + 1):
                G[i] += G[j - 1] * G[i - j]

        return G[n]


# @lc code=end

#
# @lc app=leetcode.cn id=124 lang=python3
#
# [124] 二叉树中的最大路径和
#


# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from typing import Optional


class Solution:
    def __init__(self):
        self.maxSum = float("-inf")

    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        def maxGain(node):
            if not node:
                return 0

            leftGain = max(maxGain(node.left), 0)
            rightGain = max(maxGain(node.right), 0)

            priceNewPath = node.val + leftGain + rightGain

            self.maxSum = max(self.maxSum, priceNewPath)

            return node.val + max(leftGain, rightGain)

        maxGain(root)
        return self.maxSum


# @lc code=end

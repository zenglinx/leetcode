#
# @lc app=leetcode.cn id=337 lang=python3
#
# [337] 打家劫舍 III
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rob(self, root: Optional[TreeNode]) -> int:
        def dfs(node):
            if not node:
                return (0, 0)  # (rob, not_rob)

            left = dfs(node.left)
            right = dfs(node.right)

            # 偷当前节点：当前节点值 + 左右子树都不偷
            rob = node.val + left[1] + right[1]

            # 不偷当前节点：左右子树分别取最大值
            not_rob = max(left) + max(right)

            return (rob, not_rob)

        return max(dfs(root))


# @lc code=end

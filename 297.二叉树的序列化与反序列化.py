#
# @lc app=leetcode.cn id=297 lang=python3
#
# [297] 二叉树的序列化与反序列化
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Codec:
    def serialize(self, root):
        """Encodes a tree to a single string.

        :type root: TreeNode
        :rtype: str
        """

        def inner_serialize(node):
            if not node:
                return "None,"
            return (
                str(node.val)
                + ","
                + inner_serialize(node.left)
                + inner_serialize(node.right)
            )

        return inner_serialize(root)

    def deserialize(self, data):
        """Decodes your encoded data to tree.

        :type data: str
        :rtype: TreeNode
        """

        def inner_deserialize(data_list):
            if not data_list:
                return None
            val = data_list.pop(0)
            if val == "None":
                return None
            else:
                node = TreeNode(int(val))
                node.left = inner_deserialize(data_list)
                node.right = inner_deserialize(data_list)
                return node

        data_list = data.split(",")
        return inner_deserialize(data_list)


# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))
# @lc code=end

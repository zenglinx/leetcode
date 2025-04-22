/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        innerTraversal(root, ret);
        return ret;
    }

    private void innerTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        innerTraversal(root.left, list);
        list.add(root.val);
        innerTraversal(root.right, list);
    }
}
// @lc code=end

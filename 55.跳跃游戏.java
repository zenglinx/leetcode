/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 */

// @lc code=start
class Solution {
    private boolean[] visited;

    public boolean canJump(int[] nums) {
        if (nums == null) {
            return false;
        }

        this.visited = new boolean[nums.length];
        return jump(nums, 0);
    }

    private boolean jump(int[] nums, int idx) {
        if (idx == nums.length - 1) {
            return true;
        }

        if (idx >= nums.length || nums[idx] == 0) {
            return false;
        }

        for (int i = 1; i <= nums[idx]; i++) {
            if (visited[idx + i]) {
                continue;
            }

            if (jump(nums, idx + i)) {
                return true;
            } else {
                visited[idx + i] = true;
            }
        }

        visited[idx] = true;
        return false;
    }
}
// @lc code=end

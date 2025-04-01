/*
 * @lc app=leetcode.cn id=75 lang=java
 *
 * [75] 颜色分类
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        int[] colors = new int[3];
        for (int i = 0; i < nums.length; i++) {
            colors[nums[i]] += 1;
        }

        int idx = 0;
        for (int i = 0; i < colors.length; i++) {
            for (int j = 0; j < colors[i]; j++) {
                nums[idx] = i;
                idx++;
            }
        }
    }
}
// @lc code=end

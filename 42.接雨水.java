/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<Integer> points = new ArrayList<>();

    public int trap(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }

        int leftMax = 0, rightMax = 0;
        int left = 0, right = height.length - 1;

        int res = 0;
        while (left < right && right > 0) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (leftMax < rightMax) {
                res += leftMax - height[left];
                left++;
            } else {
                res += rightMax - height[right];
                right--;
            }
        }

        return res;
    }
}
// @lc code=end

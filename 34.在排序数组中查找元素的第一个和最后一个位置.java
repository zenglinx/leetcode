/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[] { -1, -1 };
        }

        int firstIdx = binarySearch(nums, 0, nums.length - 1, target);
        if (firstIdx == -1) {
            return new int[] { -1, -1 };
        }

        int left = firstIdx, right = firstIdx;
        while (left >= 0 && nums[left] == target) {
            left--;
        }
        while (right < nums.length && nums[right] == target) {
            right++;
        }

        left++;
        right--;
        return new int[] { left, right };
    }

    private int binarySearch(int[] nums, int left, int right, int target) {
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            return binarySearch(nums, left, mid - 1, target);
        } else {
            return binarySearch(nums, mid + 1, right, target);
        }
    }
}
// @lc code=end

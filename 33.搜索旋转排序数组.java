/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }

    private int search(int[] nums, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        if (left == right) {
            if (nums[left] == target) {
                return left;
            } else {
                return -1;
            }
        }

        if (nums[left] == target) {
            return left;
        }

        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            return mid;
        }

        if (nums[left] > target) {
            if (nums[left] <= nums[mid]) {
                return search(nums, mid + 1, right, target);
            } else {
                if (nums[mid] < target) {
                    return search(nums, mid + 1, right, target);
                } else {
                    return search(nums, left + 1, mid - 1, target);
                }
            }
        }

        if (nums[left] < target) {
            if (nums[mid] > target) {
                return search(nums, left + 1, mid - 1, target);
            } else {
                if (nums[left] <= nums[mid]) {
                    return search(nums, mid + 1, right, target);
                } else {
                    return search(nums, left + 1, mid - 1, target);
                }
            }
        }

        return -1;
    }
}
// @lc code=end

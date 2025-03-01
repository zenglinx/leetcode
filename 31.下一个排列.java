/*
 * @lc app=leetcode.cn id=31 lang=java
 *
 * [31] 下一个排列
 */

// @lc code=start
class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length == 1) {
            return;
        }

        // find the last element less than this next element
        int lastLessIdx = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                lastLessIdx = i;
                break;
            }
        }

        if (lastLessIdx == -1) {
            Arrays.sort(nums);
            return;
        }

        // find the smalleast number that greater than the lastLessIdx number at the
        // number's right side
        int minIdx = lastLessIdx + 1;
        for (int i = minIdx; i < nums.length; i++) {
            if (nums[i] > nums[lastLessIdx] && nums[i] < nums[minIdx]) {
                minIdx = i;
            }
        }

        // swap lastLessIdx and minIdx number
        swap(nums, lastLessIdx, minIdx);

        // resort the remain numbers of the right side of lastLessIdx number
        Arrays.sort(nums, lastLessIdx + 1, nums.length);
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
// @lc code=end

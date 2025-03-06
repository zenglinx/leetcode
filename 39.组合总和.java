/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> ret = new ArrayList<>();
    int[] nums = null;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.nums = candidates;
        this.ret = new ArrayList<>();

        backtrack(0, new ArrayList<>(), target);
        return ret;
    }

    private void backtrack(int idx, List<Integer> counts, int target) {
        if (target == 0) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < counts.size(); i++) {
                int count = counts.get(i);
                while (count > 0) {
                    list.add(nums[i]);
                    count--;
                }
            }

            ret.add(list);
            return;
        }

        if (idx >= nums.length) {
            return;
        }

        int num = nums[idx];
        int maxCount = target / num;
        for (int i = 0; i <= maxCount; i++) {
            int newTarget = target - num * i;
            counts.add(i);
            backtrack(idx + 1, counts, newTarget);
            counts.remove(counts.size() - 1);
        }
    }
}
// @lc code=end

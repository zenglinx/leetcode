/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> ret = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        ret.add(new ArrayList<>());
        backtrack(0, nums, new ArrayList<>());
        return ret;
    }

    private void backtrack(int idx, int[] nums, List<Integer> list) {
        if (idx == nums.length) {
            return;
        }

        backtrack(idx + 1, nums, list);

        list.add(nums[idx]);
        List<Integer> l = new ArrayList<>(list);
        ret.add(l);
        backtrack(idx + 1, nums, list);
        list.remove(list.size() - 1);
    }
}
// @lc code=end

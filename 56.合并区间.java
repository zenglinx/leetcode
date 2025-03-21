/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> ret = new ArrayList<>();
        int curr = 0;
        int[] currArr = intervals[0];
        while (curr < intervals.length - 1) {
            int next = curr + 1;
            if (currArr[1] >= intervals[next][0]) {
                currArr[0] = currArr[0];
                currArr[1] = Math.max(intervals[next][1], currArr[1]);
                curr = next;
            } else {
                ret.add(currArr);
                curr = next;
                currArr = intervals[next];
            }
        }

        ret.add(currArr);

        return ret.toArray(new int[ret.size()][]);
    }
}
// @lc code=end

/*
 * @lc app=leetcode.cn id=32 lang=java
 *
 * [32] 最长有效括号
 */

// @lc code=start
class Solution {
    public int longestValidParentheses(String s) {
        char left = '(';
        char right = ')';
        boolean[] isValidParenthes = new boolean[s.length()];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == left) {
                stack.push(i);
            } else {
                if (!stack.isEmpty()) {
                    isValidParenthes[i] = true;
                    isValidParenthes[stack.pop()] = true;
                }
            }
        }

        // calculate the biggest continuous true length
        int longestLen = 0;
        int i = 0;
        while (i < isValidParenthes.length) {
            if (!isValidParenthes[i]) {
                i++;
                continue;
            }

            int len = 0;
            while (i < isValidParenthes.length && isValidParenthes[i]) {
                len++;
                i++;
            }
            longestLen = Math.max(longestLen, len);
        }

        return longestLen;
    }
}
// @lc code=end

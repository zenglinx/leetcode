/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] 最小覆盖子串
 */
// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int match = 0;
        int start = 0;
        int minLen = Integer.MAX_VALUE;

        while (right < s.length()) {
            char charRight = s.charAt(right);
            right++;

            if (need.containsKey(charRight)) {
                window.put(charRight, window.getOrDefault(charRight, 0) + 1);
                if (window.get(charRight).equals(need.get(charRight))) {
                    match++;
                }
            }

            while (match == need.size()) {
                if (right - left < minLen) {
                    start = left;
                    minLen = right - left;
                }

                char charLeft = s.charAt(left);
                left++;

                if (need.containsKey(charLeft)) {
                    if (window.get(charLeft).equals(need.get(charLeft))) {
                        match--;
                    }
                    window.put(charLeft, window.get(charLeft) - 1);
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
// @lc code=end
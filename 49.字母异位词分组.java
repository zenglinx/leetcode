/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    private Map<String, List<String>> map = new HashMap<>();

    public List<List<String>> groupAnagrams(String[] strs) {
        for (String str : strs) {
            char[] chars = new char[26];
            for (int i = 0; i < str.length(); i++) {
                chars[str.charAt(i) - 'a']++;
            }

            List<String> l = map.getOrDefault(String.valueOf(chars), new ArrayList<>());
            l.add(str);
            map.put(String.valueOf(chars), l);
        }

        return new ArrayList<List<String>>(map.values());
    }
}
// @lc code=end

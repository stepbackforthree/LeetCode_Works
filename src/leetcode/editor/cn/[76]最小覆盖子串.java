//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 
//
// 注意： 
//
// 
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 字符串 滑动窗口 👍 1336 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        } else {
            Map<Character, Integer> tMap = new HashMap<>();
            Map<Character, Integer> sMap = new HashMap<>();

            for (int i = 0; i < t.length(); ++i) {
                if (tMap.containsKey(t.charAt(i))) {
                    tMap.put(t.charAt(i), tMap.get(t.charAt(i)) + 1);
                } else {
                    tMap.put(t.charAt(i), 1);
                }
            }

            int start = 0, end = -1, startIdx = -1, endIdx = -1, length = Integer.MAX_VALUE;

            while (end < s.length()) {
                ++end;
                if (end < s.length() && tMap.containsKey(s.charAt(end))) {
                    sMap.put(s.charAt(end), sMap.getOrDefault(s.charAt(end), 0) + 1);
                }

                if (end < s.length() && check(tMap, sMap)) {
                    while (true) {
                        if (tMap.containsKey(s.charAt(start))) {
                            sMap.put(s.charAt(start), sMap.get(s.charAt(start)) - 1);
                            if (check(tMap, sMap)) {
                                start++;
                            } else {
                                sMap.put(s.charAt(start), sMap.get(s.charAt(start)) + 1);
                                break;
                            }
                        } else {
                            start++;
                        }
                    }
                    if (end - start + 1 < length) {
                        length = end - start + 1;
                        startIdx = start;
                        endIdx = end;
                    }
                }
            }

            return startIdx == -1 ? "" : s.substring(startIdx, endIdx + 1);
        }
    }

    boolean check(Map<Character, Integer> tMap, Map<Character, Integer> sMap) {
        for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {
            if (tMap.get(entry.getKey()) > sMap.getOrDefault(entry.getKey(), 0)) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

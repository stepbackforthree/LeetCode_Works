//给你一个字符串 s ，考虑其所有 重复子串 ：即，s 的连续子串，在 s 中出现 2 次或更多次。这些出现之间可能存在重叠。 
//
// 返回 任意一个 可能具有最长长度的重复子串。如果 s 不含重复子串，那么答案为 "" 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "banana"
//输出："ana"
// 
//
// 示例 2： 
//
// 
//输入：s = "abcd"
//输出：""
// 
//
// 
//
// 提示： 
//
// 
// 2 <= s.length <= 3 * 10⁴ 
// s 由小写英文字母组成 
// 
// Related Topics 字符串 二分查找 后缀数组 滑动窗口 哈希函数 滚动哈希 👍 213 👎 0


import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    long[] h, p;
    public String longestDupSubstring(String s) {
        int P = 1313131, n = s.length();
        long[] h = new long[n+10], p = new long[n+10];
        p[0] = 1;

        for (int i = 0; i < n; ++i) {
            p[i+1] = p[i] * P;
            h[i+1] = h[i] * P + s.charAt(i);
        }

        String result = "";
        int l = 0, r = n;
        while (l < r) {
            int mid = (l + r + 1) / 2;
            String t = checkSubString(s, mid);
            if (t.length() != 0) {
                l = mid;
            } else {
                r = mid - 1;
            }
            result = t.length() > result.length() ? t : result;
        }

        return result;
    }

    String checkSubString(String s, int mid) {
        int n = s.length();
        Set<Long> set = new HashSet<>();
        for (int i = 1; i + mid - 1 <= n; ++i) {
            int j = i + mid - 1;
            long curr = h[j] - h[i-1] * p[j-i+1];
            if (set.contains(curr)) {
                return s.substring(i-1, j);
            }
            set.add(curr);
        }
        return "";
    }
}
//leetcode submit region end(Prohibit modification and deletion)

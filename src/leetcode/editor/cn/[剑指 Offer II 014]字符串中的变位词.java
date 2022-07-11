//给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的某个变位词。 
//
// 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。 
//
// 
//
// 示例 1： 
//
// 
//输入: s1 = "ab" s2 = "eidbaooo"
//输出: True
//解释: s2 包含 s1 的排列之一 ("ba").
// 
//
// 示例 2： 
//
// 
//输入: s1= "ab" s2 = "eidboaoo"
//输出: False
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length <= 10⁴ 
// s1 和 s2 仅包含小写字母 
// 
//
// 
//
// 注意：本题与主站 567 题相同： https://leetcode-cn.com/problems/permutation-in-string/ 
// Related Topics 哈希表 双指针 字符串 滑动窗口 👍 52 👎 0


import java.util.*;
import java.util.stream.Collectors;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int n = s1.length(), m = s2.length();

        int[] array1 = new int[26], array2 = new int[26];

        for (int i = 0; i < n; ++i) {
            array1[s1.charAt(i) - 'a']++;
            array2[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(array1, array2)) {
            return true;
        }

        for (int i = n; i < m; ++i) {
            array2[s2.charAt(i) - 'a']++;
            array2[s2.charAt(i-n) - 'a']--;

            if (Arrays.equals(array1, array2)) {
                return true;
            }
        }

        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

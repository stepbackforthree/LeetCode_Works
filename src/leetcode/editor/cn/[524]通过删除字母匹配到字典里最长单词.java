//给你一个字符串 s 和一个字符串数组 dictionary 作为字典，找出并返回字典中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。 
//
// 如果答案不止一个，返回长度最长且字典序最小的字符串。如果答案不存在，则返回空字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
//输出："apple"
// 
//
// 示例 2： 
//
// 
//输入：s = "abpcplea", dictionary = ["a","b","c"]
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// 1 <= dictionary.length <= 1000 
// 1 <= dictionary[i].length <= 1000 
// s 和 dictionary[i] 仅由小写英文字母组成 
// 
// Related Topics 数组 双指针 字符串 排序 👍 209 👎 0


import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        int length = Integer.MIN_VALUE;
        String result = "";

        for (int i = 0; i < dictionary.size(); ++i) {
            if (length <= dictionary.get(i).length() && dictionary.get(i).length() <= s.length()) {
                if (check(s, dictionary.get(i))) {
                    if (length == dictionary.get(i).length()) {
                        String[] compare = {result, dictionary.get(i)};
                        Arrays.sort(compare);
                        result = compare[0];
                    } else {
                        result = dictionary.get(i);
                        length = result.length();
                    }
                }
            }
        }
        return result;
    }

    boolean check(String s, String currS) {
        int p1 = 0, p2 = 0;

        while (p2 < currS.length() && p1 < s.length()) {
            if (s.charAt(p1) == currS.charAt(p2)) {
                ++p1;
                ++p2;
            } else {
                ++p1;
            }
        }
        return p2 == currS.length();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

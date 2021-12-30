//给定两个字符串 a 和 b，寻找重复叠加字符串 a 的最小次数，使得字符串 b 成为叠加后的字符串 a 的子串，如果不存在则返回 -1。 
//
// 注意：字符串 "abc" 重复叠加 0 次是 ""，重复叠加 1 次是 "abc"，重复叠加 2 次是 "abcabc"。 
//
// 
//
// 示例 1： 
//
// 输入：a = "abcd", b = "cdabcdab"
//输出：3
//解释：a 重复叠加三遍后为 "abcdabcdabcd", 此时 b 是其子串。
// 
//
// 示例 2： 
//
// 输入：a = "a", b = "aa"
//输出：2
// 
//
// 示例 3： 
//
// 输入：a = "a", b = "a"
//输出：1
// 
//
// 示例 4： 
//
// 输入：a = "abc", b = "wxyz"
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= a.length <= 10⁴ 
// 1 <= b.length <= 10⁴ 
// a 和 b 由小写英文字母组成 
// 
// Related Topics 字符串 字符串匹配 👍 196 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int repeatedStringMatch(String a, String b) {
        if (b.equals("")) {
            return 0;
        }

        for (Character character : b.toCharArray()) {
            if (!a.contains(character.toString())) {
                return -1;
            }
        }

        int result = Integer.MAX_VALUE;

        for (int aIndex = 0; aIndex < a.length(); ++aIndex) {
            if (a.charAt(aIndex) == b.charAt(0)) {
                int probResult = findNext(aIndex, 0, a, b, 1);

                result = Math.min(result, probResult > 0 ? probResult : Integer.MAX_VALUE);
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    int findNext(int currAIndex, int currBIndex, String a, String b, int currCount) {
        if (currBIndex == b.length()) {
            return currCount;
        }
        if (a.charAt(currAIndex) == b.charAt(currBIndex)) {
            if (currAIndex + 1 == a.length() && currBIndex + 1 != b.length()) {
                currAIndex = -1;
                currCount++;
            }
            return findNext(currAIndex+1, currBIndex+1, a, b, currCount);
        } else {
            return -1;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

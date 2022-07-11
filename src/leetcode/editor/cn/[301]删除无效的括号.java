//给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。 
//
// 返回所有可能的结果。答案可以按 任意顺序 返回。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()())()"
//输出：["(())()","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：s = "(a)())()"
//输出：["(a())()","(a)()()"]
// 
//
// 示例 3： 
//
// 
//输入：s = ")("
//输出：[""]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 25 
// s 由小写英文字母以及括号 '(' 和 ')' 组成 
// s 中至多含 20 个括号 
// 
// Related Topics 广度优先搜索 字符串 回溯 👍 680 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> result = new ArrayList<>();

    public List<String> removeInvalidParentheses(String s) {
        int leftBracket = 0, rightBracket = 0;

        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                leftBracket++;
            } else if (s.charAt(i) == ')') {
                if (leftBracket == 0) {
                    rightBracket++;
                } else {
                    leftBracket--;
                }
            }
        }

        findNext(s, 0, leftBracket, rightBracket);

        return result;
    }

    void findNext(String str, int start, int leftBracket, int rightBracket) {
        if (leftBracket == 0 && rightBracket == 0) {
            if (isValid(str)) {
                result.add(str);
            }
        }

        for (int i = start; i < str.length(); ++i) {
            if (i > 0 && str.charAt(i - 1) == str.charAt(i)) {
                continue;
            }

            if (leftBracket + rightBracket > str.length() - i) {
                return;
            }

            if (leftBracket > 0 && str.charAt(i) == '(') {
                findNext(str.substring(0, i) + str.substring(i+1), i, leftBracket - 1, rightBracket);
            } else if (rightBracket > 0 && str.charAt(i) == ')') {
                findNext(str.substring(0, i) + str.substring(i+1), i, leftBracket, rightBracket - 1);
            }
        }
    }

    boolean isValid(String str) {
        int leftBracket = 0;

        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) == '(') {
                leftBracket++;
            } else if (str.charAt(i) == ')') {
                leftBracket--;
            }

            if (leftBracket < 0) {
                return false;
            }
        }

        return leftBracket == 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

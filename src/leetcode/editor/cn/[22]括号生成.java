//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 有效括号组合需满足：左括号必须以正确的顺序闭合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 动态规划 回溯 👍 1996 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        char[] condition = new char[n * 2];
        // since the first bracket and the last bracket must be ( and ) respectively, then preset
        condition[0] = '(';
        condition[condition.length - 1] = ')';
        // recursively assign ( to specific positions
        findNext(condition, 1, 0, 0, n, result);
        return result;
    }

    // count: how many ( has been specified
    // remain: how many positions(i.e. empty positions) can ) to fit between current waiting ( and the first (
    // preIndex: index of last (
    // n: input n
    private void findNext(char[] condition, int count, int remain, int preIndex, int n, List<String> result) {
        if (count == n) {
            // fill empty positions with )
            for (int i = 0; i < n * 2; i++) {
                if (condition[i] != '(') {
                    condition[i] = ')';
                }
            }
            result.add(new String(condition));
            return;
        }
        // the choice of current waiting ( must be in a range that
        // the empty positions between current waiting ( and the first ( cannot be larger than
        // the number of previous ('s, or more ) would be produced and violate the rule of valid brackets.
        for (int i = preIndex + 1; i < preIndex + 1 + count - remain + 1; i++) {
            char[] temp = new String(condition).toCharArray();
            temp[i] = '(';
            findNext(temp, count+1, i-count, i, n, result);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

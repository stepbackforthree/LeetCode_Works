//给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则： 
//
// 
// 任何左括号 ( 必须有相应的右括号 )。 
// 任何右括号 ) 必须有相应的左括号 ( 。 
// 左括号 ( 必须在对应的右括号之前 )。 
// * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。 
// 一个空字符串也被视为有效字符串。 
// 
//
// 示例 1: 
//
// 
//输入: "()"
//输出: True
// 
//
// 示例 2: 
//
// 
//输入: "(*)"
//输出: True
// 
//
// 示例 3: 
//
// 
//输入: "(*))"
//输出: True
// 
//
// 注意: 
//
// 
// 字符串大小将在 [1，100] 范围内。 
// 
// Related Topics 栈 贪心 字符串 动态规划 👍 332 👎 0


import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkValidString(String s) {
        Deque<Integer> leftStack = new LinkedList<>();
        Deque<Integer> starStack = new LinkedList<>();

        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                leftStack.push(i);
            } else if (s.charAt(i) == ')') {
                if (!leftStack.isEmpty()) {
                    leftStack.pop();
                } else if (!starStack.isEmpty()) {
                    starStack.pop();
                } else {
                    return false;
                }
            } else {
                starStack.push(i);
            }
        }

        while (!leftStack.isEmpty() && !starStack.isEmpty()) {
            if (leftStack.peek() < starStack.peek()) {
                leftStack.pop();
                starStack.pop();
            } else {
                return false;
            }
        }
        return leftStack.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

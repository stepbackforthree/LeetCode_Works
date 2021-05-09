//给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。 
//
// 
// '.' 匹配任意单个字符 
// '*' 匹配零个或多个前面的那一个元素 
// 
//
// 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。 
// 
//
// 示例 1： 
//
// 
//输入：s = "aa" p = "a"
//输出：false
//解释："a" 无法匹配 "aa" 整个字符串。
// 
//
// 示例 2: 
//
// 
//输入：s = "aa" p = "a*"
//输出：true
//解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
// 
//
// 示例 3： 
//
// 
//输入：s = "ab" p = ".*"
//输出：true
//解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
// 
//
// 示例 4： 
//
// 
//输入：s = "aab" p = "c*a*b"
//输出：true
//解释：因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
// 
//
// 示例 5： 
//
// 
//输入：s = "mississippi" p = "mis*is*p*."
//输出：false 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 20 
// 0 <= p.length <= 30 
// s 可能为空，且只包含从 a-z 的小写字母。 
// p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。 
// 保证每次出现字符 * 时，前面都匹配到有效的字符 
// 
// Related Topics 字符串 动态规划 回溯算法 
// 👍 2086 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 解决方法：动态规划，此处状态取决于上一处状态并以此类推，使用二维布尔数组存放各处状态
    public boolean isMatch(String s, String p) {
        int is = s.length();
        int ip = p.length();
        boolean[][] matrix = new boolean[is + 1][ip + 1];
        matrix[0][0] = true; // 冬天规划矩阵初始值
        // 动态规划矩阵横向存放string字符，竖向存放pattern字符，都从1位开始，0位都为空

        // 为matrix的第0行和第0列赋值
        // 此时pattern为空，因此string任意字符都不能成功匹配，matrix值为false
        for (int i = 1; i <= is; i++) {
            matrix[i][0] = false;
        }

        // 此时string为空，pattern字符为*时，可认为其不发挥作用，此时匹配情况取决于除字符+*外pattern最后一个字符是否匹配
        // 即如果p[1] = 字符，p[2] = *，因为p[0] = 空，且matrix[0][0] = true, 则此处matrix[0][2] = true, 上一处matrix[0][1] = false
        for (int j = 1; j <= ip; j++) {
            if (p.charAt(j - 1) == '*') {
                matrix[0][j] = matrix[0][j - 2];
            } else {
                matrix[0][j] = false;
            }
        }

        for (int i = 1; i <= is; i++) {
            for (int j = 1; j <= ip; j++) {
                if (p.charAt(j - 1) == '*') {
                    // 此处pattern字符为*，进行特殊匹配
                    // 特殊匹配分为两种情况：
                    // 1. 字母+*（比如a*）不发挥作用，即匹配0个字母，因此此处是否匹配取决于此处是否与除a*以外的最后一位pattern字符匹配
                    // 2. a*发挥作用，可能匹配1-n个字母，但对于此处来说，a*与此处尝试匹配：
                    // 2.1. 若匹配成功（即string此处为a，pattern此处为*，上一位为a），整体是否匹配取决于string上一位是否匹配
                    // 2.2. 若匹配不成功（即string此处不为a，pattern此处为*，上一位为a），视为第一种情况，即a*不发挥作用。
                    matrix[i][j] = matrix[i][j - 2]; // 情况1
                    if (match(s, p, i - 1, j - 2)) { // 情况2
                        matrix[i][j] = matrix[i][j] || matrix[i - 1][j]; // 情况2下匹配成功(即2.1)
                    }
                } else { // 此处pattern字符非*，正常匹配string，pattern即可
                    if (match(s, p, i - 1, j - 1)) { // 如果此处匹配
                        matrix[i][j] = matrix[i - 1][j - 1]; // 到目前为止，整体是否匹配取决于上一处是否匹配
                    }                                        // 上一处是否匹配，取决于上上一处是否匹配...以此类推
                }
            }
        }
        return matrix[is][ip]; // string最后一位字符匹配结束，返回布尔值即最后结果
    }

    // 例子
    // s = "abbc", p = "ab*c"

    //      空   a   b   b   c
    // 空   T    F   F   F   F
    // a    F   T   F   F   F
    // b    F   F   T   T   F
    // *    F   T   T   T   T
    // c    F   F   F   F   T (result)

    public boolean match(String s, String p, int is, int ip) { // 普通匹配函数
        if (p.charAt(ip) == '.') {
            return true;
        }
        return s.charAt(is) == p.charAt(ip);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

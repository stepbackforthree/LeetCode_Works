//给定一个正整数 n，找出小于或等于 n 的非负整数中，其二进制表示不包含 连续的1 的个数。 
//
// 示例 1: 
//
// 输入: 5
//输出: 5
//解释: 
//下面是带有相应二进制表示的非负整数<= 5：
//0 : 0
//1 : 1
//2 : 10
//3 : 11
//4 : 100
//5 : 101
//其中，只有整数3违反规则（有两个连续的1），其他5个满足规则。 
//
// 说明: 1 <= n <= 10⁹ 
// Related Topics 动态规划 👍 145 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int result = 1;
    int n;
    public int findIntegers(int n) {
        this.n = n;
        dfs(1);
        return result;
    }

    void dfs(int currN) {
        if (currN > n) {
            return;
        }
        result++;
        if ((currN & 1) == 1) {
            dfs(currN << 1);
        } else {
            dfs(currN << 1);
            dfs((currN << 1) + 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

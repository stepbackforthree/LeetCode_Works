//给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m - 1]
// 。请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘
//积是18。 
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。 
//
// 
//
// 示例 1： 
//
// 输入: 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1 
//
// 示例 2: 
//
// 输入: 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36 
//
// 
//
// 提示： 
//
// 
// 2 <= n <= 1000 
// 
//
// 注意：本题与主站 343 题相同：https://leetcode-cn.com/problems/integer-break/ 
// Related Topics 数学 动态规划 👍 164 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }

        // 3可证为保证得到最大乘积时应尽量取到的长度
        int times = n / 3;
        int remainder = n % 3;

        long tempResult = 1;

        for (int i = 1; i < times; ++i) {
            // 大数乘积避免越界，循环取余
            tempResult = tempResult * 3 % 1000000007;
        }

        // 考虑最后一段
        switch (remainder) {
            // 没有余数
            case 0: return (int) (tempResult * 3 % 1000000007);
            // 余数为1， 最后两段3+1比2+2乘积小，应该换成2+2
            case 1: return (int) (tempResult * 4 % 1000000007);
            // 余数为2， 最后两段3+2
            case 2: return (int) (tempResult * 6 % 1000000007);
            default: return 0;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

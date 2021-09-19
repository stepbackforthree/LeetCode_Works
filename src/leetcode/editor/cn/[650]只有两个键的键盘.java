//最初记事本上只有一个字符 'A' 。你每次可以对这个记事本进行两种操作： 
//
// 
// Copy All（复制全部）：复制这个记事本中的所有字符（不允许仅复制部分字符）。 
// Paste（粘贴）：粘贴 上一次 复制的字符。 
// 
//
// 给你一个数字 n ，你需要使用最少的操作次数，在记事本上输出 恰好 n 个 'A' 。返回能够打印出 n 个 'A' 的最少操作次数。 
//
// 
//
// 示例 1： 
//
// 
//输入：3
//输出：3
//解释：
//最初, 只有一个字符 'A'。
//第 1 步, 使用 Copy All 操作。
//第 2 步, 使用 Paste 操作来获得 'AA'。
//第 3 步, 使用 Paste 操作来获得 'AAA'。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 1000 
// 
// Related Topics 数学 动态规划 👍 357 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[] dp;
    public int minSteps(int n) {
        dp = new int[n + 1];
        dp[1] = 0;
        if (n < 2) {
            return 0;
        }
        return findNext(n);
    }

    int findNext(int n) {
        int factor = 1;

        // find the minimum factor
        for (int i = 2; i <= Math.sqrt(n); ++i) {
            if (n % i == 0) {
                factor = i;
                break;
            }
        }

        // n is a prime number
        if (factor == 1) {
            dp[n] = n;
            return dp[n];
        }
        dp[n] = factor + findNext(n / factor);
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

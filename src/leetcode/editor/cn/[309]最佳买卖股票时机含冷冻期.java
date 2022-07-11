//给定一个整数数组 prices，其中第 prices[i] 表示第 i 天的股票价格 。 
//
// 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）: 
//
// 
// 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。 
// 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1: 
//
// 
//输入: prices = [1,2,3,0,2]
//输出: 3 
//解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出] 
//
// 示例 2: 
//
// 
//输入: prices = [1]
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 5000 
// 0 <= prices[i] <= 1000 
// 
// Related Topics 数组 动态规划 👍 1118 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        // 当前持有股票时最大累计收益
        int profit1;
        // 当前不持有股票且处于冷却期时最大累计收益
        int profit2;
        // 当前不持有股票且不处于冷却期时最大累计收益
        int profit3;

        profit1 = -prices[0];
        profit2 = 0;
        profit3 = 0;

        for (int i = 1; i < prices.length; ++i) {
            int temp1 = profit1;
            int temp2 = profit2;
            int temp3 = profit3;

            // 前一天也持有该股票，当天无变动；前一天不持有股票且不处于冷却期，当天新买入股票
            profit1 = Math.max(temp1, temp3 - prices[i]);

            // 前一天卖出股票，当天进入冷却期
            profit2 = temp1 + prices[i];

            // 前一天不持有股票且处于冷却期，当天不处于冷却期且不买入股票；前一天不持有股票且不处于冷却期，当天无变动
            profit3 = Math.max(temp2, temp3);
        }

        return Math.max(profit1, Math.max(profit2, profit3));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

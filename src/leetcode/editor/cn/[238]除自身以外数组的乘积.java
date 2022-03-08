//给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之
//外其余各元素的乘积。 
//
// 
//
// 示例: 
//
// 输入: [1,2,3,4]
//输出: [24,12,8,6] 
//
// 
//
// 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。 
//
// 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。 
//
// 进阶： 
//你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。） 
// Related Topics 数组 前缀和 👍 1031 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefixes = new int[n+1], suffixes = new int[n+1];
        int prefixSum = 1, suffixSum = 1;
        prefixes[0] = prefixSum;
        suffixes[n] = suffixSum;
        suffixes[n-1] = suffixSum;

        for (int i = 0; i < n; ++i) {
            prefixes[i+1] = prefixSum * nums[i];
            prefixSum = prefixes[i+1];
        }

        for (int i = n - 2; i >= 0; --i) {
            suffixes[i] = nums[i+1] * suffixes[i+1];
        }

        int[] result = new int[n];

        for (int i = 0; i < n; ++i) {
            result[i] = prefixes[i] * suffixes[i];
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

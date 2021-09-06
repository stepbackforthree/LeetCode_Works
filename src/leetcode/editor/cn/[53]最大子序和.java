//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：nums = [-1]
//输出：-1
// 
//
// 示例 5： 
//
// 
//输入：nums = [-100000]
//输出：-100000
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// 
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。 
// Related Topics 数组 分治 动态规划 👍 3656 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length < 2) {
            return nums[0];
        }

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int subMax = Integer.MIN_VALUE;
            int subSum = 0;

            for (int j = i; j < nums.length; j++) {
                if (subMax == Integer.MIN_VALUE) {
                    subMax = nums[i];
                    subSum = nums[i];
                } else {
                    subSum += nums[j];
                    if (subSum > subMax) {
                        subMax = subSum;
                    }
                }
            }

            if (subMax > result) {
                result = subMax;
            }
        }
        return result;

//        int pre = 0, maxSum = nums[0];
//        for (int x : nums) {
//            pre = Math.max(pre + x, x);
//            maxSum = Math.max(maxSum, pre);
//        }
//        return maxSum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

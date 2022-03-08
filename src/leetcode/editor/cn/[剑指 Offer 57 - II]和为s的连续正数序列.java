//输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。 
//
// 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。 
//
// 
//
// 示例 1： 
//
// 输入：target = 9
//输出：[[2,3,4],[4,5]]
// 
//
// 示例 2： 
//
// 输入：target = 15
//输出：[[1,2,3,4,5],[4,5,6],[7,8]]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= target <= 10^5 
// 
//
// 
// Related Topics 数学 双指针 枚举 👍 385 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] findContinuousSequence(int target) {
        List<int[]> result = new ArrayList<>();

        int left = 1, right = 2;

        while (left < right) {
            int sum = (left + right) * (right - left + 1) / 2;

            if (sum == target) {
                int[] subResult = new int[right - left + 1];

                for (int i = left; i <= right; ++i) {
                    subResult[i-left] = i;
                }

                left++;

                result.add(subResult);
            } else if (sum < target) {
                right++;
            } else if (sum > target) {
                left++;
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

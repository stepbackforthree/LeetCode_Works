//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。 
//
// 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 
//
// 示例 2： 
//
// 
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
// Related Topics 并查集 数组 哈希表 👍 914 👎 0


import java.util.hashSet;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        int result = 0;
        int subSum = 0;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            if (min > num) {
                min = num;
            }

            if (max < num) {
                max = num;
            }

            hashSet.add(num);
        }

        for (int i = min; i <= max + 1; ++i) {
            if (hashSet.contains(i)) {
                subSum++;

            } else {
                result = Math.max(subSum, result);
                subSum = 0;

                if (result > hashSet.size() / 2) {
                    break;
                }
            }
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

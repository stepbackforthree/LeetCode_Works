//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
// Related Topics 数组 二分查找 👍 1184 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        int start = 0;
        int end = nums.length - 1;
        int mid = (start + end) / 2;
        List<Integer> indexCollection = null;

        while (start <= end) {
            if (nums[mid] == target) {
                indexCollection = new ArrayList<>();
                indexCollection.add(mid);
                break;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            mid = (start + end) / 2;
        }

        if (indexCollection != null) {

            int left = indexCollection.get(0) - 1;
            int right = indexCollection.get(0) + 1;
            boolean leftFlag = false;
            boolean rightFlag = false;

            while (right < nums.length || left >= 0) {
                if (leftFlag && rightFlag) {
                    break;
                }
                if (left >= 0) {
                    if (nums[left] == target) {
                        indexCollection.add(left);
                        left--;
                    } else {
                        leftFlag = true;
                    }
                } else {
                    leftFlag = true;
                }
                if (right <= nums.length - 1) {
                    if (nums[right] == target) {
                        indexCollection.add(right);
                        right++;
                    } else {
                        rightFlag = true;
                    }
                } else {
                    rightFlag = true;
                }
            }

            result[0] = Collections.min(indexCollection);
            result[1] = Collections.max(indexCollection);
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

//统计一个数字在排序数组中出现的次数。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [5,7,7,8,8,10], target = 8
//输出: 2 
//
// 示例 2: 
//
// 
//输入: nums = [5,7,7,8,8,10], target = 6
//输出: 0 
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
//
// 
//
// 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-
//position-of-element-in-sorted-array/ 
// Related Topics 数组 二分查找 👍 273 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0] == target ? 1 : 0;
        }

        int left = 0, right = nums.length - 1;
        int index = -1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                index = mid;
                break;
            }

            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        index = index == -1 ? nums[left] == target ? left : -1 : index;

        if (index == -1) {
            return 0;
        }

        int prev = index - 1, next = index + 1;
        int result = 1;

        while (prev >= 0 && nums[prev] == target) {
            prev--;
            result++;
        }

        while (next < nums.length && nums[next] == target) {
            next++;
            result++;
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

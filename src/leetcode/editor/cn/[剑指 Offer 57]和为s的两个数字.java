//输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [2,7,11,15], target = 9
//输出：[2,7] 或者 [7,2]
// 
//
// 示例 2： 
//
// 输入：nums = [10,26,30,31,47,60], target = 40
//输出：[10,30] 或者 [30,10]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= nums.length <= 10^5 
// 1 <= nums[i] <= 10^6 
// 
// Related Topics 数组 双指针 二分查找 👍 167 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
//        for (int i = 0; i < nums.length - 1; ++i) {
//            if (binarySearch(i+1, nums.length-1, target - nums[i], nums) != -1) {
//                return new int[]{nums[i], target - nums[i]};
//            }
//        }
//
//        return new int[0];

        int left = 0, right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == target) {
                return new int[] {nums[left], nums[right]};
            } else if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            }
        }

        return new int[0];
    }

    int binarySearch(int left, int right, int target, int[] nums) {
        if (target < 0) {
            return -1;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }

        return nums[left] == target ? left : -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

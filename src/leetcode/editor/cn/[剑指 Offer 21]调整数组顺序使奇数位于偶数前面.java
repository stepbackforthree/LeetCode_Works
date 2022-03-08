//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。 
//
// 
//
// 示例： 
//
// 
//输入：nums = [1,2,3,4]
//输出：[1,3,2,4] 
//注：[3,1,2,4] 也是正确的答案之一。 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 50000 
// 0 <= nums[i] <= 10000 
// 
// Related Topics 数组 双指针 排序 👍 197 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] exchange(int[] nums) {
//        int[] result = new int[nums.length];
//        int rightIdx = nums.length - 1;
//        int leftIdx = 0;
//
//        for (int num : nums) {
//            if (num % 2 == 0) {
//                result[rightIdx--] = num;
//            } else {
//                result[leftIdx++] = num;
//            }
//        }
//
//        return result;

        int left = 0, right = nums.length - 1;

        while (left < right) {
            while (left < right && (nums[left] & 1) == 1) {
                left++;
            }

            while (left < right && (nums[right] & 1) == 0) {
                right--;
            }

            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }

        return nums;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

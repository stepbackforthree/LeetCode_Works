//给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。 
//
// 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,0,2,1,1,0]
//输出：[0,0,1,1,2,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,0,1]
//输出：[0,1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[0]
// 
//
// 示例 4： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 300 
// nums[i] 为 0、1 或 2 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以不使用代码库中的排序函数来解决这道题吗？ 
// 你能想出一个仅使用常数空间的一趟扫描算法吗？ 
// 
// Related Topics 数组 双指针 排序 👍 1004 👎 0


import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1;

        for (int i = 0; i <= right; ++i) {
            while (nums[i] == 2 && i <= right) {
                swap(i, right, nums);
                --right;
            }

            if (nums[i] == 0) {
                swap(i, left, nums);
                ++left;
            }
        }

//        long num0 = Arrays.stream(nums).filter(x -> x == 0).count();
//        long num1 = Arrays.stream(nums).filter(x -> x == 1).count();
//        long num2 = Arrays.stream(nums).filter(x -> x == 2).count();
//
//        int index = 0;
//        for (int i = 0; i < num0; ++i) {
//            nums[index] = 0;
//            ++index;
//        }
//
//        for (int i = 0; i < num1; ++i) {
//            nums[index] = 1;
//            ++index;
//        }
//
//        for (int i = 0; i < num2; ++i) {
//            nums[index] = 2;
//            ++index;
//        }
    }

    void swap(int x, int y, int[] nums) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

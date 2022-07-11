//给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a ，b ，c ，使得 a + b + c = 0 ？请找出所有和为 0 且 
//不重复 的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// 
//
// 注意：本题与主站 15 题相同：https://leetcode-cn.com/problems/3sum/ 
// Related Topics 数组 双指针 排序 👍 69 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        Set<List<Integer>> res = new HashSet<>();

        for (int i = 0; i < nums.length - 2; ++i) {

            for (int j = i + 1; j < nums.length - 1; ++j) {

                int index = binarySearch(nums, j + 1, nums.length - 1, -(nums[i] + nums[j]));

                if (index != -1) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[index]);

                    res.add(list);
                }
            }
        }

        return new ArrayList<>(res);
    }

    public int binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
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
// Related Topics 数组 双指针 排序 👍 3666 👎 0


import java.util.*;
import java.util.stream.Collectors;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> result = new HashSet<>();

        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            int twoSumValue = -nums[i];
            for (int j = i + 1; j < nums.length - 1; j++) {
                int oneSumValue = twoSumValue - nums[j];
                ArrayList<Integer> arrayList = (ArrayList<Integer>) Arrays.stream(Arrays.copyOfRange(nums, j + 1, nums.length)).boxed().collect(Collectors.toList());
                HashSet<Integer> hashSet = new HashSet<>(arrayList);
                if (hashSet.contains(oneSumValue)) {
                    ArrayList<Integer> arrayList1 = new ArrayList<>();
                    arrayList1.add(nums[i]);
                    arrayList1.add(nums[j]);
                    arrayList1.add(oneSumValue);
                    arrayList1.sort(Comparator.naturalOrder());
                    result.add(arrayList1);
                }

            }
        }
        return new ArrayList<>(result);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

//给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 
//输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// k 的取值范围是 [1, 数组中不相同的元素的个数] 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的 
// 
//
// 
//
// 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。 
// Related Topics 数组 哈希表 分治 桶排序 计数 快速选择 排序 堆（优先队列） 👍 1091 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; ++i) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<List<Integer>> priorityQueue = new PriorityQueue<>((x, y) -> x.get(1) - y.get(1));

        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            int key = entry.getKey();
            int value = entry.getValue();
            List<Integer> list = new ArrayList<>();

            if (priorityQueue.size() < k) {
                list.add(key);
                list.add(value);
                priorityQueue.add(list);
            } else {
                if (priorityQueue.peek().get(1) < value) {
                    priorityQueue.poll();
                    list.add(key);
                    list.add(value);
                    priorityQueue.add(list);
                }
            }
        }

        int[] result = new int[k];
        int index = 0;

        while (!priorityQueue.isEmpty()) {
            result[index++] = priorityQueue.poll().get(0);
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

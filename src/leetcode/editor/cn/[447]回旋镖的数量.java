//给定平面上 n 对 互不相同 的点 points ，其中 points[i] = [xi, yi] 。回旋镖 是由点 (i, j, k) 表示的元组 ，其中
// i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。 
//
// 返回平面上所有回旋镖的数量。 
// 
//
// 示例 1： 
//
// 
//输入：points = [[0,0],[1,0],[2,0]]
//输出：2
//解释：两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
// 
//
// 示例 2： 
//
// 
//输入：points = [[1,1],[2,2],[3,3]]
//输出：2
// 
//
// 示例 3： 
//
// 
//输入：points = [[1,1]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// n == points.length 
// 1 <= n <= 500 
// points[i].length == 2 
// -10⁴ <= xi, yi <= 10⁴ 
// 所有点都 互不相同 
// 
// Related Topics 数组 哈希表 数学 👍 177 👎 0


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numberOfBoomerangs(int[][] points) {
        Map<Double, Integer> hashMap = new HashMap<>();
        int result = 0;

        for (int i = 0; i < points.length; ++i) {
            for (int j = 0; j < points.length; ++j) {
                if (i != j) {
                    double distance = calculateDistance(points[i], points[j]);
                    if (!hashMap.containsKey(distance)) {
                        hashMap.put(distance, 1);
                    } else {
                        hashMap.put(distance, hashMap.get(distance) + 1);
                    }
                }
            }

            for (Map.Entry<Double, Integer> entry : hashMap.entrySet()) {
                int n = entry.getValue();
                if (n > 1) {
                    result += n * (n - 1);
                }
            }
            hashMap.clear();
        }

        return result;
    }

    double calculateDistance(int[] a, int[] b) {
        return Math.pow((a[0] - b[0]), 2) + Math.pow(a[1] - b[1], 2);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

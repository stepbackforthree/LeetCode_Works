//给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：6
//解释：最大矩形如上图所示。
// 
//
// 示例 2： 
//
// 
//输入：matrix = []
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：matrix = [["0"]]
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：matrix = [["1"]]
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：matrix = [["0","0"]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// rows == matrix.length 
// cols == matrix[0].length 
// 0 <= row, cols <= 200 
// matrix[i][j] 为 '0' 或 '1' 
// 
// Related Topics 栈 数组 动态规划 矩阵 单调栈 👍 1036 👎 0


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }

        int[] heights = new int[matrix[0].length];

        int result = Integer.MIN_VALUE;
        for (char[] chars : matrix) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (chars[j] == '1') {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }
            result = Math.max(result, findRectangle(heights));
        }

        return result;
    }

    int findRectangle(int[] heights) {
        Deque<Integer> leftStack = new ArrayDeque<>();
        Deque<Integer> rightStack = new ArrayDeque<>();
        int[] leftIdx = new int[heights.length], rightIdx = new int[heights.length];

        for (int i = 0; i < heights.length; ++i) {
            while (!leftStack.isEmpty() && heights[leftStack.peek()] >= heights[i]) {
                leftStack.pop();
            }
            leftIdx[i] = leftStack.isEmpty() ? -1 : leftStack.peek();
            leftStack.push(i);
        }

        for (int i = heights.length - 1; i >= 0; --i) {
            while (!rightStack.isEmpty() && heights[rightStack.peek()] >= heights[i]) {
                rightStack.pop();
            }
            rightIdx[i] = rightStack.isEmpty() ? heights.length : rightStack.peek();
            rightStack.push(i);
        }

        int subMax = Integer.MIN_VALUE;
        for (int i = 0; i < leftIdx.length; ++i) {
            subMax = Math.max(subMax, (rightIdx[i] - leftIdx[i] - 1) * heights[i]);
        }

        return subMax;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

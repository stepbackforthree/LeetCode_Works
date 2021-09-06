//给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。 
//
// 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[[7,4,1],[8,5,2],[9,6,3]]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
//输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
// 
//
// 示例 3： 
//
// 
//输入：matrix = [[1]]
//输出：[[1]]
// 
//
// 示例 4： 
//
// 
//输入：matrix = [[1,2],[3,4]]
//输出：[[3,1],[4,2]]
// 
//
// 
//
// 提示： 
//
// 
// matrix.length == n 
// matrix[i].length == n 
// 1 <= n <= 20 
// -1000 <= matrix[i][j] <= 1000 
// 
// Related Topics 数组 数学 矩阵 👍 991 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void rotate(int[][] matrix) {
        // core thoughts: iteratively travel every cycle from outer to inner
        // i.e. matrix[0] and matrix[-1] is the first cycle, matrix[1] and matrix[-2] is the second cycle, and so on

        int width = matrix[0].length, height = matrix.length, start = 0, end = width - 1, layer = 0;

        // have already finished the last (i.e. inner) cycle and there is no element or only single element that no need to rotate
        while (start < end) {
            // firstly rotate the elements in four corners, matrix[0][0], matrix[0][-1], matrix[-1][0] and matrix[-1][-1]
            swap(layer, start, layer, end, matrix);
            swap(layer, start,height - layer - 1, end, matrix);
            swap(layer, start, height - layer - 1, start, matrix);

            // then mark them as position discriminators
            int[][] indexCollection = new int[][]{{layer, start}, {layer, end},
                    {height - layer - 1, end}, {height - layer - 1, start}};

            // iteratively rotate the following element in the same cycle
            for (int i = 1; i < indexCollection.length; i++) {
                for (int j = 1; j < end - start; j++) {
                    // for position of every element, we have three conditions to change their index
                    if (i == 1) {
                        swap(indexCollection[0][0], indexCollection[0][1] + j,
                                indexCollection[i][0] + j, indexCollection[i][1], matrix);
                    } else if (i == 2) {
                        swap(indexCollection[0][0], indexCollection[0][1] + j,
                                indexCollection[i][0], indexCollection[i][1] - j, matrix);
                    } else {
                        swap(indexCollection[0][0], indexCollection[0][1] + j,
                                indexCollection[i][0] - j, indexCollection[i][1], matrix);
                    }
                }
            }

            // move to the next (i.e. inner) cycle
            layer++;
            start++;
            end--;
        }
    }

    // changing value function that makes life easier
    void swap(int width1, int height1, int width2, int height2, int[][] matrix) {
        int temp = matrix[width1][height1];
        matrix[width1][height1] = matrix[width2][height2];
        matrix[width2][height2] = temp;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

//在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个
//整数，判断数组中是否含有该整数。 
//
// 
//
// 示例: 
//
// 现有矩阵 matrix 如下： 
//
// 
//[
//  [1,   4,  7, 11, 15],
//  [2,   5,  8, 12, 19],
//  [3,   6,  9, 16, 22],
//  [10, 13, 14, 17, 24],
//  [18, 21, 23, 26, 30]
//]
// 
//
// 给定 target = 5，返回 true。 
//
// 给定 target = 20，返回 false。 
//
// 
//
// 限制： 
//
// 0 <= n <= 1000 
//
// 0 <= m <= 1000 
//
// 
//
// 注意：本题与主站 240 题相同：https://leetcode-cn.com/problems/search-a-2d-matrix-ii/ 
// Related Topics 数组 二分查找 分治 矩阵 👍 569 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int n;
    int m;
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        this.n = matrix.length;
        this.m = matrix[0].length;

//        for (int i = 0; i < n; ++i) {
//            if (matrix[i][0] <= target && matrix[i][m-1] >= target) {
//                if (rowBinarySearch(matrix[i], target)) {
//                    return true;
//                }
//            }
//        }
//
//        return false;

        return findNext(matrix, 0, matrix[0].length-1, target);
    }

    boolean rowBinarySearch(int[] row, int target) {
        int n = row.length;
        int left = 0, right = n - 1, mid = (left + right) / 2;

        while (left <= right) {
            mid = (left + right) / 2;
            if (row[mid] == target) {
                return true;
            }

            if (row[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    boolean findNext(int[][] matrix, int n, int m, int target) {
        if (n >= matrix.length || m < 0) {
            return false;
        }

        if (matrix[n][m] == target) {
            return true;
        } else if (matrix[n][m] > target) {
                return findNext(matrix, n, m - 1, target);
        } else {
                return findNext(matrix, n + 1, m, target);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

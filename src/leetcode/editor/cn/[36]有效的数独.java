//请你判断一个 9x9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图） 
// 
//
// 数独部分空格内已填入了数字，空白格用 '.' 表示。 
//
// 注意： 
//
// 
// 一个有效的数独（部分已被填充）不一定是可解的。 
// 只需要根据以上规则，验证已经填入的数字是否有效即可。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：board = 
//[["5","3",".",".","7",".",".",".","."]
//,["6",".",".","1","9","5",".",".","."]
//,[".","9","8",".",".",".",".","6","."]
//,["8",".",".",".","6",".",".",".","3"]
//,["4",".",".","8",".","3",".",".","1"]
//,["7",".",".",".","2",".",".",".","6"]
//,[".","6",".",".",".",".","2","8","."]
//,[".",".",".","4","1","9",".",".","5"]
//,[".",".",".",".","8",".",".","7","9"]]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = 
//[["8","3",".",".","7",".",".",".","."]
//,["6",".",".","1","9","5",".",".","."]
//,[".","9","8",".",".",".",".","6","."]
//,["8",".",".",".","6",".",".",".","3"]
//,["4",".",".","8",".","3",".",".","1"]
//,["7",".",".",".","2",".",".",".","6"]
//,[".","6",".",".",".",".","2","8","."]
//,[".",".",".","4","1","9",".",".","5"]
//,[".",".",".",".","8",".",".","7","9"]]
//输出：false
//解释：除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无
//效的。 
//
// 
//
// 提示： 
//
// 
// board.length == 9 
// board[i].length == 9 
// board[i][j] 是一位数字或者 '.' 
// 
// Related Topics 数组 哈希表 矩阵 👍 611 👎 0


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> horizontalSet = new HashSet<>();
        Map<Integer, HashSet<Character>> verticalMap = new HashMap<>();
        Map<Integer, HashSet<Character>> matrixMap = new HashMap<>();

        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (board[i][j] != '.') {
                    if (horizontalSet.contains(board[i][j])) {
                        return false;
                    }
                    horizontalSet.add(board[i][j]);

                    HashSet<Character> verticalSet = verticalMap.getOrDefault(j, new HashSet<>());
                    if (verticalSet.contains(board[i][j])) {
                        return false;
                    }
                    verticalSet.add(board[i][j]);
                    verticalMap.put(j, verticalSet);

                    int count = -1;
                    if (i <= 2) {
                        count = 0;
                    } else if (i <= 5) {
                        count = 3;
                    } else {
                        count = 6;
                    }
                    HashSet<Character> matrixSet = matrixMap.getOrDefault(count + j / 3, new HashSet<>());
                    if (matrixSet.contains(board[i][j])) {
                        return false;
                    }
                    matrixSet.add(board[i][j]);
                    matrixMap.put(count + j / 3, matrixSet);
                }
            }
            horizontalSet.clear();
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

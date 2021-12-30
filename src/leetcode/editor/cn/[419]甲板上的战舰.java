//给你一个大小为 m x n 的矩阵 board 表示甲板，其中，每个单元格可以是一艘战舰 'X' 或者是一个空位 '.' ，返回在甲板 board 上放置的
// 战舰 的数量。 
//
// 战舰 只能水平或者垂直放置在 board 上。换句话说，战舰只能按 1 x k（1 行，k 列）或 k x 1（k 行，1 列）的形状建造，其中 k 可以
//是任意大小。两艘战舰之间至少有一个水平或垂直的空位分隔 （即没有相邻的战舰）。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["X",".",".","X"],[".",".",".","X"],[".",".",".","X"]]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：board = [["."]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 200 
// board[i][j] 是 '.' 或 'X' 
// 
//
// 
//
// 进阶：你可以实现一次扫描算法，并只使用 O(1) 额外空间，并且不修改 board 的值来解决这个问题吗？ 
// Related Topics 深度优先搜索 数组 矩阵 👍 162 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countBattleships(char[][] board) {
//        int result = 0;
//        for (int i = 0; i < board.length; ++i) {
//            for (int j = 0; j < board[0].length; ++j) {
//                if (board[i][j] == 'X') {
//                    board[i][j] = '.';
//                    if (i < board.length - 1 && board[i+1][j] == 'X') {
//                       result += verticalScan(board, i+1, j);
//                    } else if (j < board[0].length - 1 && board[i][j+1] == 'X') {
//                        result += horizontalScan(board, i, j+1);
//                    } else {
//                        result += 1;
//                    }
//                }
//            }
//        }
//        return result;

        int result = 0;
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (board[i][j] == 'X') {
                    if (i > 0 && board[i-1][j] == 'X') {
                        continue;
                    }
                    if (j > 0 && board[i][j-1] == 'X') {
                        continue;
                    }
                    result++;
                }
            }
        }

        return result;
    }

    int horizontalScan(char[][] board, int currX, int currY) {
        if (currY == board[0].length || board[currX][currY] == '.') {
            return 1;
        } else {
            board[currX][currY] = '.';
            return horizontalScan(board, currX, currY+1);
        }
    }

    int verticalScan(char[][] board, int currX, int currY) {
        if (currX == board.length || board[currX][currY] == '.') {
            return 1;
        } else {
            board[currX][currY] = '.';
            return verticalScan(board, currX+1, currY);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

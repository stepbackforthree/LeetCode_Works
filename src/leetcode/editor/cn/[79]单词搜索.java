//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"SEE"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCB"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？ 
// Related Topics 数组 回溯 矩阵 👍 1021 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    if (findNext(board, i, j, visited, word, 1)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    boolean findNext(char[][] board, int currX, int currY, boolean[][] visited, String word, int count) {
        if (currX >= board.length || currX < 0 || currY >= board[0].length || currY < 0) {
            return false;
        }

        if (visited[currX][currY]) {
            return false;
        }

        if (count == word.length()) {
            return true;
        }

        boolean right = false, left = false, up = false, down = false;

        if (currX < board.length - 1 && board[currX+1][currY] == word.charAt(count)) {
            visited[currX][currY] = true;
            right = findNext(board, currX+1, currY, visited, word, count+1);
            visited[currX][currY] = false;
        }

        if (currX > 0 && board[currX-1][currY] == word.charAt(count)) {
            visited[currX][currY] = true;
            left = findNext(board, currX-1, currY, visited, word, count+1);
            visited[currX][currY] = false;
        }

        if (currY < board[0].length - 1 && board[currX][currY+1] == word.charAt(count)) {
            visited[currX][currY] = true;
            down = findNext(board, currX, currY+1, visited, word, count+1);
            visited[currX][currY] = false;
        }

        if (currY > 0 && board[currX][currY-1] == word.charAt(count)) {
            visited[currX][currY] = true;
            up = findNext(board, currX, currY-1, visited, word, count+1);
            visited[currX][currY] = false;
        }

        return left || right || down || up;
    }
//    char[][] board;
//    String word;
//    public boolean exist(char[][] board, String word) {
//        this.board = board;
//        this.word = word;
//
//        for (int i = 0; i < board.length; ++i) {
//            for (int j = 0; j < board[0].length; ++j) {
//                if (board[i][j] == word.charAt(0)) {
//                    List<String> used = new ArrayList<>();
//                    used.add(i + "" + j);
//                    if (findNext(i, j, used)) {
//                        return true;
//                    }
//                }
//            }
//        }
//        return false;
//    }
//
//    boolean findNext(int currM, int currN, List<String> used) {
//        if (used.size() == word.length()) {
//            return true;
//        }
//
//        int m = board.length, n = board[0].length;
//        int upM = currM - 1, downM = currM + 1, leftN = currN - 1, rightN = currN + 1;
//        boolean flag1 = false, flag2 = false, flag3 = false, flag4 = false, flag = false;
//
//        if (upM >= 0 && board[upM][currN] == word.charAt(used.size()) && !used.contains(upM+""+currN)) {
//            List<String> temp = new ArrayList<>(used);
//            temp.add(upM+""+currN);
//            flag = true;
//            flag1 = findNext(upM, currN, temp);
//        }
//
//        if (downM < board.length && board[downM][currN] == word.charAt(used.size()) && !used.contains(downM+""+currN)) {
//            List<String> temp = new ArrayList<>(used);
//            temp.add(downM+""+currN);
//            flag = true;
//            flag2 = findNext(downM, currN, temp);
//        }
//
//        if (leftN >= 0 && board[currM][leftN] == word.charAt(used.size()) && !used.contains(currM+""+leftN)) {
//            List<String> temp = new ArrayList<>(used);
//            temp.add(currM+""+leftN);
//            flag = true;
//            flag3 = findNext(currM, leftN, temp);
//        }
//
//        if (rightN < board[0].length && board[currM][rightN] == word.charAt(used.size()) && !used.contains(currM+""+rightN)) {
//            List<String> temp = new ArrayList<>(used);
//            temp.add(currM+""+rightN);
//            flag = true;
//            flag4 = findNext(currM, rightN, temp);
//        }
//
//        if (!flag) {
//            return false;
//        }
//
//        return flag1 || flag2 || flag3 || flag4;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

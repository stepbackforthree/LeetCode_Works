//给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words，找出所有同时在二维网格和字典中出现的单词。 
//
// 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使
//用。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f",
//"l","v"]], words = ["oath","pea","eat","rain"]
//输出：["eat","oath"]
// 
//
// 示例 2： 
//
// 
//输入：board = [["a","b"],["c","d"]], words = ["abcb"]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 12 
// board[i][j] 是一个小写英文字母 
// 1 <= words.length <= 3 * 10⁴ 
// 1 <= words[i].length <= 10 
// words[i] 由小写英文字母组成 
// words 中的所有字符串互不相同 
// 
// Related Topics 字典树 数组 字符串 回溯 矩阵 👍 482 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            boolean find = false;
            for (int i = 0; i < board.length; ++i) {
                for (int j = 0; j < board[0].length; ++j) {
                    if (board[i][j] == word.charAt(0)) {
                        if (findNext(board, word, 0, i, j, new boolean[board.length][board[0].length])) {
                            result.add(word);
                            find = true;
                            break;
                        }
                    }
                }
                if (find) {
                    break;
                }
            }
        }
        return result;
    }

    boolean findNext(char[][] board, String word, int position, int currM, int currN, boolean[][] visited) {
        if (currM >= 0 && currM < board.length && currN >= 0 && currN < board[0].length && !visited[currM][currN]) {
            if (position < word.length()) {
                if (word.charAt(position) == board[currM][currN]) {
                    visited[currM][currN] = true;
                    if(findNext(board, word, position + 1, currM + 1, currN, visited) ||
                            findNext(board, word, position + 1, currM - 1, currN, visited) ||
                            findNext(board, word, position + 1, currM, currN + 1, visited) ||
                            findNext(board, word, position + 1, currM, currN - 1, visited)) {
                        return true;
                    } else {
                        visited[currM][currN] = false;
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                return true;
            }
        }
        return position == word.length();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

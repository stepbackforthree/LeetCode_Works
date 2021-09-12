import org.junit.Test;

import java.util.*;

public class test {
    char[][] board = {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
    String word = "ABCB";
    @Test
    public void test() {
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (board[i][j] == word.charAt(0)) {
                    List<String> used = new ArrayList<>();
                    used.add(i + "" + j);
                    if (findNext(i, j, used)) {
                        System.out.println(true);
                        break;
                    }
                }
            }
        }
        System.out.println(false);
    }

    boolean findNext(int currM, int currN, List<String> used) {
        if (used.size() == word.length()) {
            return true;
        }

        int m = board.length, n = board[0].length;
        int upM = currM - 1, downM = currM + 1, leftN = currN - 1, rightN = currN + 1;
        boolean flag1 = false, flag2 = false, flag3 = false, flag4 = false, flag = false;

        if (upM >= 0 && board[upM][currN] == word.charAt(used.size()) && !used.contains(upM+""+currN)) {
            List<String> temp = new ArrayList<>(used);
            temp.add(upM+""+currN);
            flag = true;
            flag1 = findNext(upM, currN, temp);
        }

        if (downM < board.length && board[downM][currN] == word.charAt(used.size()) && !used.contains(downM+""+currN)) {
            List<String> temp = new ArrayList<>(used);
            temp.add(downM+""+currN);
            flag = true;
            flag2 = findNext(downM, currN, temp);
        }

        if (leftN >= 0 && board[currM][leftN] == word.charAt(used.size()) && !used.contains(currM+""+leftN)) {
            List<String> temp = new ArrayList<>(used);
            temp.add(currM+""+leftN);
            flag = true;
            flag3 = findNext(currM, leftN, temp);
        }

        if (rightN < board[0].length && board[currM][rightN] == word.charAt(used.size()) && !used.contains(currM+""+rightN)) {
            List<String> temp = new ArrayList<>(used);
            temp.add(currM+""+rightN);
            flag = true;
            flag4 = findNext(currM, rightN, temp);
        }

        if (!flag) {
            return false;
        }

        return flag1 || flag2 || flag3 || flag4;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}


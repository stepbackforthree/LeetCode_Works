import com.sun.source.tree.Tree;
import org.junit.Test;

import java.util.*;

public class test {
    String s = "a";
    List<String> wordDict = new ArrayList<>();
    @Test
    public void test() {
        wordDict.add("a");

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i < s.length() + 1; ++i) {
            for (int j = i; j < s.length() + 1; ++j) {
                String subStr = s.substring(i - 1, j);
                if (wordDict.contains(subStr) && dp[i - 1]) {
                    dp[j] = true;
                }
            }
        }
        System.out.println(dp[s.length()]);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

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

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}


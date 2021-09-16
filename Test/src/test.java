import com.sun.source.tree.Tree;
import org.junit.Test;

import java.util.*;

public class test {
    //TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
    TreeNode root = new TreeNode(1, null, new TreeNode(2));
    @Test
    public void test() {
        System.out.println(findNext(root.left, root.right));
    }

    int findNext(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return 1;
        }

        if (right == null) {
            return 1 + findNext(left.left, left.right);
        } else if (left == null) {
            return 1 + findNext(right.left, right.right);
        } else {
            return 1 + Math.max(findNext(left.left, left.right), findNext(right.left, right.right));
        }
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


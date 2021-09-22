import com.sun.source.tree.Tree;
import org.junit.Test;

import java.util.*;

public class test {
    int[] nums = {-4, -3, -2};

    @Test
    public void test() {
        int result = Integer.MIN_VALUE, min = 0, max = 0;

        for (int i = 0; i < nums.length; ++i) {
            if (i == 0) {
                max = nums[i];
                min = nums[i];
            } else {
                int tempMax = max, tempMin = min;
                max = Math.max(tempMax * nums[i], Math.max(tempMin * nums[i], nums[i]));
                min = Math.min(tempMin * nums[i], Math.min(tempMax * nums[i], nums[i]));
            }

            result = Math.max(result, max);
        }

        System.out.println(result);
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


import com.sun.source.tree.Tree;
import org.junit.Test;

import java.util.*;

public class test {
    int[][] grid = {{3,0,8,4}, {2,4,5,7}, {9,2,6,3}, {0,3,1,0}};
    @Test
    public void test() {
        int result = 0;

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                result += Math.min(findNextVertical(grid, i, j, grid[i][j], i), findNextHorizontal(grid, i, j, grid[i][j], j)) - grid[i][j];
            }
        }

        System.out.println(result);
    }

    int findNextVertical(int[][] grid, int nextr, int nextc, int curr, int currIdx) {
        if (nextr >= grid.length || nextr < 0) {
            return curr;
        }

        if (currIdx == nextr) {
            return Math.max(findNextVertical(grid, nextr + 1, nextc, Math.max(curr, grid[nextr][nextc]), currIdx), findNextVertical(grid, nextr - 1, nextc, Math.max(curr, grid[nextr][nextc]), currIdx));
        } else if (currIdx > nextr) {
            return findNextVertical(grid, nextr-1, nextc, Math.max(curr, grid[nextr][nextc]), currIdx);
        } else {
            return findNextVertical(grid, nextr+1, nextc, Math.max(curr, grid[nextr][nextc]), currIdx);
        }
    }

    int findNextHorizontal(int[][] grid, int nextr, int nextc, int curr, int currIdx) {
        if (nextc >= grid[0].length || nextc < 0) {
            return curr;
        }

        if (currIdx == nextc) {
            return Math.max(findNextHorizontal(grid, nextr, nextc + 1, Math.max(curr, grid[nextr][nextc]), currIdx), findNextHorizontal(grid, nextr, nextc - 1, Math.max(curr, grid[nextr][nextc]), currIdx));
        } else if (currIdx > nextc) {
            return findNextHorizontal(grid, nextr, nextc-1, Math.max(curr, grid[nextr][nextc]), currIdx);
        } else {
            return findNextHorizontal(grid, nextr, nextc+1, Math.max(curr, grid[nextr][nextc]), currIdx);
        }
    }
}

class Node {
    int val;
    Node prev;
    Node next;
    Node child;

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node prev, Node next, Node child) {
        this.val = val;
        this.prev = prev;
        this.next = next;
        this.child = child;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", prev=" + prev +
                ", next=" + next +
                ", child=" + child +
                '}';
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


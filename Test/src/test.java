import com.sun.source.tree.Tree;
import org.junit.Test;

import java.util.*;

public class test {
    @Test
    public void test() {
        System.out.println(GetLeastNumbers_Solution(new int[]{4,5,1,6,2,7,3,8}, 4));
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        quickSort(0, input.length - 1, input);

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < k; ++i) {
            result.add(input[i]);
        }

        return result;
    }

    void quickSort(int left, int right, int[] nums) {
        if (left >= right) {
            return;
        }

        int l = left, r = right;
        int std = nums[left];

        while (l < r) {
            while (l < r && nums[r] >= std) {
                r--;
            }

            while (l < r && nums[l] <= std) {
                l++;
            }

            if (l < r) {
                swap(l, r, nums);
            }
        }

        swap(left, l, nums);

        quickSort(left, l - 1, nums);
        quickSort(l + 1, right, nums);
    }

    void swap(int left, int right, int[] nums) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
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

class Trie {
    Trie[] children;
    Boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }
}


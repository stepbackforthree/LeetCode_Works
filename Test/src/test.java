import org.junit.Test;

import java.util.*;

public class test {
    @Test
    public void test() {
        int[] nums = {-2,1};
        int[][] subMaxCollection = new int[nums.length][nums.length];
        int subSum = 0;
        for (int i = 0; i < nums.length; i++) {
            subSum += nums[i];
            subMaxCollection[0][i] = subSum;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (j < i) {
                    subMaxCollection[i][j] = Integer.MIN_VALUE;
                } else if (i == j) {
                    subMaxCollection[i][j] = nums[i];
                } else {
                    subMaxCollection[i][j] = subMaxCollection[i - 1][j] - subMaxCollection[i - 1][i - 1];
                }
            }
        }

        int maxValue = Integer.MIN_VALUE;
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < nums.length; i++) {
            int[] num = subMaxCollection[i];
            int tempMaxValue = Arrays.stream(num).max().getAsInt();
            if (tempMaxValue > maxValue) {
                index1 = i;
                maxValue = tempMaxValue;
            }
        }

        for (int j = index1; j < nums.length; j++) {
            if (subMaxCollection[index1][j] == maxValue) {
                index2 = j;
            }
        }

        int[] result = new int[index2 - index1 + 1];
        System.out.println(Arrays.deepToString(subMaxCollection));
        for (int i = index1; i < index2 + 1; i++) {
            result[i - index1] = nums[i];
        }

        System.out.println(Arrays.toString(result));
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


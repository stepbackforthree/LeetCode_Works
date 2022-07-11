import org.junit.Test;

import java.util.*;


public class Solution {
    int leftNextNext = 0;
    int rightNextNext = 0;

    @Test
    public void test() {

    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 盲盒均分，给出礼物能平均分成的最多盲盒数量
     * @param gif int整型一维数组 各个礼物价值的数组
     * @return int整型
     */
    public int BlindBoxSplit (int[] gif) {
        Arrays.sort(gif);

        int sum = Arrays.stream(gif).sum();

        int[] dp = new int[sum+1];

        for (int g : gif) {
            dp[g]++;
        }

        for (int i = 0; i <= dp.length; ++i) {
            for (int g : gif) {
                if ((i + g <= sum) && dp[i] != 0 && g > i) {
                    dp[i+g]++;
                }
            }
        }

        int result = Integer.MIN_VALUE;

        for (int d : dp) {
            result = result < d ? d : result;
        }

        return result;
    }

    int findNext(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int findLeft = findNext(node.left);
        int findRight = findNext(node.right);

        int left = findLeft > leftNextNext + node.val ? findLeft : leftNextNext + node.val;
        int right = findRight > rightNextNext + node.val ? findRight : rightNextNext + node.val;

        leftNextNext = left;
        rightNextNext = right;

        return left + right;
    }
}

//地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一
//格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但
//它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？ 
//
// 
//
// 示例 1： 
//
// 输入：m = 2, n = 3, k = 1
//输出：3
// 
//
// 示例 2： 
//
// 输入：m = 3, n = 1, k = 0
//输出：1
// 
//
// 提示： 
//
// 
// 1 <= n,m <= 100 
// 0 <= k <= 20 
// 
// Related Topics 深度优先搜索 广度优先搜索 动态规划 👍 439 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int k;
    int m;
    int n;
    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        boolean[][] visited = new boolean[m][n];

        return findNext(0, 0, visited);
    }

    int findNext(int currM, int currN, boolean[][] visited) {
        if (currM < 0 || currM >= m || currN < 0 || currN >= n || visited[currM][currN]) {
            return 0;
        }

        if (!checkReachable(currM, currN)) {
            return 0;
        }

        visited[currM][currN] = true;

        return findNext(currM+1, currN, visited) + findNext(currM-1, currN, visited) +
                findNext(currM, currN+1, visited) + findNext(currM, currN-1, visited) + 1;
    }

    Boolean checkReachable(int m, int n) {
        int tempM = 0, tempN = 0;

        while (m != 0) {
            tempM += m % 10;
            m /= 10;
        }

        while (n != 0) {
            tempN += n % 10;
            n /= 10;
        }

        return (tempM + tempN) <= k;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

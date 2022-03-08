//在一个 10⁶ x 10⁶ 的网格中，每个网格上方格的坐标为 (x, y) 。 
//
// 现在从源方格 source = [sx, sy] 开始出发，意图赶往目标方格 target = [tx, ty] 。数组 blocked 是封锁的方格列表
//，其中每个 blocked[i] = [xi, yi] 表示坐标为 (xi, yi) 的方格是禁止通行的。 
//
// 每次移动，都可以走到网格中在四个方向上相邻的方格，只要该方格 不 在给出的封锁列表 blocked 上。同时，不允许走出网格。 
//
// 只有在可以通过一系列的移动从源方格 source 到达目标方格 target 时才返回 true。否则，返回 false。 
//
// 
//
// 示例 1： 
//
// 
//输入：blocked = [[0,1],[1,0]], source = [0,0], target = [0,2]
//输出：false
//解释：
//从源方格无法到达目标方格，因为我们无法在网格中移动。
//无法向北或者向东移动是因为方格禁止通行。
//无法向南或者向西移动是因为不能走出网格。 
//
// 示例 2： 
//
// 
//输入：blocked = [], source = [0,0], target = [999999,999999]
//输出：true
//解释：
//因为没有方格被封锁，所以一定可以到达目标方格。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= blocked.length <= 200 
// blocked[i].length == 2 
// 0 <= xi, yi < 10⁶ 
// source.length == target.length == 2 
// 0 <= sx, sy, tx, ty < 10⁶ 
// source != target 
// 题目数据保证 source 和 target 不在封锁列表内 
// 
// Related Topics 深度优先搜索 广度优先搜索 数组 哈希表 👍 150 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 在包围圈中
    static final int BLOCKED = -1;
    // 不在包围圈中
    static final int VALID = 0;
    // 无论在不在包围圈中，但在 n(n-1)/2 步搜索的过程中经过了 target
    static final int FOUND = 1;

    static final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static final int BOUNDARY = 1000000;

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        if (blocked.length < 2) {
            return true;
        }

        Set<Pair> hashBlocked = new HashSet<Pair>();
        for (int[] pos : blocked) {
            hashBlocked.add(new Pair(pos[0], pos[1]));
        }

        int result = check(blocked, source, target, hashBlocked);
        if (result == FOUND) {
            return true;
        } else if (result == BLOCKED) {
            return false;
        } else {
            result = check(blocked, target, source, hashBlocked);
            return result != BLOCKED;
        }
    }

    public int check(int[][] blocked, int[] start, int[] finish, Set<Pair> hashBlocked) {
        int sx = start[0], sy = start[1];
        int fx = finish[0], fy = finish[1];
        int countdown = blocked.length * (blocked.length - 1) / 2;
        Pair startPair = new Pair(sx, sy);
        Queue<Pair> queue = new ArrayDeque<Pair>();
        queue.offer(startPair);
        Set<Pair> visited = new HashSet<Pair>();
        visited.add(startPair);
        while (!queue.isEmpty() && countdown > 0) {
            Pair pair = queue.poll();
            int x = pair.x, y = pair.y;
            for (int d = 0; d < 4; ++d) {
                int nx = x + dirs[d][0], ny = y + dirs[d][1];
                Pair newPair = new Pair(nx, ny);
                if (nx >= 0 && nx < BOUNDARY && ny >= 0 && ny < BOUNDARY && !hashBlocked.contains(newPair) && !visited.contains(newPair)) {
                    if (nx == fx && ny == fy) {
                        return FOUND;
                    }
                    --countdown;
                    queue.offer(newPair);
                    visited.add(newPair);
                }
            }
        }
        if (countdown > 0) {
            return BLOCKED;
        }
        return VALID;
    }
}

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
        return (int) ((long) x << 20 | y);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Pair) {
            Pair pair2 = (Pair) obj;
            return x == pair2.x && y == pair2.y;
        }
        return false;
    }
}

//请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都
//是O(1)。 
//
// 若队列为空，pop_front 和 max_value 需要返回 -1 
//
// 示例 1： 
//
// 输入: 
//["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
//[[],[1],[2],[],[],[]]
//输出: [null,null,null,2,1,2]
// 
//
// 示例 2： 
//
// 输入: 
//["MaxQueue","pop_front","max_value"]
//[[],[],[]]
//输出: [null,-1,-1]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= push_back,pop_front,max_value的总操作数 <= 10000 
// 1 <= value <= 10^5 
// 
// Related Topics 设计 队列 单调队列 👍 325 👎 0


import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

//leetcode submit region begin(Prohibit modification and deletion)
class MaxQueue {
    Deque<Integer> queue = new LinkedList<>();
    Deque<Integer> monotonicQueue = new LinkedList<>();

    public MaxQueue() {
    }
    
    public int max_value() {
        if (monotonicQueue.isEmpty()) {
            return -1;
        }

        return monotonicQueue.peekFirst();
    }
    
    public void push_back(int value) {
        while (!monotonicQueue.isEmpty() && monotonicQueue.peekLast() < value) {
            monotonicQueue.pollLast();
        }

        monotonicQueue.offerLast(value);
        queue.offer(value);
    }
    
    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }

        if (Objects.equals(queue.peek(), monotonicQueue.peekFirst())) {
            monotonicQueue.pollFirst();
        }

        return queue.poll();
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
//leetcode submit region end(Prohibit modification and deletion)

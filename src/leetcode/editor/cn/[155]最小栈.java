//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。 
//
// 
// push(x) —— 将元素 x 推入栈中。 
// pop() —— 删除栈顶的元素。 
// top() —— 获取栈顶元素。 
// getMin() —— 检索栈中的最小元素。 
// 
//
// 
//
// 示例: 
//
// 输入：
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//输出：
//[null,null,null,null,-3,null,0,-2]
//
//解释：
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// pop、top 和 getMin 操作总是在 非空栈 上调用。 
// 
// Related Topics 栈 设计 👍 1033 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class MinStack {
    int[] stack;
    int capacity;
    int top;
    int min;

    public MinStack() {
        this.capacity = 16;
        this.stack = new int[capacity];
        this.top = -1;
        this.min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if (top == capacity - 1) {
            int[] temp = new int[capacity * 2];
            System.arraycopy(stack, 0, temp, 0, capacity);
            stack = temp;
            capacity = capacity * 2;
        }
        stack[++top] = val;
        if (val < min) {
            min = val;
        }
    }
    
    public void pop() {
        if (stack[top] == min) {
            min = Integer.MAX_VALUE;
            for (int i = 0; i < top; ++i) {
                if (stack[i] < min) {
                    min = stack[i];
                }
            }
        }
        --top;
    }
    
    public int top() {
        return stack[top];
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)

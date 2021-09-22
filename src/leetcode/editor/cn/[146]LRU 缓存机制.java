//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制 。 
//
// 
// 
// 实现 LRUCache 类： 
//
// 
// LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上
//限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。 
// 
//
// 
// 
// 
//
// 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 
//
// 示例： 
//
// 
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 10000 
// 0 <= value <= 10⁵ 
// 最多调用 2 * 10⁵ 次 get 和 put 
// 
// Related Topics 设计 哈希表 链表 双向链表 👍 1629 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {
    private final int capacity;
    private Map<Integer, ListNode> hashMap = new HashMap<>();
    private ListNode tail = new ListNode(-1, -1);
    private ListNode end = new ListNode(-1, -1);

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (hashMap.containsKey(key)) {
            ListNode ptr = hashMap.get(key);

            ptr.pre.next = ptr.next;
            ptr.next.pre = ptr.pre;
            ptr.pre = end.pre;
            ptr.next = end;
            end.pre.next = ptr;
            end.pre = ptr;
            return ptr.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (hashMap.size() < capacity) {
            if (hashMap.size() == 0) {
                ListNode root = new ListNode(key, value, tail, end);
                tail.next = root;
                end.pre = root;
                hashMap.put(key, root);
            } else {
                ListNode ptr;
                if (hashMap.containsKey(key)) {
                    ptr = hashMap.get(key);
                    ptr.val = value;
                    ptr.pre.next = ptr.next;
                    ptr.next.pre = ptr.pre;
                    ptr.pre = end.pre;
                    ptr.next = end;
                } else {
                    ptr = new ListNode(key, value);
                    ptr.next = end;
                    ptr.pre = end.pre;
                }
                end.pre.next = ptr;
                end.pre = ptr;
                hashMap.put(key, ptr);
            }
        } else {
            if (!hashMap.containsKey(key)) {
                ListNode removed = hashMap.get(tail.next.key);
                hashMap.remove(removed.key);

                tail.next = removed.next;
                removed.next.pre = removed.pre;
                ListNode ptr = new ListNode(key, value);
                ptr.next = end;
                ptr.pre = end.pre;
                end.pre.next = ptr;
                end.pre = ptr;
                hashMap.put(key, ptr);
            } else {
                ListNode ptr = hashMap.get(key);
                ptr.val = value;
                ptr.pre.next = ptr.next;
                ptr.next.pre = ptr.pre;
                ptr.next = end;
                ptr.pre = end.pre;
                end.pre.next = ptr;
                end.pre = ptr;
                hashMap.put(key, ptr);
            }
        }
    }

    class ListNode {
        int key;
        int val;
        ListNode pre;
        ListNode next;

        ListNode() {}

        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }

        ListNode(int key, int val, ListNode pre, ListNode next) {
            this.key = key;
            this.val = val;
            this.next = next;
            this.pre = pre;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

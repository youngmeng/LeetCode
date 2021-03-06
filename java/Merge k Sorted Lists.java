/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * <p>
 * 思路一：遍历数组，反复调用合并两个链表的函数；（会超时）
 * 思路二：建立比较器传入PriorityQueue，每次取出值较小的节点
 * 如果取出节点的后续节点不为空，则继续添加进PriorityQueue.
 * <p>
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
/**
 思路一：遍历数组，反复调用合并两个链表的函数；（会超时）
 思路二：建立比较器传入PriorityQueue，每次取出值较小的节点
 如果取出节点的后续节点不为空，则继续添加进PriorityQueue.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;

        Comparator<ListNode> comp = new Comparator<ListNode>() {
            public int compare(ListNode l1, ListNode l2) {
                if (l1.val < l2.val)
                    return -1;
                else if (l1.val > l2.val)
                    return 1;
                return 0;
            }
        };

        PriorityQueue<ListNode> heap = new PriorityQueue(lists.length, comp);
        for (ListNode ln : lists) {
            if (ln != null)
                heap.add(ln);
        }

        ListNode head = null;
        ListNode cur = null;
        while (!heap.isEmpty()) {
            if (head == null) {
                head = heap.poll();
                cur = head;
            } else {
                cur.next = heap.poll();
                cur = cur.next;
            }

            if (cur.next != null) {
                heap.add(cur.next);
            }
        }

        return head;
    }
}

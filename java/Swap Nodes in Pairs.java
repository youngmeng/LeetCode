/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * <p>
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * <p>
 * Your algorithm should use only constant space.
 * You may not modify the values in the list, only nodes itself can be changed.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(0);
        for (ListNode pre = dummy, cur = head, next = cur.next;
             next != null;
             pre = cur, cur = cur.next, next = (cur == null ? null : cur.next)) {

            cur.next = next.next;
            next.next = cur;
            pre.next = next;
        }

        return dummy.next;
    }
}

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * <p>
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            boolean dup = false;
            while (cur.next != null && cur.next.val == cur.val) {
                dup = true;
                cur = cur.next;
            }
            if (dup) {
                cur = cur.next;
                continue;
            }
            pre.next = cur;
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = cur;

        return dummy.next;
    }
}

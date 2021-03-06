/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * <p>
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * <p>
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * <p>
 * Only constant memory is allowed.
 * <p>
 * For example,
 * Given this linked list: 1->2->3->4->5
 * <p>
 * For k = 2, you should return: 2->1->4->3->5
 * <p>
 * For k = 3, you should return: 3->2->1->4->5
 * <p>
 * 思路：借助于 Swap Nodes in Pairs 的思路
 * 不同之处在于，处理中间 k 个链表的反转，将其单独定义函数
 * 定义函数时，该函数反转后，末尾为null，因此反转后需要将下一组的头结点赋给反转后的尾节点
 */
/**
 思路：借助于 Swap Nodes in Pairs 的思路
 不同之处在于，处理中间 k 个链表的反转，将其单独定义函数
 定义函数时，该函数反转后，末尾为null，因此反转后需要将下一组的头结点赋给反转后的尾节点
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k < 2)
            return head;

        ListNode newHead = new ListNode(0);
        newHead.next = head;

        ListNode temp = null;
        for (ListNode pre = newHead, cur = head, next = cur;
             next != null;
             pre = cur, cur = cur.next, next = cur) {

            for (int i = 1; i < k; i++) {
                next = next.next;
                if (next == null)
                    return newHead.next;
            }

            temp = next.next;                 //缓存下一组的头结点
            pre.next = reverseList(cur, k);
            cur.next = temp;                  //将下一组的头结点赋给该组反转后的尾节点的next
        }

        return newHead.next;
    }

    //反转链表，反转后链表末尾为null
    public ListNode reverseList(ListNode head, int k) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp = null;
        for (int i = 0; i < k; i++) {
            temp = cur;
            cur = cur.next;
            temp.next = pre;
            pre = temp;
        }

        return pre;
    }
}

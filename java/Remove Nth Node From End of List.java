/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 * <p>
 * For example,
 * <p>
 * Given linked list: 1->2->3->4->5, and n = 2.
 * <p>
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 * <p>
 * 采用两个指针，开始均指向头结点；
 * 先让一个指针front前进n步：1.如果front为null了，说明删除的是头结点，直接返回head.next；
 * 2.如果front不为null，让两个指针同时移动，当front到达链表末尾时，
 * rear指针到达待删除节点的上一个节点，将rear.next.next赋给rear.next；
 */
/**
 采用两个指针，开始均指向头结点；
 先让一个指针front前进n步：1.如果front为null了，说明删除的是头结点，直接返回head.next；
 2.如果front不为null，让两个指针同时移动，当front到达链表末尾时，
 rear指针到达待删除节点的上一个节点，将rear.next.next赋给rear.next；
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) return null;

        ListNode front = head;
        ListNode rear = head;
        for (int i = 0; i < n; i++) {
            if (front == null)
                return head;
            front = front.next;
        }

        if (front == null) return head.next;

        while (front.next != null) {
            front = front.next;
            rear = rear.next;
        }

        rear.next = rear.next.next;

        return head;
    }
}

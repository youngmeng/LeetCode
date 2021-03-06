/**
 * Given a singly linked list, determine if it is a palindrome.
 * <p>
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 * <p>
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

import java.util.Stack;

public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;

        Stack<Integer> stack = new Stack<Integer>();
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null)//链表为奇数个节点，跳过中间节点
            slow = slow.next;

        while (!stack.empty()) {
            int temp = stack.pop();
            if (temp != slow.val)
                return false;
            slow = slow.next;
        }

        return true;
    }
}

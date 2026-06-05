/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode end = head;
        ListNode toRem = head;
        ListNode prev = null;

        for (int i = 0; i < n; i++) {
            end = end.next;
        }

        while (end!=null) {
            prev = toRem;
            toRem = toRem.next;
            end = end.next;
        }

        if (toRem==head) head = head.next;
        else {
            prev.next = toRem.next;
        }
        return head;
    }
}

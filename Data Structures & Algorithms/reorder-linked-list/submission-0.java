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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast!=null&&fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode second = slow.next; 
        ListNode prev = null;
        slow.next = null;

        while (second!=null) {
            ListNode next = second.next;
            second.next = prev; 
            prev = second;
            second = next;
        }
        ListNode curr = head; 
        second = prev;
        while (second!=null) {
            ListNode next = curr.next;
            ListNode secondNext = second.next;

            curr.next = second;
            second.next = next;

            curr = next;
            second = secondNext;
        }
        
    }
}

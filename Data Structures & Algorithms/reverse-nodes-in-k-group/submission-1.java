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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode nextList = head;
        ListNode prevTail = dummy;
        while (nextList!=null) {
            ListNode prevHead = nextList;
            ListNode temp = nextList;
            ListNode curr = nextList;
            // finding if more reversal should happen
            for (int i = 0; i < k; i++){
                if (temp!=null) temp = temp.next;
                else return dummy.next;
            }
            System.out.println(prevHead.val + " " + prevTail.val);
            
            nextList = temp;

            // reversing the nodes
            ListNode prev = null;
            ListNode next = null;
            for (int i = 0; i < k; i++) {
                System.out.println(curr.val);
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            
            prevTail.next = prev;
            prevTail = prevHead;
            
            prevHead.next = nextList;
        }
        return dummy.next;
    }
}

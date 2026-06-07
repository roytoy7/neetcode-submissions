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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;

        while (l1!=null||l2!=null||carry!=0) {
            int l1val = (l1==null) ? 0 : l1.val;
            int l2val = (l2==null) ? 0 : l2.val;

            int sum = (l1val + l2val + carry)%10;
            carry = (l1val + l2val + carry)/10;

            curr.next = new ListNode(sum);
            curr = curr.next;

            if (l1!=null) l1 = l1.next;
            if (l2!=null) l2 = l2.next;
        }
        
        return dummy.next;
    }
}

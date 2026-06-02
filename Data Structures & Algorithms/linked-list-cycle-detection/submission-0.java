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
    public boolean hasCycle(ListNode head) {
        ListNode curr = head;
        HashSet<ListNode> h = new HashSet<>();
        while (curr!=null) {
            if (!h.isEmpty()&&h.contains(curr)) return true;
            else {
                h.add(curr);
                curr = curr.next;
            }
        }
        return false;
        
    }
}

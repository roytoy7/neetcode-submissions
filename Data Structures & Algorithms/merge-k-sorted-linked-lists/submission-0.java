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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length==0) return null;
        for (int i = 1; i < lists.length; i++) {
            lists[i] = mergeTwoLists(lists[i], lists[i-1]);
        }
        return lists[lists.length-1];
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode list = new ListNode(0); 
        ListNode curr = list;
        while (l1!=null&&l2!=null) {
            ListNode n = null;
            if (l1.val <= l2.val) {
                n = new ListNode(l1.val);
                l1 = l1.next;
            }
            else {
                n = new ListNode(l2.val);
                l2 = l2.next;
            }
            curr.next = n;
            curr = n;
        }
        curr.next = (l1!=null) ? l1 : l2;
        return list.next;
    }
}

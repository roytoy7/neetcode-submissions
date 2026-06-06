/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head==null) return null;

        HashMap<Node, Node> copies = new HashMap<>();
        Node curr = head;
        while (curr!=null) {
            Node curr2 = new Node(curr.val);
            copies.put(curr, curr2);
            curr = curr.next;
        }

        curr = head;
        while (curr!=null) {
            copies.get(curr).next = copies.get(curr.next);
            if (curr.random!=null) {
                copies.get(curr).random = copies.get(curr.random);
            }
            curr = curr.next;
        }

        return copies.get(head);
    }
}

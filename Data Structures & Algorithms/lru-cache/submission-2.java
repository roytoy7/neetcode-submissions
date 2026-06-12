class LRUCache {
    
    class Node {
        int key, value;
        Node prev, next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int capacity;
    HashMap<Integer, Node> hm;
    Node left;
    Node right;

    public LRUCache(int capacity) {
        hm = new HashMap<>();
        this.capacity = capacity;

        left = new Node(0,0);
        right = new Node(0,0);

        left.next = right;
        right.prev = left;
    }
    
    private void insert(Node node) {
        Node prev = right.prev;
        
        prev.next = node;
        node.prev = prev;

        node.next = right;
        right.prev = node;
    }

    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    public int get(int key) {
        if (hm.containsKey(key)) {
            Node node = hm.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
        else return -1;   
    }
    
    public void put(int key, int value) {
        if (hm.containsKey(key)) {
            remove(hm.get(key));
        } 
        Node node = new Node(key, value);
        hm.put(key, node);
        insert(node);

        if (hm.size()>capacity) {
            Node n = left.next;
            remove(n);
            hm.remove(n.key);
        }

    }
}

class PrefixTree {
    Node root;

    private class Node {
        char c; 
        boolean endWord = false;
        HashMap<Character, Node> hm;

        private Node(char c) {
            this.c = c;
            hm = new HashMap<>();
        }
    }

    public PrefixTree() {
        root = new Node(' ');
    }

    public void insert(String word) {
        Node curr = root;
        boolean finding = true;

        for (int i = 0; i < word.length(); i++) {
            if (finding) if (!curr.hm.containsKey(word.charAt(i))) finding = false;
            if (!finding) curr.hm.put(word.charAt(i), new Node(word.charAt(i)));
            
            curr = curr.hm.get(word.charAt(i));
        }
        curr.endWord = true;
    }

    public boolean search(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            if (curr.hm.containsKey(word.charAt(i))) {
                curr = curr.hm.get(word.charAt(i));
            } else return false;
        }
        if (curr.endWord) return true;
        return false;
    }

    public boolean startsWith(String prefix) {
        Node curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (curr.hm.containsKey(prefix.charAt(i))) {
                curr = curr.hm.get(prefix.charAt(i));
            } else return false;
        }
        return true;
    }
}

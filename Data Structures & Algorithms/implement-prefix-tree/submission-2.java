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

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!curr.hm.containsKey(ch)) {
                curr.hm.put(ch, new Node(ch));
            }
            curr = curr.hm.get(word.charAt(i));
        }
        curr.endWord = true;
    }

    public boolean search(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (curr.hm.containsKey(ch)) {
                curr = curr.hm.get(ch);
            } else return false;
        }
        return curr.endWord;
    }

    public boolean startsWith(String prefix) {
        Node curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (curr.hm.containsKey(ch)) {
                curr = curr.hm.get(ch);
            } else return false;
        }
        return true;
    }
}

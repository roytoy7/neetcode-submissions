class WordDictionary {
    Node root = null;

    private class Node {
        char c;
        HashMap<Character, Node> hm;
        boolean endOfWord = false;
        private Node(char c) {
            this.c = c;
            hm = new HashMap<>();
        }
    }
    public WordDictionary() {
        root = new Node(' ');
    }

    public void addWord(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!curr.hm.containsKey(ch)) {
                curr.hm.put(ch, new Node(ch));
            }
            curr = curr.hm.get(ch);
        }
        curr.endOfWord = true;
    }

    public boolean search(String word) {
       return search(word, root, 0);
    }

    public boolean search(String word, Node curr, int i) {
        if (i==word.length()) return curr.endOfWord;

        char ch = word.charAt(i);

        if (ch=='.') {
            for (Node next : curr.hm.values()) {
                if (search(word, next, i+1)) return true;
            }
            return false;
        }

        else if (!curr.hm.containsKey(ch)) return false;
        
        return search(word, curr.hm.get(ch), i+1);

    }
}

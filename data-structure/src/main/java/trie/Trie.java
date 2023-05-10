package trie;

public class Trie {

    public static int alphabetSize = 128;
    public Node root;

    public Trie() {
        this.root = new Node();
    }

    public void insert(String word) {
        Node node = root;
        for (char symbol : word.toCharArray()) {
            node = node.next(symbol);
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Node node = go(word);
        if (node == null) {
            return false;
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return go(prefix) != null;
    }

    public Node go(String word) {
        Node node = root;
        for (char symbol : word.toCharArray()) {
            if (node.exists(symbol)) {
                node = node.next(symbol);
            } else {
                return null;
            }
        }
        return node;
    }
}

class Node {
    public Node[] child;
    public boolean isEnd;

    public Node() {
        //26 - english alphabet size
        this.child = new Node[Trie.alphabetSize];
        this.isEnd = false;
    }

    public Node next(char c) {
        if (!exists(c)) {
            child[c] = new Node();
        }
        return child[c];
    }

    public boolean exists(char c) {
        return child[c] != null;
    }
}



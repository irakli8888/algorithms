package aho_carasick;

import java.util.*;

public class AhoCarasick {

    private final TrieNode root;
    private final List<String> patterns;

    public AhoCarasick(List<String> patterns) {
        this.root = new TrieNode("");
        this.patterns = patterns;
        buildTrie();
        buildSuffixTrie();
    }

    private void buildTrie() {
        for (String pattern : patterns) {
            TrieNode trieNode = root;
            String prefix = "";
            for (char c : pattern.toCharArray()) {
                prefix += c;
                if(!trieNode.child.containsKey(c)){
                    trieNode.child.put(c, new TrieNode(prefix));
                }
                trieNode = trieNode.child.get(c);
            }
            trieNode.pattern = pattern;
        }
    }

    private void buildSuffixTrie() {
        Queue<TrieNode> queue = new ArrayDeque<>();

        for (TrieNode node : root.child.values()) {
            queue.add(node);
            node.suffixLink = root;
        }

        while (!queue.isEmpty()) {
            TrieNode node = queue.poll();
            for (char c : node.child.keySet()){

                TrieNode child = node.child.get(c);
                queue.add(child);

                TrieNode suffixLink = node.suffixLink;
                while (suffixLink != null &&
                        !suffixLink.child.containsKey(c)) {
                    suffixLink = suffixLink.suffixLink;
                }

                child.suffixLink = suffixLink != null ? suffixLink.child.get(c) : root;

                child.finalLink = child.suffixLink.pattern != null ? child.suffixLink : child.suffixLink.finalLink;
            }
        }
    }

    public List<String> findMatches(String text) {
        List<String> matches = new ArrayList<>();
        TrieNode node = root;

        for (char c : text.toCharArray()) {
            while (node != null && !node.child.containsKey(c)) {
                node = node.suffixLink;
            }

            if(node == null) {
                node = root;
                continue;
            }

            node = node.child.get(c);
            if(node.pattern != null) {
                matches.add(node.pattern);
            }

            TrieNode finals = node.finalLink;

            while (finals != null) {
                matches.add(finals.pattern);
                finals = finals.finalLink;
            }
        }
        return matches;
    }


    class TrieNode {

        public String pattern;
        public TrieNode suffixLink;
        public TrieNode finalLink;
        public Map<Character, TrieNode> child = new HashMap<>();
        public String prefix;

        public TrieNode(){}

        public TrieNode(String prefix) {
            this.prefix = prefix;
        }

        @Override
        public String toString() {
            return "TrieNode {" +
                    "prefix='" + prefix + '\'' +
                    '}';
        }
    }
}

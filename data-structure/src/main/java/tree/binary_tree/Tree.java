package tree.binary_tree;

public interface Tree <K> {
    void insert(Node x);
    Node search(K x);
    void remove(K x);
    void traverseInOrder();
}

package tree.binary_tree;

import java.util.LinkedList;
import java.util.Objects;

/**
 * Класс описывающий ноду нашего дерева
 * @param <K> ключ
 * @param <V> значение
 */
public class Node <K , V> {

    private Node parent;
    private Node left;
    private Node right;
    private K key;
    private LinkedList<V> values = new LinkedList<>();
    int height;

    public Node(K key, V value) {
        this.key = key;
        this.values.add(value);
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public LinkedList<V> getValues() {
        return values;
    }

    public void setValues(LinkedList<V> values) {
        this.values = values;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?, ?> node = (Node<?, ?>) o;
        return height == node.height && Objects.equals(parent, node.parent) && Objects.equals(left, node.left) && Objects.equals(right, node.right) && Objects.equals(key, node.key) && Objects.equals(values, node.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parent, left, right, key, values, height);
    }

    @Override
    public String toString() {
        return "Node{" +
                "parent=" + parent +
                ", left=" + left +
                ", right=" + right +
                ", key=" + key +
                ", values=" + values +
                ", height=" + height +
                '}';
    }
}

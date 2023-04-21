package tree.binary_tree;

import java.util.Comparator;

/**
 * Бинарное дерево поиска
 * @param <K> ключ
 * @param <V> значение
 */
public class BinaryTree<K, V> implements Tree<K> {

    private Node rootNode;
    private final Comparator<? super K> comparator;

    public BinaryTree(Comparator<? super K> comparator) {
        this.comparator = comparator;
        rootNode = null;
    }

    /**
     * вставка элемента в дерево
     *
     * @param x ноды для вставки
     */
    @Override
    public void insert(Node x) {
        rootNode = insertRecursive(rootNode, x);
    }

    /**
     * рекурсивный метод для поиска места и вставки в дерево
     *
     * @param current сравниваемая нода
     * @param node    нода для вставки
     * @return нода с потомками
     */
    private Node insertRecursive(Node current, Node node) {
        if (current == null) {
            return node;
        }
        if (comparator.compare((K) current.getKey(), (K) node.getKey()) == 1) {
            current.setLeft(insertRecursive(current.getLeft(), node));
        } else if (comparator.compare((K) current.getKey(), (K) node.getKey()) == -1) {
            current.setRight(insertRecursive(current.getRight(), node));
        } else {
            return current;
        }
        return current;
    }


    /**
     * метод для поиска ноды
     *
     * @param key ключ искомой ноды
     * @return найденная нода
     */
    @Override
    public Node search(K key) {
        return searchRecursive(rootNode, key);
    }

    private Node searchRecursive(Node current, K key) {
        if (current == null) {
            return null;
        }
        if (comparator.compare((K) current.getKey(), (K) key) == 0) {
            return current;
        }
        return (comparator.compare((K) current.getKey(), (K) key) == -1)
                ? searchRecursive(current.getRight(), key)
                : searchRecursive(current.getLeft(), key);
    }


    @Override
    public void remove(K key) {
       rootNode =  deleteRecursive(rootNode, key);
    }

    private Node deleteRecursive(Node current, K key) {
        if (current == null) {
            return null;
        }

        if (comparator.compare((K) current.getKey(), (K) key) == 0) {
            //узел является листовым узлом
            if (current.getLeft() == null && current.getRight() == null) {
                return null;
            }

            //у узла есть один дочерний элемент
            if (current.getRight() == null) {
                return current.getLeft();
            }

            if (current.getLeft() == null) {
                return current.getRight();
            }
            //узел имеет двух детей
            Node smallestValue = findSmallestValue(current.getRight());
            current = smallestValue;
            current.setRight(deleteRecursive(current.getRight(),(K) smallestValue.getKey()));
            return current;
        }

        if (comparator.compare((K) current.getKey(), (K) key) == 1) {
            current.setLeft(deleteRecursive(current.getLeft(), key));
            return current;
        }
        current.setRight(deleteRecursive(current.getRight(), key));
        return current;
    }


    private Node findSmallestValue(Node root) {
        return root.getLeft() == null ?  root : findSmallestValue(root.getLeft());
    }

    /**
     * обход по порядку
     */
    @Override
    public void traverseInOrder() {
        traverse(rootNode);
    }

    private void traverse(Node node) {
        if (node != null) {
            traverse(node.getLeft());
            System.out.print(" " + node.getKey());
            traverse(node.getRight());
        }
    }
}

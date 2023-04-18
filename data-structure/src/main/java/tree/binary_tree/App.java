package tree.binary_tree;

import java.util.Comparator;

public class App {
    public static void main(String[] args) {

        //инициализация
        Tree<Integer> bt = new BinaryTree<Integer, Integer>(Comparator.comparingInt(integer -> integer.intValue()));
        //добавление в дерево
        bt.insert(new Node(7, 41));
        bt.insert(new Node(5, 42));
        bt.insert(new Node(8, 43));
        bt.insert(new Node(2, 44));
        bt.insert(new Node(23, 46));
        bt.insert(new Node(31, 46));
        bt.insert(new Node(13, 48));

        //поиск
        System.out.println(bt.search(31));

        //удаление
        bt.remove(5);

        //проход по элементам
        bt.traverseInOrder();

    }
}

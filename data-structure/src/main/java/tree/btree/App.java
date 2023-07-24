package tree.btree;

import java.util.Random;
import java.util.Scanner;

public class App {
    private static final Random RANDOM = new Random();
    public  static String help = "Здравствуйте, вот доступные команды для управления бинарными деревьями:\n" +
            "\n" +
            "\"toCollection\": Преобразование бинарного дерева в коллекцию.\n" +
            "\"remove\": Удаление элемента из дерева. После ввода возможного ввода числового элемента.\n" +
            "\"contains\": Проверка наличия элемента в дереве.\n" +
            "\"size\": Выводит количество элементов в дереве.\n" +
            "\"clear\": Очистка всего дерева. В ответ вы получите обновление\n" +
            "\"add\": Добавление элемента\n" +
            "\"sout\": Вывод дерева в консоль.\n" +
            "\"q\": Завершение работы с деревом.\n" +
            "Введите 'help' для отображения списка команд.";

    public static void main(String[] args) {
        BTree<Integer> bTree = new BTree<>();
        for(int i = 0; i < 25; i++){
            bTree.add(RANDOM.nextInt(10_000_000 - 1) + 1);

        }
        System.out.println(help);
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.print("Введите команду: ");
            String[] command = scanner.nextLine().split(" ");
            switch (command[0]) {
                case "toCollection":
                    bTree.toCollection().forEach(integer -> System.out.println(integer));
                    break;
                case "remove":
                    bTree.remove(Integer.valueOf(command[1]));
                    System.out.println(bTree.toString());
                    break;
                case "contains":
                    System.out.println(bTree.contains(Integer.valueOf(command[1])));
                    break;
                case "size":
                    System.out.println(bTree.size());
                    break;
                case "clear":
                    bTree.clear();
                    System.out.println(bTree.toString());
                    break;
                case "add":
                    bTree.add(Integer.valueOf(command[1]));
                    System.out.println(bTree.toString());
                    break;
                case "sout":
                    System.out.println(bTree.toString());
                    break;
                case "q":
                    isRunning = false;
                    break;
                case "help":
                    System.out.println(help);
                    break;
                default:
                    System.out.println("Неизвестная команда. Введите 'help' для отображения списка команд.");
                    break;
            }
        }
        scanner.close();
    }
}

package quick_sort;

import sort.Sort;

/**
 * делим массив на 3 части:
 * <br> 1. больше опоры
 * <br> 2. меньше опоры
 * <br> 3. неотсортированный
 * <br> опорный элемент prop = array[r] - где r - самый правый (послдений элемент массива)
 * <br> j - первый элемент неотсортиорованной части
 * <br> m - последний элемент части массива, что  меньше опоры
 * <br> алгоритм крайне не эффективен в уже отсортированных массивах и в массивах, содержащих множество одинаковых элементов
 * <br> сложность квазилинейная O(n\log n)
 * <br> <a href="https://www.geeksforgeeks.org/quick-sort/">ознакомление</a>
 */
public class QuickSort implements Sort {

    int[] array;

    public QuickSort(int[] array) {
        this.array = array;
    }

    @Override
    public int[] sort() {
        qsort(0, array.length - 1);
        return array;
    }

    //левая и правая границы
    public void qsort(int l, int r) {
        //точка выхода из рекурсии
        if (l >= r) {
            return;
        }
        //середина
        int middle = split(l, r);
        //сортировка для левой части
        qsort(l, middle - 1);
        //сортировка для правой части
        qsort(middle + 1, r);
    }

    private int split(int l, int r) {
//        точка опоры
        int prop = array[r];
//        указатель на последний элемент в первой части массива
        int m = l - 1;
//        перебор элементов от левой части к правой
        for (int i = l; i <= r; i++) {
            if (array[i] <= prop) {
//        размещаем элемент в левую часть массива(где лежат элементы, что меньше опоры)
                swap(++m, i);
            }
        }
        return m;
    }

    @Override
    public void swap(int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
}

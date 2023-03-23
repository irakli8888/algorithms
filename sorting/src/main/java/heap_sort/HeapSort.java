package heap_sort;


import sort.Sort;

/**
 * HeapSort. В основе лежит алгоритм сортировки выбором, используется структура данных «куча» для
 * быстрого нахождения максимального элемента, а также способ хранения двоичного дерева в линейном массиве.
 */
public class HeapSort implements Sort {

    int[] array;

    public HeapSort(int[] array) {
        this.array = array;
    }

    /**
     * квазилинейная сложность O(N log2 N)
     * @return
     */
    @Override
    public int[] sort() {
        //составляем дерево
        for (int h = array.length / 2 - 1; h >= 0; h--) {
            heapify(h, array.length);
        }
        for (int i = array.length - 1; i > 0; i--) {
            swap(0, i);
            heapify(0, i);
        }
        return array;
    }

    /**
     * Поднимаем наибольший элемент в корень
     * @param root
     * @param length
     */
    private void heapify(int root, int length) {
        int x = root;
        //ищем левый элемент от корня
        int l = 2 * x + 1;
        //ищем правый элемент от корня
        int r = 2 * x + 2;
        if(l < length && array[l] > array[x]){
            x = l;
        }
        if(r < length && array[r] > array[x]){
            x = r;
        }
        if(x == root){
            return;
        }
        swap(root, x);
        heapify(x, length);
    }

    @Override
    public void swap(int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
}

package insertion_sort;

import sort.Sort;
import sort.SortShift;
import sort.SortWithBinarySerach;

/**
 * Сортировка вставками (Insertion Sort).
 * Суть алгоритма заключается в том что, на каждом шаге алгоритма мы берем один из элементов массива,
 * находим позицию для вставки и вставляем. Массив из 1-го элемента считается отсортированным
 */
public class InsertionSort implements Sort, SortShift, SortWithBinarySerach {

    int[] array;

    public InsertionSort(int[] array) {
        this.array = array;
    }

    /**
     * Insertion sort - сортировка вставкой
     *<br> время работы - O(n^2)
     *<br> затраты по памяти - 1
     *<br> кол-во обменов - <= 3 * ((n^2 - n)/2), тк 3 операции присвоения в методе swap(int x, int y)
     *<br> операции сравнения - < (n^2 - n)/2
     *<br> стабильный +
     *<br> адаптивный +
     *<br> онлайн алгоритм +
     *
     * @return отсортированный массив
     */
    @Override
    public int[] sort() {
        for (int i = 1; i < array.length; i++) {
            for (int j = i - 1; j >= 0 && array[j] > array[j + 1]; j--) {
                swap(j, j + 1);
            }
        }
        return array;
    }

    /**
     * первая оптимизация Insertion sort:
     * уменьшаем кол-во операций присваивания
     * путем сдвига элементов вместо обмена
     *<br>
     *<br> время работы - O(n^2)
     *<br> затраты по памяти - 1
     *<br> кол-во обменов - <= ((n^2 - n)/2)
     *<br> операции сравнения - < (n^2 - n)/2
     *<br> стабильный +
     *<br> адаптивный +
     *<br> онлайн алгоритм +
     * @return отсортированный массив
     */
    @Override
    public int[] sortShift() {
        int j;
        for (int i = 1; i < array.length; i++) {
            int mem = array[i];
            for (j = i - 1; j >= 0 && array[j] > mem; j--) {
                array[j + 1] = array[j];
            }
                array[j + 1] = mem;

        }
        return array;
    }


    /**
     * вторая оптимизация Insertion sort:
     *<br> ускоряем проход по элементам, благодаря бинарному поиску
     *<br>
     *<br> время работы - O(n^2)
     *<br> затраты по памяти - 1
     *<br> кол-во обменов - <= ((n^2 - n)/2)
     *<br> операции сравнения - < (n^2 - n)/2
     *<br> стабильный +
     *<br> адаптивный +
     *<br> онлайн алгоритм +
     * @return отсортированный массив
     */
    //toDO описание, самостоятельная реализация
    @Override
    public int[] sortWithBinarySearch() {
        int j;
        for (int i = 1; i < array.length; i++) {
            int mem = array[i];
            int b = binarySearch(mem, 0, i - 1);
            for (j = i - 1; j >= b; j--) {
                array[j + 1] = array[j];
            }
            array[j + 1] = mem;

        }
        return array;
    }

    private int binarySearch(int key, int lowIndex, int highIndex) {
        if(highIndex <= lowIndex) {
            if (key > array[lowIndex]) {
                return lowIndex + 1;
            } else return lowIndex;
        }
        int mid = (lowIndex + (highIndex - 1)) / 2;
        if(key > array[mid]) {
            return binarySearch(key, mid + 1, highIndex);
        } else
            return binarySearch(key, lowIndex, mid - 1);
    }

    @Override
    public void swap(int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
}

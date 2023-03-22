package selection_sort;

import sort.Sort;

/**
 * Сортировка выбором.
 *<br> 1. В неотсортированном подмассиве ищется локальный максимум (минимум).
 *<br> 2. Найденный максимум (минимум) меняется местами с последним (первым) элементом в подмассиве.
 *<br> 3. Если в массиве остались неотсортированные подмассивы — смотри пункт 1
 */
public class SelectionSort implements Sort {
    int[] array;

    public SelectionSort(int[] array) {
        this.array = array;
    }

    /**
     *<br> время работы - O(n^2)
     *<br> затраты по памяти - 1
     *<br> кол-во обменов - ((n^2 - n)/2)
     *<br> операции сравнения - 3N
     *<br> стабильный -
     *<br> адаптивный -
     *<br> онлайн алгоритм -
     * @return отсортированный массив
     */
    @Override
    public int[] sort() {
        for (int i = array.length - 1; i > 0; i--) {
            swap(findMax(i), i);
        }
        return array;
    }

    /**
     * поиск макимального элемента в неотсортированной части
     * @param i
     * @return индекс макисмального элемента в неотсортированной части
     */
    private int findMax(int i) {
        int max = 0;
        for (int j = 1; j <= i; j++) {
            if(array[j] > array[max]) {
                max = i;
            }
        }
        return max;
    }

    @Override
    public void swap(int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
}

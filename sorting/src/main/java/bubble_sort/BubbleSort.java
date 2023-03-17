package bubble_sort;

import sort.Sort;

public class BubbleSort implements Sort {

    int[] array;

    public BubbleSort(int[] array) {
        this.array = array;
    }

    /**
     * Bubble sort
     *<br> ����� ������ - O(n^2)
     *<br> ������� �� ������ - 1
     *<br> ���-�� ������� - 3 * ((n^2 - n)/2), �� 3 �������� ���������� � ������ swap(int x, int y)
     *<br> �������� ��������� - (n^2 - n)/2
     *<br> ���������� +
     *<br> ���������� -
     *<br> ������ �������� -
     * @return ��������������� ������
     */
    @Override
    public int[] sort() {
        int size = array.length;
        for (int i = size - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if(array[j] > array[j + 1]){
                    swap(j,j + 1);
                }
            }
        }
        return this.array;
    }

    @Override
    public void swap(int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
}

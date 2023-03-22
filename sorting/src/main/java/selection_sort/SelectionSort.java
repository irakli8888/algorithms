package selection_sort;

import sort.Sort;

/**
 * ���������� �������.
 *<br> 1. � ����������������� ���������� ������ ��������� �������� (�������).
 *<br> 2. ��������� �������� (�������) �������� ������� � ��������� (������) ��������� � ����������.
 *<br> 3. ���� � ������� �������� ����������������� ���������� � ������ ����� 1
 */
public class SelectionSort implements Sort {
    int[] array;

    public SelectionSort(int[] array) {
        this.array = array;
    }

    /**
     *<br> ����� ������ - O(n^2)
     *<br> ������� �� ������ - 1
     *<br> ���-�� ������� - ((n^2 - n)/2)
     *<br> �������� ��������� - 3N
     *<br> ���������� -
     *<br> ���������� -
     *<br> ������ �������� -
     * @return ��������������� ������
     */
    @Override
    public int[] sort() {
        for (int i = array.length - 1; i > 0; i--) {
            swap(findMax(i), i);
        }
        return array;
    }

    /**
     * ����� ������������ �������� � ����������������� �����
     * @param i
     * @return ������ ������������� �������� � ����������������� �����
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

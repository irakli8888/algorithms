package insertion_sort;

import sort.Sort;
import sort.SortShift;
import sort.SortWithBinarySerach;

/**
 * ���������� ��������� (Insertion Sort).
 * ���� ��������� ����������� � ��� ���, �� ������ ���� ��������� �� ����� ���� �� ��������� �������,
 * ������� ������� ��� ������� � ���������. ������ �� 1-�� �������� ��������� ���������������
 */
public class InsertionSort implements Sort, SortShift, SortWithBinarySerach {

    int[] array;

    public InsertionSort(int[] array) {
        this.array = array;
    }

    /**
     * Insertion sort - ���������� ��������
     *<br> ����� ������ - O(n^2)
     *<br> ������� �� ������ - 1
     *<br> ���-�� ������� - <= 3 * ((n^2 - n)/2), �� 3 �������� ���������� � ������ swap(int x, int y)
     *<br> �������� ��������� - < (n^2 - n)/2
     *<br> ���������� +
     *<br> ���������� +
     *<br> ������ �������� +
     *
     * @return ��������������� ������
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
     * ������ ����������� Insertion sort:
     * ��������� ���-�� �������� ������������
     * ����� ������ ��������� ������ ������
     *<br>
     *<br> ����� ������ - O(n^2)
     *<br> ������� �� ������ - 1
     *<br> ���-�� ������� - <= ((n^2 - n)/2)
     *<br> �������� ��������� - < (n^2 - n)/2
     *<br> ���������� +
     *<br> ���������� +
     *<br> ������ �������� +
     * @return ��������������� ������
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
     * ������ ����������� Insertion sort:
     *<br> �������� ������ �� ���������, ��������� ��������� ������
     *<br>
     *<br> ����� ������ - O(n^2)
     *<br> ������� �� ������ - 1
     *<br> ���-�� ������� - <= ((n^2 - n)/2)
     *<br> �������� ��������� - < (n^2 - n)/2
     *<br> ���������� +
     *<br> ���������� +
     *<br> ������ �������� +
     * @return ��������������� ������
     */
    //toDO ��������, ��������������� ����������
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

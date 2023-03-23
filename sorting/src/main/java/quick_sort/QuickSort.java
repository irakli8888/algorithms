package quick_sort;

import sort.Sort;

/**
 * ����� ������ �� 3 �����:
 * <br> 1. ������ �����
 * <br> 2. ������ �����
 * <br> 3. �����������������
 * <br> ������� ������� prop = array[r] - ��� r - ����� ������ (��������� ������� �������)
 * <br> j - ������ ������� ������������������ �����
 * <br> m - ��������� ������� ����� �������, ���  ������ �����
 * <br> �������� ������ �� ���������� � ��� ��������������� �������� � � ��������, ���������� ��������� ���������� ���������
 * <br> ��������� ������������� O(n\log n)
 * <br> <a href="https://www.geeksforgeeks.org/quick-sort/">������������</a>
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

    //����� � ������ �������
    public void qsort(int l, int r) {
        //����� ������ �� ��������
        if (l >= r) {
            return;
        }
        //��������
        int middle = split(l, r);
        //���������� ��� ����� �����
        qsort(l, middle - 1);
        //���������� ��� ������ �����
        qsort(middle + 1, r);
    }

    private int split(int l, int r) {
//        ����� �����
        int prop = array[r];
//        ��������� �� ��������� ������� � ������ ����� �������
        int m = l - 1;
//        ������� ��������� �� ����� ����� � ������
        for (int i = l; i <= r; i++) {
            if (array[i] <= prop) {
//        ��������� ������� � ����� ����� �������(��� ����� ��������, ��� ������ �����)
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

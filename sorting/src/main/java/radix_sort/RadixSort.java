package radix_sort;

import sort.Sort;

import java.util.Arrays;

/**
 * ��������� ���������: O(N)
 *<br> ��������� ������������ ����������: ������� ������������ �������� ������ �������� �������, � �������� ������������
 * �� ����������� ����� ���������, ����� ������������ �������� ���������� �������, ���������, � �������� ���� ���������������
 * �� ����������� ��������� �������� ����� ������� ������ ������������ �� ���������� ������� �����,
 * ���� ������������������� � �����, �� �������� ������������� �������, ����������� ��� ���������� ����������.
 * ����� ���������� �������� ��� ���������� �������, � ��� �� �����.
 *<br> <a href="https://www.cs.usfca.edu/~galles/visualization/RadixSort.html">������������</a>
 */
public class RadixSort implements Sort {

    int[] array;

    public RadixSort(int[] array) {
        this.array = array;
    }

    @Override
    public int[] sort() {
        //������ ��� �������� ����������� ����������(������ �������������� �� ��������� ������������ �������)
        int [] numbers = new int[10];
        //������������ ����� �����
        int length = calculateMaximumLengthNumber();
        //��� �������� ������������ ������� ����� �� ����
        int index = 0;

        while (length > 0) {

            int number = 0;
            //������ ��� ������ �������� ������������ �������
            int [] numberArray = new int[array.length];

            //���������� �� �������, ������� �������� �� ������� �� ������� (index - ��������� �� ������)
            for (int i = 0; i < array.length; i++) {
                //�������� ���������� �����
                String[] numberStr = String.valueOf(array[i]).split("");
                if(numberStr.length > index) {
                    //���� ������� ������ �� ��������� ������ �����, �� ���������� ��� � ������ numberArray
                    //� ����������� ������� ��� number (����� ��������� � ��������)
                    number = Integer.valueOf(numberStr[numberStr.length - index - 1]);
                    numbers[number] = numbers[number] + 1;
                    numberArray[i] = number;
                } else {
                    //���� ������� ������ �������� ������ �����, �� ������� ��� ������ 0
                    numbers[0] = numbers[0] + 1;
                    numberArray[i] = 0;
                }
            }

            //��������� �������� �������� ��� ��������� ���������� � ���,
            //������ �� ����� �������� ����������� �����, ��������������� �������
            for (int i = 0; i < numbers.length - 1; i++) {
                numbers[i + 1] = numbers[i] + numbers[i + 1];
            }

            //������ ��� ������ ����������
            int [] newArr = new int[array.length];

            //���������� �� ��������� ���� �� �������� �������
            //� � ���������� �� ��������� numbers ���������� �������� � ����� ������
            for (int i = numberArray.length - 1; i >= 0; i--) {
                int indexForNumbersArray = numberArray[i];
                numbers[indexForNumbersArray] = numbers[indexForNumbersArray] - 1;
                int indexForArray = numbers[indexForNumbersArray];
                newArr[indexForArray] = array[i];
            }

            //��������������� ������� ������
            array = newArr;
            //���������� ������� � �������������� ���������
            Arrays.fill(numbers, 0);
            //���������� �����������
            index++;
            //��������� �����
            length--;
        }
        return array;
    }

    /**
     * ��������� ������������ ����� �����
     * @return ������������ ����� �����
     */
    private int calculateMaximumLengthNumber() {
        int length = 0;
        for (int i = 0; i < array.length; i++) {
            int elementLength = String.valueOf(array[i]).length();
            if(length <= elementLength) {
                length = elementLength;
            }
        }
        return length;
    }

    @Override
    public void swap(int x, int y) {

    }
}

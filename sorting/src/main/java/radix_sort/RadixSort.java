package radix_sort;

import sort.Sort;

import java.util.Arrays;

/**
 * Сложность алгоритма: O(N)
 *<br> Алгоритм индексной сортировки берет за основу алгоритм сортировки подсчетом
 *<br> Сравнение производится поразрядно: сначала сравниваются значения одного крайнего разряда, и элементы группируются
 * по результатам этого сравнения, затем сравниваются значения следующего разряда, соседнего, и элементы либо упорядочиваются
 * по результатам сравнения значений этого разряда внутри образованных на предыдущем проходе групп,
 * либо переупорядочиваются в целом, но сохраняя относительный порядок, достигнутый при предыдущей сортировке.
 * Затем аналогично делается для следующего разряда, и так до конца.
 * <br> <a href="https://www.cs.usfca.edu/~galles/visualization/RadixSort.html">визуализация</a>
 */
public class RadixSort implements Sort {

    int[] array;

    public RadixSort(int[] array) {
        this.array = array;
    }

    @Override
    public int[] sort() {
        //массив для подсчета колличества совпадений(индекс сопоставляется со значением оперируемого разряда)
        int[] numbers = new int[10];
        //макисмальная длина числа
        int length = calculateMaximumLengthNumber();
        //модуль для получения разряда
        int range = 10;
        //коэфициент для поиска индекса
        int placeValue = 10;
        while (length > 0) {
            int number = 0;
            //массив для записи значений оперируемого разряда
            int[] numberArray = new int[array.length];
            //проходимся по массиву, достаем значение из разряда по порядку (index - указатель на разряд)
            for (int i = 0; i < array.length; i++) {
                //если текущий разряд не превышает разряд числа, то записываем его в массив numberArray
                //и увеличиваем счетчик для number (число совпадает с индексом)
                number = (array[i] / placeValue) % range; //получаем поразрядно число
                numbers[number] = numbers[number] + 1;
                numberArray[i] = number;
            }

            //суммируем соседние счетчики для получения информации о том,
            //вплоть до каких индексов встречается число, соответствующее индексу
            for (int i = 0; i < numbers.length - 1; i++) {
                numbers[i + 1] = numbers[i] + numbers[i + 1];
            }

            //массив для записи результата
            int[] newArr = new int[array.length];

            //проходимся по значением цифр из текущего разряда
            //и в соответвии со счетчиком numbers выставляем значения в новый массив
            for (int i = numberArray.length - 1; i >= 0; i--) {
                int indexForNumbersArray = numberArray[i];
                numbers[indexForNumbersArray] = numbers[indexForNumbersArray] - 1;
                int indexForArray = numbers[indexForNumbersArray];
                newArr[indexForArray] = array[i];
            }

            //переодпределяем текущий массив
            array = newArr;
            //возвращаем счетчик в первоначальное состояние
            Arrays.fill(numbers, 0);
            //уменьшаем длину
            length--;
            //увеличивем коэфициент для поиска индекса
            placeValue *= 10;
        }
        return array;
    }

    /**
     * вычисляем максимальную длину числа
     *
     * @return максимальная длина числа
     */
    private int calculateMaximumLengthNumber() {
        int length = 0;
        for (int i = 0; i < array.length; i++) {
            int elementLength = String.valueOf(array[i]).length();
            if (length <= elementLength) {
                length = elementLength;
            }
        }
        return length;
    }

    @Override
    public void swap(int x, int y) {
    }
}

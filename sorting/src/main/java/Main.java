import bubble_sort.BubbleSort;
import sort.Sort;
import insertion_sort.InsertionSort;
import invocation_handler.TimingDynamicInvocationHandler;
import sort.SortShift;

import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int [] array = new int[10];

        for (int i = 0; i < 10; i++) {
            array[i] = new Random().nextInt(10_000 + 1);
        }

        Sort bubbleSort = (Sort) Proxy.newProxyInstance(
                Sort.class.getClassLoader(),
                new Class[]{Sort.class},
                new TimingDynamicInvocationHandler(new BubbleSort(Arrays.copyOf(array, array.length)))
        );

        Sort insertionSort = (Sort) Proxy.newProxyInstance(
                Sort.class.getClassLoader(),
                new Class[]{Sort.class},
                new TimingDynamicInvocationHandler(new InsertionSort(Arrays.copyOf(array, array.length)))
        );

        SortShift insertionSortShift = (SortShift) Proxy.newProxyInstance(
                        SortShift.class.getClassLoader(),
                        new Class[]{SortShift.class},
                        new TimingDynamicInvocationHandler(new InsertionSort(Arrays.copyOf(array, array.length))));

        bubbleSort.sort();
        insertionSort.sort();
        insertionSortShift.sortShift();
        new InsertionSort(Arrays.copyOf(array, array.length))
                .sortShift();
    }
}

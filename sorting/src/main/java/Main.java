import bubble_sort.BubbleSort;
import heap_sort.HeapSort;
import insertion_sort.InsertionSort;
import invocation_handler.*;
import merge_sort.MergeSort;
import quick_sort.QuickSort;
import selection_sort.SelectionSort;
import shell_sort.ShellSort;
import sort.*;

import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int[] array = new int[100_000];

        for (int i = 0; i < 100_000; i++) {
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

        SortWithBinarySerach insertionBinarySort = (SortWithBinarySerach) Proxy.newProxyInstance(
                SortWithBinarySerach.class.getClassLoader(),
                new Class[]{SortWithBinarySerach.class},
                new TimingDynamicInvocationHandler(new InsertionSort(Arrays.copyOf(array, array.length))));

        SortShift shellSortShift = (SortShift) Proxy.newProxyInstance(
                SortShift.class.getClassLoader(),
                new Class[]{SortShift.class},
                new TimingDynamicInvocationHandler(new ShellSort(Arrays.copyOf(array, array.length))));

        Sort selectionSort = (Sort) Proxy.newProxyInstance(
                Sort.class.getClassLoader(),
                new Class[]{Sort.class},
                new TimingDynamicInvocationHandler(new SelectionSort(Arrays.copyOf(array, array.length)))
        );

        Sort heapSort = (Sort) Proxy.newProxyInstance(
                Sort.class.getClassLoader(),
                new Class[]{Sort.class},
                new TimingDynamicInvocationHandler(new HeapSort(Arrays.copyOf(array, array.length)))
        );

        Sort quickSort = (Sort) Proxy.newProxyInstance(
                Sort.class.getClassLoader(),
                new Class[]{Sort.class},
                new TimingDynamicInvocationHandler(new QuickSort(Arrays.copyOf(array, array.length)))
        );


        Sort mergeSort = (Sort) Proxy.newProxyInstance(
                Sort.class.getClassLoader(),
                new Class[]{Sort.class},
                new TimingDynamicInvocationHandler(new MergeSort(Arrays.copyOf(array, array.length)))
        );

        bubbleSort.sort();
        insertionSort.sort();
        insertionSortShift.sortShift();
        insertionBinarySort.sortWithBinarySearch();
        shellSortShift.sortShift();
        selectionSort.sort();
        heapSort.sort();
        quickSort.sort();
        mergeSort.sort();
    }
}

package shell_sort;

import sort.SortShift;

public class ShellSort implements SortShift {
    int[] array;

    public ShellSort(int[] array) {
        this.array = array;
    }

    @Override
    public int[] sortShift() {
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            int j;
            for (int i = gap; i < array.length; i++) {
                int mem = array[i];
                for (j = i - 1; j >= gap && array[j] > mem; j--) {
                    array[j + 1] = array[j];
                }
                array[j + 1] = mem;
            }
        }
        return new int[0];
    }
}

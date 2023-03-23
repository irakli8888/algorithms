package merge_sort;

import sort.Sort;

public class MergeSort implements Sort {

    int[] array;

    public MergeSort(int[] array) {
        this.array = array;
    }

    @Override
    public int[] sort() {
        return array;
    }

    @Override
    public void swap(int x, int y) {

    }
}

package merge_sort;

import sort.Sort;

public class MergeSort implements Sort {

    int[] array;

    public MergeSort(int[] array) {
        this.array = array;
    }

    @Override
    public int[] sort() {
        mergeSort(0, array.length - 1);
        return array;
    }

    private void mergeSort(int l, int r) {
        if (l >= r) {
            return;
        }
        int middle = (l + r) / 2;
        mergeSort(l, middle);
        mergeSort(middle + 1, r);
        merge(l, middle, r);
    }

    private void merge(int l, int middle, int r) {
        int[] supportArray = new int[r - l + 1];
        int a = l;//левая часть
        int b = middle + 1;//правая часть
        int t = 0;//счетчик для массива supportArray
        while (a <= middle && b <= r) {
            if (array[a] < array[b]) {
                supportArray[t++] = array[a++];
            } else {
                supportArray[t++] = array[b++];
            }
        }
        while (a <= middle) {
            supportArray[t++] = array[a++];
        }
        while (b <= r) {
            supportArray[t++] = array[b++];
        }
        for (int i = l; i <= r; i++){
            array[i] = supportArray[i - l];
        }

    }

    @Override
    public void swap(int x, int y) {

    }
}

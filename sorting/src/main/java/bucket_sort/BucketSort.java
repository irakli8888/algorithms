package bucket_sort;

import sort.Sort;

/**
 * Ведерная сортировка.
 * в основе формула: 0 <=(a[i] * N) / max + 1 >= N - 1
 * <br>сложность в лучшем случае O(N), в худшем O(N^2):
 * <br>N (проход по всем числам и нахождение максимума) + N * K (применение формулы и размещение по бакетам) + N (проход по бакетам)
 */
public class BucketSort implements Sort {

    int[] array;

    public BucketSort(int[] array) {
        this.array = array;
    }

    @Override
    public int[] sort() {
        int max = array[0];
//        выбираем максимальный элемент
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        max++;

        ListForSort[] bucket = new ListForSort[array.length];
        for (int element : array) {
//            вычисляем номер ведра
            int bucketNumber = (element * array.length) / max;
            bucket[bucketNumber] = new ListForSort(element, bucket[bucketNumber]);
            ListForSort listForSort = bucket[bucketNumber];
            while (listForSort.next != null){
                if(listForSort.next.next == null) {
                    break;
                }
                if(listForSort.value >= listForSort.next.value) {
                    int x = listForSort.value;
                    listForSort.next.value = x;
                    listForSort = listForSort.next;
                } else {
                    break;
                }
            }
        }

        int j = 0;
        for (ListForSort listForSort : bucket) {

            while (listForSort != null) {
                array[j++] = listForSort.value;
                listForSort = listForSort.next;
            }
        }
        return array;
    }

    @Override
    public void swap(int x, int y) {

    }

    /**
     * Односвязний список для ведра.
     */
    class ListForSort {
        public int value;
        public ListForSort next;

        public ListForSort(int value, ListForSort next) {
            this.value = value;
            this.next = next;
        }

        public ListForSort(int value) {
            this(value, null);
        }
    }


}

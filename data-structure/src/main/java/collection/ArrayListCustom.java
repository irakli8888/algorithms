package collection;

public class ArrayListCustom<E> extends AbstractListCustom<E> implements ListCustom<E> {

    private final int DEFAULT_SIZE = 10;
    private final int COEFFICIENT = 2;
    private E[] array = (E[]) new Object[DEFAULT_SIZE];
    private int size = 0;


    public ArrayListCustom(E[] array) {
        this.array = array;
    }

    public ArrayListCustom() {
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public boolean add(E e) {
        if (array.length > size) {
            array[size] = e;
        } else {
            while (array.length <= size) {
                grow();
            }
            array[size] = e;
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(o)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public void add(E item, int index) {
        check(index);
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = item;
        size++;
    }

    @Override
    public E remove(int index) {
        check(index);
        E object = array[index];
        int numMoved = size - index - 1;//сколько элементов копируем
        System.arraycopy(array, index + 1, array, index, numMoved);
        array[--size] = null;
        return object;
    }

    @Override
    public E get(int index) {
        check(index);
        return array[index];
    }


    private void grow() {
        E[] newArray = (E[]) new Object[array.length * COEFFICIENT + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    private void check(int index) {
        if (array.length < index) {
            throw new RuntimeException("to large index");
        }
    }

    public E[] getArray() {
        return array;
    }
}

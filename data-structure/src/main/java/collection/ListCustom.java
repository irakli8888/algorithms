package collection;

public interface ListCustom<E> extends CollectionCustom<E>{
    int size();
    boolean add(E e);
    boolean remove(Object o);
    void add(E item, int index);
    E remove(int index);
    E get(int index);
}

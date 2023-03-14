package collection;

public interface CollectionCustom<E>{
    int size();
    boolean add(E e);
    E remove(int index);
}

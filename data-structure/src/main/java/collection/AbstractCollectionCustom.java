package collection;



public abstract class AbstractCollectionCustom<E> implements CollectionCustom<E>{
    public abstract int size();
    public abstract boolean add(E e);
    public abstract boolean remove(Object o);
    public abstract void add(E item, int index);
    public abstract E remove(int index);
}

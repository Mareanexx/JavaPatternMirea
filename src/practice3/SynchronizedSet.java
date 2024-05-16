package practice3;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SynchronizedSet<T> implements Set<T> {
    private final Set<T> myset;

    public SynchronizedSet() {
        this.myset = new HashSet<>();
    }

    @Override
    public synchronized int size() {
        return myset.size();
    }

    @Override
    public synchronized boolean isEmpty() {
        return myset.isEmpty();
    }

    @Override
    public synchronized boolean contains(Object o) {
        return myset.contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        return myset.iterator();
    }

    @Override
    public Object[] toArray() {
        return myset.toArray();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return myset.toArray(a);
    }

    @Override
    public synchronized boolean add(T t) {
        return myset.add(t);
    }

    @Override
    public synchronized boolean remove(Object o) {
        return myset.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return myset.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return myset.addAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return myset.retainAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return myset.removeAll(c);
    }

    @Override
    public synchronized void clear() {
        myset.clear();
    }
}

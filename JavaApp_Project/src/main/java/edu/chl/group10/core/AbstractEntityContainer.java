package edu.chl.group10.core;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractEntityContainer<T extends IEntity<K>, K> implements IEntityContainer<T, K> {

    private List<T> elems = new ArrayList<>();

    @Override
    public void add(T t) {
        if (t == null) {
            throw new IllegalArgumentException("Nulls not allowed");
        }
        elems.add(t); 
    }

    @Override
    public void remove(K id) {
        T t = find(id);
        if (t != null) {
            elems.remove(t);
        }
    }

    @Override
    public void update(T t) {
        T old = find(t.getPnumb());
        if (t != null) {
            elems.remove(old);
            elems.add(t);
        }
    }

    @Override
    public T find(K id) {    
        for (T t : elems) {
            if (t.getPnumb().equals(id)) { // NOTE: equals, not ==
                return t;
            }
        }
        return null;
    }

    @Override
    public List<T> getAll() {
        return elems;
    }

    @Override
    public List<T> getRange( int firstResult, int maxResults) {
        return elems.subList(firstResult, firstResult + maxResults );
    }

    @Override
    public int getCount() {
        return elems.size();
    }
}

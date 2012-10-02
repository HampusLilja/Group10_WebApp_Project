package edu.chl.group10.core;

import java.util.List;

public interface IEntityContainer<T extends IEntity<K>, K> {

    public void add(T t);

    public void remove(K id);

    public void update(T t);

    public T find(K id);

    public List<T> getAll();

    public List<T> getRange(int maxResults, int firstResult);

    public int getCount();
}

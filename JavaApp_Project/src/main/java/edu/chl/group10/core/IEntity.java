package edu.chl.group10.core;

import java.io.Serializable;

public interface IEntity<K> extends Serializable {
    public K getPnumb();
}

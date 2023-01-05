package org.dragonstudio.JPlist.DataType;

public interface NSCollection extends Iterable<NSObject> {
    int size();

    boolean isEmpty();

    void add(NSObject object);

}

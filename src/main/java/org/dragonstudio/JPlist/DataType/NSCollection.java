/**
 * This class called NSCollection is the parent class for NSDict & NSArray.
 * Base class.
 *
 * @author SYSTEM-QEMU-PPC
 */

package org.dragonstudio.JPlist.DataType;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class NSCollection extends NSObject<List<NSObject>> implements Iterable<NSObject> {
    public NSCollection(String type,String name,NSCollection parent) {
        super(type,name,parent);
        this.value = new ArrayList<>();
    }

    public void add(NSObject obj) {
        this.value.add(obj);
    }

    public NSObject getChildIndex(int index) {
        return value.get(index);
    }

    public int size() {
        return value.size();
    }

    public void delete(NSObject object) {
        super.value.remove(object);
    }
    @Override
    public Iterator<NSObject> iterator() {
        return new NSCollectionIterator();
    }

    @Override
    public void forEach(Consumer action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator spliterator() {
        return Iterable.super.spliterator();
    }

    private class NSCollectionIterator implements Iterator<NSObject> {
        private int cur = -1;

        @Override
        public boolean hasNext() {
            return cur + 1 < value.size();
        }

        @Override
        public NSObject next() {
            cur++;
            return value.get(cur);
        }
    }
}

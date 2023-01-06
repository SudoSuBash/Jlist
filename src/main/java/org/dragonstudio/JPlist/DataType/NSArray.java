/**
 * This class called NSDict corresponds Dict type in Plist.
 *
 * @author SYSTEM-QEMU-PPC
 */

package org.dragonstudio.JPlist.DataType;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NSArray extends NSObject<List<NSObject>>
        implements NSCollection,Cloneable, Iterable<NSObject> {

    public NSArray(String key, NSCollection parent) {
        super("array",key,parent);
        super.value = new ArrayList<>();
    }

    public NSArray() {
        this(null,null);
        super.parentDict = this;
    }

    @Override
    public int size() {
        return super.value.size();
    }

    @Override
    public boolean isEmpty() {
        return super.value.size() == 0;
    }

    @Override
    public void add(NSObject object) {
        super.value.add(object);
    }


    public void remove(String key) {
        super.value.remove(key);
    }

    @Override
    public Iterator iterator() {
        return new CollectionIterator();
    }

    private class CollectionIterator implements Iterator<NSObject> {
        private int cur = -1;

        @Override
        public boolean hasNext() {
            return cur < value.size() - 1;
        }

        @Override
        public NSObject next() {
            cur += 1;
            return value.get(cur);
        }

        @Override
        public void remove() {
            Iterator.super.remove();
        }
    }
}

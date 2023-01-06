/**
 * This class called NSArray corresponds Array type in plist
 *
 * @author SYSTEM-QEMU-PPC
 */

package org.dragonstudio.JPlist.DataType;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class NSDict extends NSObject<Map<Integer,NSObject>>
    implements NSCollection,Cloneable,Iterable<NSObject> {
    public NSDict(String key, NSCollection parent) {
        super("dict", key, parent);
        super.value = new HashMap<>();
    }

    public NSDict() {
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
        Integer hashcode = object.getKey().hashCode();
        super.value.put(hashcode,object);
    }


    public void remove(int index) {
        super.value.remove(index);
    }

    @Override
    public Iterator<NSObject> iterator() {
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

            Integer[] key = value.keySet().toArray(new Integer[0]);
            return value.get(key[cur]);
        }

        @Override
        public void remove() {
            Iterator.super.remove();
        }
    }
}

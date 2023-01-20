/**
 * This class called NSArray corresponds Array type in plist
 *
 * @author SYSTEM-QEMU-PPC
 */

package studio.dragon.JPlist.DataType;

import java.util.*;

public class NSDict extends NSObject<Map<Integer,NSObject>>
    implements INSDict,Cloneable,Iterable<NSObject> {

    /**
     *
     * @param key Parent Key(can be null)
     * @param parent Parent Collection (Can be NSArray or NSDict)
     */
    public NSDict(String key, NSCollection parent) {
        super("dict", key, parent);
        super.value = new HashMap<>();
    }


    /**
     * If you want to get a ROOT instance,plz use this constructor function.
     */
    public NSDict() {
        this(null,null);
        super.parent = this;
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

    @Override
    public boolean contains(NSObject object) {
        return super.value.containsValue(object);
    }

    @Override
    public NSObject indexOf(int cur) {
        Set<Integer> keys = super.value.keySet();
        Integer[] keyArr = keys.toArray(new Integer[0]);
        return super.value.get(keyArr[cur]);
    }


    @Override
    public boolean containsKey(String key) {
        return super.value.containsKey(key.hashCode());
    }

    @Override
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
    }
}

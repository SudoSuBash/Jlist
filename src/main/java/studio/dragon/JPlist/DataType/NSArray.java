/**
 * This class called NSDict corresponds Dict type in Plist.
 *
 * @author SYSTEM-QEMU-PPC
 */

package studio.dragon.JPlist.DataType;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class NSArray extends NSObject<List<NSObject>>
        implements INSArray,Cloneable, Iterable<NSObject> {

    /**
     * @param key Parent Key(can be null)
     * @param parent Parent Collection (Can be NSArray or NSDict)
     */
    public NSArray(String key, NSCollection parent) {
        super("array",key,parent);
        super.value = new ArrayList<>();
    }

    /**
     * If you want to get a ROOT instance,plz use this constructor function.
     */
    public NSArray() {
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
        super.value.add(object);
    }

    @Override
    public boolean contains(NSObject object) {
        return super.value.contains(object);
    }

    @Override
    public void sort(Comparator<? super NSObject> c) {
        super.value.sort(c);
    }

    @Override
    public void remove(int index) {
        super.value.remove(index);
    }

    @Override
    public NSObject indexOf(int cur) {
        return super.value.get(cur);
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
    }
}

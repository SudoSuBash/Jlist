/**
 * This class called NSCollection is the parent class for NSDict & NSArray.
 * Base class.
 *
 * @author SYSTEM-QEMU-PPC
 */

package org.sudosubash.JPListHackintosh.DataType;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class NSCollection extends NSObject implements Iterable<NSObject> {
    protected List<NSObject> child;

    public NSCollection(String type,String name,NSCollection parent) {
        super(type,name,parent);
        this.child = new ArrayList<>();
    }

    public void add(NSObject dict) {
        this.child.add(dict);
    }

    public NSObject getChildIndex(int index) {
        return child.get(index);
    }

    public int size() {
        return child.size();
    }


    @Override
    public Iterator<NSObject> iterator() {
        return new Iterator<NSObject>() {
            private int cur = -1;
            @Override
            public boolean hasNext() {
                return cur + 1 < child.size();
            }

            @Override
            public NSObject next() {
                cur++;
                return child.get(cur);
            }
        };
    }

    @Override
    public void forEach(Consumer action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator spliterator() {
        return Iterable.super.spliterator();
    }
}

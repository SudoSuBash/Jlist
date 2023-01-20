package studio.dragon.JPlist.DataType;

import java.util.Comparator;

public interface INSArray extends NSCollection {
    void sort(Comparator<? super NSObject> c);

    void remove(int index);
}

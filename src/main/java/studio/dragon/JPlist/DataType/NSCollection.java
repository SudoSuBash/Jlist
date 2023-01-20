package studio.dragon.JPlist.DataType;

public interface NSCollection extends Iterable<NSObject> {
    int size();

    boolean isEmpty();

    void add(NSObject object);

    boolean contains(NSObject object);

    NSObject indexOf(int cur);

}

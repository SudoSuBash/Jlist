package studio.dragon.JPlist.DataType;

public interface INSDict extends NSCollection {
    boolean containsKey(String key);

    void remove(int index);
}

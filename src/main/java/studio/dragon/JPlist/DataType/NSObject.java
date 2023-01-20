/**
 * The base class for all the NSType classes.
 *
 * @author SYSTEM-QEMU-PPC
 */

package studio.dragon.JPlist.DataType;

import java.io.Serializable;

public class NSObject<T>
    implements Serializable {
    protected NSCollection parent;
    protected String key;
    protected String type;
    protected T value;

    public NSObject(String type, String key, NSCollection parent) {
        this.type = type;
        if(parent instanceof NSArray) this.key = null;
        else this.key = key;
        this.parent = parent;
        if(parent != null) parent.add(this);
    }

    public NSCollection getParent() {
        return parent;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }
}

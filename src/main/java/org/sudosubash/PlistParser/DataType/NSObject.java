/**
 * The base class for all the NSType classes
 *
 * @author SYSTEM-QEMU-PPC
 */

package org.sudosubash.PlistParser.DataType;

public class NSObject {
    protected NSCollection parentDict;
    protected String key;

    protected String type;

    protected String value;//如果是非collection类型，那么启用这个值

    public String getValueForNotCollection() {
        if(this instanceof NSCollection) return null;
        return value;
    }

    public NSObject(String type, String key, NSCollection parent) {
        this.type = type;
        this.key = key;
        this.parentDict = parent;
    }

    public NSCollection getParentDict() {
        return parentDict;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getType() {
        return type;
    }
}

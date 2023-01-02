/**
 * This class called NSArray corresponds Array type in plist
 *
 * @author SYSTEM-QEMU-PPC
 */

package org.sudosubash.PlistParser.DataType;

import java.util.List;

public class NSArray extends NSCollection {
    public NSArray(String key,NSCollection parent) {
        super("array",key,parent);
    }

    public String getKey() {
        return key;
    }

    public List<NSObject> getChild() {
        return child;
    }

    public void addChild(NSDict dict) {
        this.child.add(dict);
    }


}

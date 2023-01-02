/**
 * This class called NSArray corresponds Array type in plist
 *
 * @author SYSTEM-QEMU-PPC
 */

package org.sudosubash.JPListHackintosh.DataType;

public class NSArray extends NSCollection {
    public NSArray(String key,NSCollection parent) {
        super("array",key,parent);
    }

    public String getKey() {
        return key;
    }


}

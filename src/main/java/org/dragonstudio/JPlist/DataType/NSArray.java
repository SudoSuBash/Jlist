/**
 * This class called NSArray corresponds Array type in plist
 *
 * @author SYSTEM-QEMU-PPC
 */

package org.dragonstudio.JPlist.DataType;

public class NSArray extends NSCollection {
    public NSArray(String key,NSCollection parent) {
        super("array",key,parent);
    }
}

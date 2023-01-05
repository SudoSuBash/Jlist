/**
 * This class called NSBoolean corresponds Boolean type in plist
 *
 * @author SYSTEM-QEMU-PPC
 */

package org.dragonstudio.JPlist.DataType;

public class NSBoolean extends NSObject<Boolean> {

    public NSBoolean(String key, boolean value, NSCollection parent) {
        super("boolean",key,parent);
        super.value = value;
    }
}

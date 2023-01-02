/**
 * This class called NSBoolean corresponds Boolean type in plist
 *
 * @author SYSTEM-QEMU-PPC
 */

package org.sudosubash.PlistParser.DataType;

public class NSBoolean extends NSObject {

    private boolean value;
    public NSBoolean(String key,boolean value,NSCollection parent) {
        super("boolean",key,parent);
        this.value = value;
        super.value = String.valueOf(value);
    }

    public boolean isValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }
}

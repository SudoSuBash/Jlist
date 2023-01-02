/**
 * @NotFinished the FLOAT & DOUBLE NUMBER will NOT be fetched into DOM.
 * This class called NSInt corresponds INT type(NOT FLOAT / DOUBLE) in Plist.
 *
 * @author SYSTEM-QEMU-PPC
 */

package org.sudosubash.PlistParser.DataType;

public class NSInt extends NSObject{
    private long value;

    public NSInt(String key,long value,NSCollection parent) {
        super("integer",key,parent);
        this.value = value;
        super.value = String.valueOf(value);
    }

    public long getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}

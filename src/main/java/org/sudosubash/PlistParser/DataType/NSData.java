/**
 * @NotFinished
 *
 * This class called NSData corresponds Data type in Plist.
 *
 * @author SYSTEM-QEMU-PPC
 */
package org.sudosubash.PlistParser.DataType;

public class NSData extends NSObject {

    private String value;

    public NSData(String key, String value,NSCollection parent) {
        super("data",key,parent);
        this.value = value;
        super.value = String.valueOf(value);
    }

    public String DecodeString() {
        return this.value;
    }

}

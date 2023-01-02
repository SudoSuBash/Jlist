/**
 * This class called NSString corresponds String type in Plist.
 *
 * @author SYSTEM-QEMU-PPC
 */

package org.sudosubash.JPListHackintosh.DataType;

public class NSString extends NSObject {
    private String value;

    public NSString(String key, String value ,NSCollection parent) {
        super("string",key,parent);
        this.value = value;
        super.value = String.valueOf(value);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}

/**
 * This class called NSString corresponds String type in Plist.
 *
 * @author SYSTEM-QEMU-PPC
 */

package org.dragonstudio.JPlist.DataType;

public class NSString extends NSObject<String> {

    public NSString(String key, String value ,NSCollection parent) {
        super("string",key,parent);
        super.value = String.valueOf(value);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}

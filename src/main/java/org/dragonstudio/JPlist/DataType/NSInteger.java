/**
 * This class called NSInt corresponds INT type(NOT FLOAT / DOUBLE) in Plist.
 *
 * @author SYSTEM-QEMU-PPC
 */

package org.dragonstudio.JPlist.DataType;

public class NSInteger extends NSObject<Long> {
    public NSInteger(String key, long value, NSCollection parent) {
        super("integer",key,parent);
        super.value = value;
    }
}

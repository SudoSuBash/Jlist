/**
 * This class called NSNumber corresponds REAL in Plist.
 *
 * @author SYSTEM-QEMU-PPC
 */

package org.dragonstudio.JPlist.DataType;

public class NSNumber extends NSObject<Double> {
    public NSNumber(String key, double value, NSCollection parent) {
        super("real",key,parent);
        super.value = value;
    }
}

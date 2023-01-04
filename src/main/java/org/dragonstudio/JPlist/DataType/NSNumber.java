/**
 * @NotFinished the FLOAT & DOUBLE NUMBER will NOT be fetched into DOM.
 * This class called NSInt corresponds INT type(NOT FLOAT / DOUBLE) in Plist.
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

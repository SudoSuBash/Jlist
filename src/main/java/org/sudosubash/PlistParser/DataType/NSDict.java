/**
 * This class called NSDict corresponds Dict type in Plist.
 *
 * @author SYSTEM-QEMU-PPC
 */

package org.sudosubash.PlistParser.DataType;


public class NSDict extends NSCollection {

    public NSDict(String key,NSCollection parent) {
        super("dict",key,parent);
    }
}

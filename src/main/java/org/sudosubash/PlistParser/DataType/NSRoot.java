/**
 * The root of all the DOM Tree.Extends NSDict.
 * The parent dict is itself.
 *
 * @author SYSTEM-QEMU-PPC
 */

package org.sudosubash.PlistParser.DataType;

public class NSRoot extends NSDict {

    public NSRoot() {
        super(null, null);
        super.parentDict = this;
    }
}

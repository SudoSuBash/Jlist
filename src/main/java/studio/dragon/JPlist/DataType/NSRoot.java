/**
 * DO NOT use this type(NSRoot).
 * If you want to new a root element,plz use NSArray() or NSDict() instead.
 *
 * @Deprecated
 * @author SYSTEM-QEMU-PPC
 */
package studio.dragon.JPlist.DataType;

@Deprecated
public class NSRoot extends NSDict {
    public NSRoot(String key) {
        super(key,null);
        super.parent = this;
    }
}

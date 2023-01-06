/**
 * Usage:
 * NSOTPController eg = new NSOTPController(YourNSRoot);
 * eg.convertToString() // convert the NSRoot DOM Tree to a String variable
 *
 * @author SYSTEM-QEMU-PPC
 */

package org.dragonstudio.JPlist;

import org.dragonstudio.JPlist.DataType.NSCollection;
import org.dragonstudio.JPlist.DataType.NSObject;

public class NSOTPController {
    private NSCollection object;
    private NSObjToPlistModel model;
    private int count = 2;

    public NSOTPController(NSCollection nsRoot) {
        this(nsRoot,"UTF-8");
    }

    public NSOTPController(NSCollection nsRoot,String encode) {
        this.object = nsRoot;
        this.model = new NSObjToPlistModel(encode);
    }

    public String convertToString() throws PlistNotValidException {
        model.StartFile(object);
        this.parseObject(this.object);
        model.EndFile(object);
        return model.getText().toString();

    }

    private void parseObject(NSCollection nsCollection) throws PlistNotValidException {
        for(NSObject object1 : nsCollection) {
            model.Start(count,object1);
            if(object1 instanceof NSCollection) {
                count += 2;
                this.parseObject((NSCollection) object1);
            } else {
                model.writeString(object1);
            }
            if(object1 instanceof NSCollection) count -= 2;
            model.Close(count,object1);
        }
    }
}

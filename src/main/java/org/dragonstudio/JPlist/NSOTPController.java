/**
 * Usage:
 * NSOTPController eg = new NSOTPController(YourNSRoot);
 * eg.convertToString() // convert the NSRoot DOM Tree to a String variable
 *
 * @author SYSTEM-QEMU-PPC
 */

package org.dragonstudio.JPlist;

import org.dragonstudio.JPlist.DataType.NSCollection;
import org.dragonstudio.JPlist.DataType.NSDict;
import org.dragonstudio.JPlist.DataType.NSObject;
import org.dragonstudio.JPlist.DataType.NSRoot;

import java.util.ArrayList;
import java.util.List;

public class NSOTPController {
    private NSRoot object;
    private NSObjToPlistModel model;
    private int count = 2;

    public NSOTPController(NSRoot nsRoot) {
        this(nsRoot,"UTF-8");
    }

    public NSOTPController(NSRoot nsRoot,String encode) {
        this.object = nsRoot;
        this.model = new NSObjToPlistModel(encode);
    }

    public String convertToString() throws PlistNotValidException {
        model.StartFile();
        this.parseObject(this.object);
        model.EndFile();
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

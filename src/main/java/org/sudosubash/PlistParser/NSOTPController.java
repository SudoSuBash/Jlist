/**
 * Usage:
 * NSOTPController eg = new NSOTPController(YourNSRoot);
 * eg.convertToString() // convert the DOM Tree to a String variable
 *
 * @author SYSTEM-QEMU-PPC
 */

package org.sudosubash.PlistParser;

import org.sudosubash.PlistParser.DataType.NSCollection;
import org.sudosubash.PlistParser.DataType.NSObject;
import org.sudosubash.PlistParser.DataType.NSRoot;

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

    public NSRoot getObject() {
        return object;
    }

    public String convertToString() {
        model.StartFile();
        parseObject(this.object);
        model.EndFile();
        return model.getText().toString();

    }

    private void parseObject(NSCollection nsCollection) {

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

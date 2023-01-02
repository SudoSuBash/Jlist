package org.sudosubash.JPListHackintosh;

import org.sudosubash.JPListHackintosh.DataType.*;

public class MainC {
    public static void main(String[] args) {
        NSRoot root = new NSRoot();
        NSDict dict = new NSDict("Dict1",root);
        NSString string = new NSString("String1","SYSTEM-QEMU-PPC",root);
        NSInt integer = new NSInt("Integer",1,dict);
        NSArray array = new NSArray("Array",dict);
        NSDict dict1 = new NSDict("hey",array);
        NSBoolean nsBoolean = new NSBoolean("bool",false,array);
        NSString string1 = new NSString("恶臭牛父","114514",root);

        NSOTPController controller = new NSOTPController(root);
        String s = controller.convertToString();

        System.out.println(s);
    }
}

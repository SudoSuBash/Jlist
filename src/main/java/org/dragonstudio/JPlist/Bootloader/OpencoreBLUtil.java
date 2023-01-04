package org.dragonstudio.JPlist.Bootloader;

import org.dragonstudio.JPlist.DataType.NSDict;
import org.dragonstudio.JPlist.DataType.NSObject;
import org.dragonstudio.JPlist.DataType.NSRoot;

import java.util.Arrays;

public class OpencoreBLUtil {
    private static String[] items = {
            "ACPI",
            "Booter",
            "DeviceProperties",
            "Kernel",
            "Misc",
            "NVRAM",
            "PlatformInfo",
            "UEFI"
    };

    /**
     * Simply judge the bl is the OC BL.
     * @param dict
     * @return
     */
    public static boolean isOCBL(NSRoot dict) {
        for(NSObject nsDict : dict) {
            if(!(nsDict instanceof NSDict)) return false;
            if (!Arrays.asList(items).contains(nsDict.getKey())) return false;
        }
        return true;
    }

}

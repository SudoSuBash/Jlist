package org.sudosubash.JPListHackintosh.Bootloader;

import org.sudosubash.JPListHackintosh.DataType.NSDict;
import org.sudosubash.JPListHackintosh.DataType.NSObject;
import org.sudosubash.JPListHackintosh.DataType.NSRoot;

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

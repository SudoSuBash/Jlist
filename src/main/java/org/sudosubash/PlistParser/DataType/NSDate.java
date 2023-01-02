/**
 * @NotFinished Will NOT be fetched into the NSRoot tree.
 *
 * This class called NSDate corresponds Date type in Plist.
 */

package org.sudosubash.PlistParser.DataType;

import java.util.Date;

public class NSDate extends NSObject {
    private Date value;

    public NSDate(String key,String date,NSCollection parent) {
        super("date",key,parent);

        Date val = new Date();
        this.value = val;
    }

}

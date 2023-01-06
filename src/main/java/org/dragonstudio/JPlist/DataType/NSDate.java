/**
 * This class called NSDate corresponds Date type in Plist.
 * The usage of NSData is an example.I believe you can understand.
 *
 * @author SYSTEM-QEMU-PPC
 */

package org.dragonstudio.JPlist.DataType;

import org.dragonstudio.JPlist.PlistNotValidException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NSDate extends NSObject<Date> {

    public NSDate(String key, NSCollection parent) {
        super("date",key,parent);
        this.value = null;
    }


    public void initWithDateFString(String date) throws PlistNotValidException {
        String correct = date.replace('T',' ')
                .replace("Z","");
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            this.value = sdf.parse(correct);
        } catch (ParseException ex) {
            throw new PlistNotValidException("Date string "+date+" is not valid!");
        }

    }
    public void initWithDate() {
        this.value = new Date();
    }
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String init = sdf.format(this.value);
        return init.replace(' ', 'T') + "Z";
    }

}

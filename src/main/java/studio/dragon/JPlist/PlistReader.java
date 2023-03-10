/**
 * This package can read the Plist XML File
 * If the plist file does not right,will throw the Exception "PlistNotValidException"
 * This package depends on Dom4J & GSON Module.
 *
 * @version inside test 1
 * @author SYSTEM-QEMU-PPC(Sudo-su-Bash)
 * @workgroup Dragon Studio,Copyright 2022.07.25
 * @Date 2023-01-02 13:36
 * @bugs
 * 1.NSDate (Have not finished yet,<span style="color:red">CANNOT</span> fetch the data type)
 * 2.NSData (The encryption and decryption has not finished yet)
 * 3.NSInt (Can not store the Float/Double Variable,non-full support the number variable
 *
 * @NotFinishedFunctions
 * 1.Convert the Plist to JSON
 * 2.Convert some SPECIAL JSON to Plist
 */

package studio.dragon.JPlist;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import studio.dragon.JPlist.DataType.*;

import java.io.File;
import java.io.IOException;

public class PlistReader {

    public static String SEPARATOR_LINE = System.getProperty("line.separator");

    public static Element getRootElementFromXml(String path) throws IOException, DocumentException, PlistNotValidException {
        File file = new File(path);
        if (!file.isFile() || !file.exists()) throw new IOException("File format error or not found!");
        SAXReader reader = new SAXReader();
        Document dom = reader.read(file);
        if (dom.getRootElement().element("dict") != null) {
            return dom.getRootElement().element("dict");
        } else if (dom.getRootElement().element("array") != null) {
            return dom.getRootElement().element("array");
        } else throw new PlistNotValidException("Root node must be a collection type!");
    }

    /**
     * @param element A Dom4J Entity
     * @return An NSRoot Entity
     * @throws PlistNotValidException When the plist has some errors
     */
    public static NSCollection convertToElement(Element element) throws PlistNotValidException {
        NSCollection collection = null;
        if(element.getName().equalsIgnoreCase("dict")) {
            collection = new NSDict();
            parseDict((NSDict) collection,element);
        } else if (element.getName().equalsIgnoreCase("array")) {
            collection = new NSArray();
            parseArray((NSArray) collection, element);
        }
        return collection;
    }

    private static NSDict parseDict(NSDict dict, Element element) throws PlistNotValidException {
        int length = element.elements().size();
        for (int cur = 0; cur < length; cur+=2) {

            Element son = (Element) element.elements().get(cur),next;
            if (son.getName().equalsIgnoreCase("key")) {
                if (cur+1 > length) {
                    throw new PlistNotValidException("Not a valid plist,because key '"+son.getStringValue()+"' hasn't got a valid value!");
                }
                next = (Element) element.elements().get(cur+1);
                if(next.getName().equalsIgnoreCase("key")) {
                    throw new PlistNotValidException("Not a valid plist,because key '"+son.getStringValue()+"' hasn't got a valid value!");
                }
                String key = son.getStringValue();
                Element value = next;
                parseNode(dict,key,value);
            }
        }
        return dict;
    }

    private static NSArray parseArray(NSArray array,Element arrayVal) throws PlistNotValidException {
        int length = arrayVal.elements().size();
        for(int cur=0;cur<length;cur++) {
            parseNode(array,null, arrayVal.elements().get(cur));
        }
        return array;
    }

    private static void parseNode(NSCollection parent, String key, Element value) throws PlistNotValidException {
        if (value.getName().equalsIgnoreCase("integer")) {
            if(value.getStringValue().contains(".")) throw new PlistNotValidException("The key:"+key+"'s value is not valid!");
            new NSInteger(key,Long.parseLong(value.getStringValue()),parent);
        }
        else if (value.getName().equalsIgnoreCase("string"))
            new NSString(key,value.getStringValue(),parent);
        else if (value.getName().equalsIgnoreCase("data"))
            new NSData(key,parent).initWithEncodedString(value.getStringValue());
        else if (value.getName().equalsIgnoreCase("real"))
            new NSNumber(key,Double.valueOf(value.getStringValue()),parent);
        else if (value.getName().equalsIgnoreCase("date"))
            new NSDate(key,parent).initWithDateFString(value.getStringValue());
        else if (value.getName().equalsIgnoreCase("dict")) {
            NSDict res = new NSDict(key,parent);
            parseDict(res,value);
        } else if (value.getName().equalsIgnoreCase("array")) {
            NSArray res = new NSArray(key,parent);
            parseArray(res,value);
        }
        else if (value.getName().equalsIgnoreCase("true")
                || value.getName().equalsIgnoreCase("false")) {
            boolean val;
            if(value.getName().equalsIgnoreCase("true")) val = true;
            else if(value.getName().equalsIgnoreCase("false")) val = false;
            else throw new PlistNotValidException("The key "+key+"'s value is not right,requires a true/false value!'");
            new NSBoolean(key,val,parent);
        }
        else throw new PlistNotValidException("Unknown type "+ value.getName()+"for key:"+key);
    }
}

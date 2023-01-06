package org.dragonstudio.JPlist;

import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dragonstudio.JPlist.DataType.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainC {
    public static void main(String[] args) throws IOException, PlistNotValidException {

        NSArray w = new NSArray();
        NSString string = new NSString("str","1919810",w);
        NSDict dict = new NSDict("dict",w);
        NSData data = new NSData("data",w);
        data.initWithEncodedString("EUUU");

        NSData data1 = new NSData("data",dict);
        data1.initWithDecodedString("114514");

        NSOTPController controller = new NSOTPController(w);
        String content = controller.convertToString();
        System.out.println(content);

        save("/Users/sudosubash/Desktop/Untitled.plist",content);

    }

    private static void save(String path,String content) throws IOException {
        File f = new File(path);
        if(f.exists()) f.delete();
        f.createNewFile();

        FileWriter writer = new FileWriter(f);

        writer.write(content);
        writer.flush();
        writer.close();
    }
}

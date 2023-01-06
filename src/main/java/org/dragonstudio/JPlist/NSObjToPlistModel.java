/**
 * This class is used to convert the DOM Tree to the plist file.
 */

package org.dragonstudio.JPlist;

import org.dragonstudio.JPlist.DataType.*;

public class NSObjToPlistModel implements INSObjToPlist {

    private String head =
            "<?xml version=\"1.0\" encoding=\"%s\"?>\n" +
            "<!DOCTYPE plist PUBLIC \"-//Apple//DTD PLIST 1.0//EN\" \"http://www.apple.com/DTDs/PropertyList-1.0.dtd\">\n" ;
    private StringBuilder text;

    public NSObjToPlistModel() {
        this("UTF-8");
    }

    public NSObjToPlistModel(String encoding) {
        head = String.format(head,encoding);
        this.text = new StringBuilder(head);

    }

    @Override
    public void StartFile(NSCollection rootType) {
        this.text.append("<plist>");
        this.text.append(PlistReader.SEPARATOR_LINE);
        if(rootType instanceof NSDict) this.text.append("<dict>");
        else if (rootType instanceof NSArray) this.text.append("<array>");
        text.append(PlistReader.SEPARATOR_LINE);
    }

    @Override
    public void Start(int spacecount, NSObject object) {
        text.append(getSpaces(spacecount));
        if (object.getKey() != null) {
            text.append("<key>");
            text.append(object.getKey());
            text.append("</key>");
            text.append(PlistReader.SEPARATOR_LINE);
            text.append(getSpaces(spacecount));
        }
        if(object instanceof NSBoolean) {
            text.append("<");
            text.append(((NSBoolean) object).getValue() ? "true" : "false");
            text.append("/");
            text.append(">");
            text.append(PlistReader.SEPARATOR_LINE);
            return;
        }

        text.append("<");
        text.append(object.getType());
        text.append(">");
        if (object instanceof NSCollection) {
            text.append(PlistReader.SEPARATOR_LINE);
        }
    }

    @Override
    public void Close(int spacecount,NSObject object) {

        if(object instanceof NSBoolean) return;
        if(object instanceof NSCollection) text.append(getSpaces(spacecount));
        text.append("</");
        text.append(object.getType());
        text.append(">");
        text.append(PlistReader.SEPARATOR_LINE);
    }

    @Override
    public void writeString(NSObject object) throws PlistNotValidException {
        if(object instanceof NSBoolean) return;
        if(object instanceof NSCollection) return;

        if(object instanceof NSDate) text.append(object);
        else if(object instanceof NSData) text.append(((NSData) object).Encode());
        else text.append(object.getValue());
    }

    @Override
    public void EndFile(NSCollection rootType) {
        if(rootType instanceof NSDict) this.text.append("</dict>");
        else if (rootType instanceof NSArray) this.text.append("</array>");
        this.text.append(PlistReader.SEPARATOR_LINE);
        this.text.append("</plist>");
    }


    public StringBuilder getText() {
        return text;
    }

    private String getSpaces(int count) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<count;i++) {
            sb.append(" ");
        }
        return sb.toString();
    }
}

package org.sudosubash.PlistParser;

import org.sudosubash.PlistParser.DataType.NSObject;


public interface INSObjToPlist {
    void StartFile();
    void Start(int spacecount,NSObject object);

    void Close(int spacecount,NSObject object);

    void writeString(NSObject object);

    void EndFile();
}

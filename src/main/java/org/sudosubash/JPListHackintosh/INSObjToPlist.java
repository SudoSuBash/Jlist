package org.sudosubash.JPListHackintosh;

import org.sudosubash.JPListHackintosh.DataType.NSObject;


public interface INSObjToPlist {
    void StartFile();
    void Start(int spacecount,NSObject object);

    void Close(int spacecount,NSObject object);

    void writeString(NSObject object);

    void EndFile();
}

package org.dragonstudio.JPlist;

import org.dragonstudio.JPlist.DataType.NSCollection;
import org.dragonstudio.JPlist.DataType.NSObject;


public interface INSObjToPlist {

    void StartFile(NSCollection rootType);

    void Start(int spacecount, NSObject object);

    void Close(int spacecount,NSObject object);

    void writeString(NSObject object) throws PlistNotValidException;


    void EndFile(NSCollection rootType);
}

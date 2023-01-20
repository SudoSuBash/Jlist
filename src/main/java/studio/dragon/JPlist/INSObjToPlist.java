package studio.dragon.JPlist;

import studio.dragon.JPlist.DataType.NSCollection;
import studio.dragon.JPlist.DataType.NSObject;


public interface INSObjToPlist {

    void StartFile(NSCollection rootType);

    void Start(int spacecount, NSObject object);

    void Close(int spacecount,NSObject object);

    void writeString(NSObject object) throws PlistNotValidException;


    void EndFile(NSCollection rootType);
}

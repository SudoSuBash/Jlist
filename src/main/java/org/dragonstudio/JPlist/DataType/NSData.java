/**
 * This class called NSData corresponds Data type in Plist.
 * Finished on 4 Jun,2023.
 *
 * If you want to get Base64-Decoded data,plz use getValue() function.
 * If you want to get Base64-Encoded data,plz use NSDataInstance.Encode() function.
 *
 * Usage Example:
 * 1 NSData nsdata = new NSData();
 * 2 nsdata.initWithTypeString(YourString);
 * (Type = Encoded(Base64 String) / Decoded (Non-Base64 String))
 *
 * @author SYSTEM-QEMU-PPC
 */
package org.dragonstudio.JPlist.DataType;

import org.dragonstudio.JPlist.PlistNotValidException;

import java.util.Base64;

public class NSData extends NSObject<String> {

    public static final char[] hex = {
            '0','1','2','3','4','5','6','7','8','9','A',
            'B','C','D','E','F'
    };


    /**
     * Usage:
     * NSData data = new NSData(Key,Parent);
     * data.initWithEncodedString(string); //If encoded
     * data.initWithDecodedString(string); //If decoded
     * @param key
     * @param parent
     */

    public NSData(String key, NSCollection parent) {
        super("data",key,parent);
    }

    public void initWithEncodedString(String string) throws PlistNotValidException {
        if(string.isEmpty() || string.length() == 0) throw new PlistNotValidException("Cannot encode an empty string!");
        this.value = this.DecodeString(string);
    }

    public void initWithDecodedString(String string) throws PlistNotValidException {
        if(string.isEmpty() || string.length() == 0) throw new PlistNotValidException("Cannot decode an empty string!");
        EncodeString(string); // check if can encode
        this.value = string;
    }

    public String Encode() throws PlistNotValidException {
        return this.EncodeString(this.value);
    }


    private String DecodeString(String string) throws PlistNotValidException {
        byte[] decoded = Base64.getDecoder().decode(string);

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<decoded.length;i++) {
            try {
                sb.append(hex[(decoded[i] >>> 4) & 0x0F]);
                sb.append(hex[decoded[i] & 0x0F]);
            } catch (ArrayIndexOutOfBoundsException exception) {
                throw new PlistNotValidException("Data "+string+" is not correct!");
            }

        }
        return sb.toString();
    }


    private String EncodeString(String data) throws PlistNotValidException {
        byte[] bytes = data.getBytes();
        if(bytes.length % 2 != 0) throw new PlistNotValidException("Data "+data +" does not correct");
        byte[] result = new byte[bytes.length / 2];

        for(int i=0;i<data.length();i+=2) {
            int ten_index = this.getIndex((char)bytes[i]);
            int one_index = this.getIndex((char)bytes[i+1]);
            if(ten_index == -1 || one_index == -1)
                throw new PlistNotValidException("Data "+data +" does not correct");
            int ten = ten_index << 4;
            int one = one_index;
            byte ans = (byte) (ten + one);
            result[i / 2] = ans;
        }

        String encoded = Base64.getEncoder().encodeToString(result);
        return encoded;
    }
    private int getIndex(char c) {
        for(int cur = 0;cur < hex.length;cur++) {
            if(c == hex[cur]) return cur;
        }
        return -1;
    }
}

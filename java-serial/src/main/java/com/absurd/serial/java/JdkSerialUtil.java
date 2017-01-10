package com.absurd.serial.java;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/***
 *
 */
public class JdkSerialUtil {

    public static  <T extends Serializable> ByteArrayOutputStream   serialize(T obj) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream ois = new ObjectOutputStream(bos);
        ois.writeObject(obj);
        ois.flush();
        ois.close();
        return bos;

    }

    public static <T extends Serializable> T unserialize(InputStream inputStream) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(inputStream);
        T s3 = (T) ois.readObject();
        ois.close();
        return s3;

    }
}

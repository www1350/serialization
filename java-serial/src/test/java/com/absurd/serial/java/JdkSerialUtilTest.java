package com.absurd.serial.java;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;

/***
 *
 */
public class JdkSerialUtilTest {
    @Test
    public void serialize() throws IOException {
        User u = new User();
        u.setId(11);
        u.setUserName("www");
        u.setPassword("P@ss");
        ByteArrayOutputStream bos = JdkSerialUtil.serialize(u);
        FileOutputStream fos = new FileOutputStream(new File("aa.txt"));
        byte[] bytes = bos.toByteArray();
        bos.close();
        fos.write(bytes);
    }

    @Test
    public void unserialize() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(new File("aa.txt"));
        User u = JdkSerialUtil.unserialize(fis);
        System.out.printf(""+u.toString());
    }
}

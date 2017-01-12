package com.absurd.serial.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONWriter;
import com.alibaba.fastjson.util.IOUtils;

import org.junit.Test;

import sun.nio.ch.IOUtil;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

/***
 *
 */
public class FastJsonTest {
    @Test
    public void serialize() throws IOException {
        User u = new User();
        u.setId(11);
        u.setUserName("www");
        u.setPassword("P@ss");
        FileOutputStream fos = new FileOutputStream(new File("aa.txt"));
        byte[] bytes = JSON.toJSONBytes(u);
        fos.write(bytes);
        fos.close();
    }

    @Test
    public void unserialize() throws IOException, ClassNotFoundException {

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buffer = new byte[1];
        try(FileInputStream fis = new FileInputStream(new File("aa.txt"))){
           buffer = new byte[fis.available()];
            fis.read(buffer);
            out.write(buffer);
        }

        User u =  JSONObject.parseObject(buffer,User.class);

        System.out.printf(""+u.toString());
    }
}

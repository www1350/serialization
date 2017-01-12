package com.absurd.serial.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

/***
 *
 */
public class GsonTest {

    @Test
    public void serialize() throws IOException {
        User u = new User();
        u.setId(11);
        u.setUserName("www");
        u.setPassword("P@ss");

        Gson gson = new Gson();
        String json =  gson.toJson(u);

        FileOutputStream fos = new FileOutputStream(new File("aa.txt"));
        byte[] bytes = json.getBytes();
        fos.write(bytes);
        fos.close();
    }

    @Test
    public void unserialize() throws IOException, ClassNotFoundException {
        FileReader fr = new FileReader(new File("aa.txt"));
        Gson gson = new Gson();
        User u = gson.fromJson(fr,User.class);
        System.out.printf(""+u.toString());
    }
}

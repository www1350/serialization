package com.absurd.serial.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;

/***
 *
 */
public class JacksonTest {
    @Test
    public void serialize() throws IOException {
        User u = new User();
        u.setId(11);
        u.setUserName("www");
        u.setPassword("P@ss");
        ObjectMapper ob = new ObjectMapper();
        FileOutputStream fos =   new FileOutputStream(new File("aa.txt"));
        ob.writeValue(fos,u);
        fos.close();
    }

    @Test
    public void unserialize() throws IOException {
        ObjectMapper ob = new ObjectMapper();
        FileInputStream fis = new FileInputStream(new File("aa.txt"));
        User u =  ob.readValue(fis,User.class);
        fis.close();
        System.out.printf(""+u.toString());
    }
}

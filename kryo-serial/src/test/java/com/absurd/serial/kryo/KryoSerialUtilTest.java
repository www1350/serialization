package com.absurd.serial.kryo;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/***
 *
 */
public class KryoSerialUtilTest {
    @Test
    public void serialize() throws IOException {
        User u = new User();
        u.setId(11);
        u.setUserName("www");
        u.setPassword("P@ss");
        Kryo kryo = new Kryo();

        FileOutputStream fos = new FileOutputStream(new File("aa.txt"));
        Output output = new Output(fos);
        kryo.writeObject(output, u);
        output.close();
        fos.close();

    }

    @Test
    public void unserialize() throws IOException, ClassNotFoundException {
        Kryo kryo = new Kryo();
        FileInputStream fis = new FileInputStream(new File("aa.txt"));
        Input input = new Input(fis);
        User u =  kryo.readObject(input, User.class);
        input.close();
        fis.close();
        System.out.printf(""+u.toString());
    }
}

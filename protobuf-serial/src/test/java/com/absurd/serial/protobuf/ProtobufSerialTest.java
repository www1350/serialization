package com.absurd.serial.protobuf;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/***
 *
 */
public class ProtobufSerialTest {
    @Test
    public void serialize() throws IOException {
        UserOuterClass.User.Builder builder =   UserOuterClass.User.newBuilder();
        builder.setId(1);
        builder.setUserName("www");
        builder.setPassword("P@ss");
        UserOuterClass.User user = builder.build();
        System.out.printf(""+user);
    }

    @Test
    public void unserialize() throws IOException, ClassNotFoundException {
//        FileInputStream fis = new FileInputStream(new File("aa.txt"));
//        UserOuterClass.User user = UserOuterClass.User.parseFrom(fis);
//        System.out.printf(""+user.getId()+user.getUserName()+user.getPassword());

    }
}

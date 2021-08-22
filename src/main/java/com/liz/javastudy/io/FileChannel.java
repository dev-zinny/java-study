package com.liz.javastudy.io;

import java.io.*;

public class FileChannel {

    public static void main(String[] args) {

        try {
            FileInputStream fis = new FileInputStream(new File("src/main/resources/test11.zip"));
            FileOutputStream fos = new FileOutputStream(new File("src/main/resources/test33.zip"));

            java.nio.channels.FileChannel fc = fis.getChannel();
            java.nio.channels.FileChannel fcout = fos.getChannel();

            long size = fc.size();

            fc.transferTo(0, size, fcout);

            fcout.close();
            fc.close();

            fis.close();
            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

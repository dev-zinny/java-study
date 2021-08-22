package com.liz.javastudy.io;

import java.io.*;

public class Text {

    public static void main(String[] args) {

        try {
            FileInputStream fis = new FileInputStream(new File("src/main/resources/test1.txt"));
            FileOutputStream fos = new FileOutputStream(new File("src/main/resources/test2.txt"));

            int data = 0;
            while((data = fis.read()) != -1) {
                fos.write(data);
            }

            fis.close();
            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

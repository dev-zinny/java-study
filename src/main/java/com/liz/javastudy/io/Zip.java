package com.liz.javastudy.io;

import java.io.*;

public class Zip {

    public static void main(String[] args) {

        try {
            FileInputStream fis = new FileInputStream(new File("src/main/resources/test11.zip"));
            FileOutputStream fos = new FileOutputStream(new File("src/main/resources/test22.zip"));

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

package com.liz.javastudy.io;

import java.io.*;

public class BufferedXXStream {

    public static void main(String[] args) {

        try {
            FileInputStream fis = new FileInputStream(new File("src/main/resources/test11.zip"));
            FileOutputStream fos = new FileOutputStream(new File("src/main/resources/test22.zip"));

            BufferedInputStream bin = new BufferedInputStream(fis);
            BufferedOutputStream bos = new BufferedOutputStream(fos);

            int bytesRead = 0;
            byte[] buffer = new byte[1024];

            while((bytesRead = bin.read(buffer, 0, 1024)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

            bos.close();
            bin.close();

            fis.close();
            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

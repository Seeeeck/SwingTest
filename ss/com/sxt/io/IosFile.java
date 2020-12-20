package com.sxt.io;

import java.io.*;

public class IosFile {
    public static void main(String[] args) {
        byte[] a = fileToByteArray("/Users/sunyuqiang/IdeaProjects/SXT_IO/src/IMG_1349.JPG");
        System.out.println(a.length);
        byteArrayToFile(a,"sd.JPG");
    }

    public static byte[] fileToByteArray(String filepath){
        File src = new File(filepath);
        byte[] dest = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try{
            is = new FileInputStream(src);
            baos = new ByteArrayOutputStream();
            byte[] flush = new byte[1024];
            int len = -1;
            while((len=is.read(flush))!=-1){
                baos.write(flush,0,len);
            }
            baos.flush();
            dest = baos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return dest;
    }

    public static void byteArrayToFile(byte[] src,String filepath){
        File dest = new File(filepath);
        InputStream is = null;
        OutputStream os = null;
        try{
            is = new ByteArrayInputStream(src);
            os = new FileOutputStream(dest);
            byte[] flush = new byte[1024];
            int len = -1;
            while((len = is.read(flush))!=-1){
                os.write(flush);
            }
            os.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

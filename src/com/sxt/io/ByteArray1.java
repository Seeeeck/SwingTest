package com.sxt.io;

import java.io.*;

/**
 *
 */
public class ByteArray1 {
    public static void main(String[] args) {

    }

    public static void readbytes(byte[] src){
        InputStream is = null;
        try {
            is = new ByteArrayInputStream(src);
            byte[] flush = new byte[5];
            int len = -1;
            while((len=is.read(flush))!=-1){
                String str = new String(flush,0,len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void outputbytes(byte[] dest){
        ByteArrayOutputStream baos = null;
        try{
            baos = new ByteArrayOutputStream();
            String msg = "dsafdhsges";
            byte[] datas = msg.getBytes();
            baos.write(datas,0,datas.length);
            baos.flush();
            //get the data
            System.out.println(new String(baos.toByteArray(),0,baos.toByteArray().length));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

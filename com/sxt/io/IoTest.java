package com.sxt.io;

import java.io.*;

public class IoTest {
    public static void main(String[] args) {
        writeFile("dd.txt");
        readFile3("/Users/sunyuqiang/IdeaProjects/SXT_IO/src/com/sxt/io/DIrDemo.java");
    }

    public static void readFile(String path){
        File f = new File(path);
        InputStream is = null;
        try {
            is = new FileInputStream(f);
            int temp;
            while((temp=is.read())!=-1){
                System.out.println((char)temp);
            }
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

    }

    public static void readFile2(String path){
        File f = new File(path);
        InputStream is = null;
        int temp;
        try {
            is = new FileInputStream(f);
            temp = is.read();
            if(temp !=-1){
                while(temp!=-1){
                    System.out.println((char)temp);
                    temp = is.read();
                }
            }else{
                System.out.println("");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void readFile3(String path){
        File f = new File(path);
        InputStream is = null;
        try{
            is = new FileInputStream(f);
            byte[] car = new byte[50];
            int len = -1;
            while((len=is.read(car))!=-1){
                String data = new String(car,0,len);
                System.out.print(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try{
                if(is!=null){
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void writeFile(String path){
        File f = new File(path);
        OutputStream os = null;
        try {
            String msg = "dsagdsgdssrsdf\ndsgdg";
            os = new FileOutputStream(f,true);
            byte[] datas = msg.getBytes();
            os.write(datas,0,datas.length);
            os.flush();
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


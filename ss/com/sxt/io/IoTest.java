package com.sxt.io;

import java.io.*;

public class IoTest {
    public static void main(String[] args) {
        writer1("dd1.txt");
        reader1("/Users/sunyuqiang/IdeaProjects/SXT_IO/src/com/sxt/io/DIrDemo.java");
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

    public static void reader1(String path){
        File src = new File(path);
        Reader reader = null;
        try{
            reader = new FileReader(src);
            char[] flush = new char[2];
            int len = -1;
            while ((len = reader.read(flush))!=-1){
                String datas = new String(flush,0,len);
                System.out.print(datas+"-");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void writer1(String path){
        File dest = new File(path);
        Writer writer = null;
        try{
            writer = new FileWriter(dest);
            String msg = "dsfdghjk 范德萨发个地方";
            char[] flush = msg.toCharArray();
            writer.write(flush,0,flush.length);
            writer.write("dfgh");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


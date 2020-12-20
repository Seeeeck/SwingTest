package com.sxt.io;

import java.io.*;
import java.util.Objects;


public class BufferedTest {
    public static void main(String[] args) {
        readText("/Users/sunyuqiang/IdeaProjects/SXT_IO/dd.txt");
        writeText("dsgg.txt");
    }

    public static void copyFile(String srcpath,String destpath){
        File src = new File(srcpath);
        File dest = new File(destpath);
        InputStream is = null;
        OutputStream os = null;
        try{
            is = new BufferedInputStream(new FileInputStream(src));
            int len = -1;
            byte[] flush = new byte[1024];
            os = new BufferedOutputStream(new FileOutputStream(dest));
            while ((len=is.read(flush))!=-1){
                os.write(flush,0,len);
                os.flush();
            }
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


            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


    public static void readText(String path){
        File src = new File(path);
        try(BufferedReader breader = new BufferedReader(new FileReader(src))){
            String line = null;
            //不会包括换行符
            while((line=breader.readLine())!=null){
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeText(String dest){
        File destfile = new File(dest);
        try(BufferedWriter bwriter = new BufferedWriter(new FileWriter(destfile))){
            bwriter.write("dfg");
            bwriter.newLine();
            bwriter.write("sdfgh");
            bwriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

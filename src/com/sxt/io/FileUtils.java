package com.sxt.io;

import java.io.*;
import java.util.Objects;


public class FileUtils {
    public static void main(String[] args) {
        //文件转文件
        try {
            InputStream is = new BufferedInputStream(new FileInputStream("/Users/sunyuqiang/IdeaProjects/SXT_IO/IMG_1349.JPG"));
            OutputStream os = new BufferedOutputStream(new FileOutputStream("/Users/sunyuqiang/IdeaProjects/SXT_IO/IMG_1349_copy.JPG"));
            copyFile(is,os);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //文件转字节
        byte[] data = null;
        try {
            InputStream is = new BufferedInputStream(new FileInputStream("/Users/sunyuqiang/IdeaProjects/SXT_IO/IMG_1349.JPG"));
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            copyFile(is,os);
            data = os.toByteArray();
            System.out.println(data.length);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //字节转文件
        try {
            InputStream is = new BufferedInputStream(new ByteArrayInputStream(data));
            OutputStream os = new BufferedOutputStream(new FileOutputStream("/Users/sunyuqiang/IdeaProjects/SXT_IO/IMG_1349_copy2.JPG"));
            copyFile(is,os);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

    public static void copyFile(InputStream is,OutputStream os){
        //try with resource 自动释放资源
        try(is;os){
            int len = -1;
            byte[] flush = new byte[1024];
            while ((len=is.read(flush))!=-1){
                os.write(flush,0,len);
            }
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void close(Closeable... ios){
        for(Closeable io:ios){
            try {
                if (io != null) {
                    io.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    private static void copy1(String srcpath,String destpath){
        File src = new File(srcpath);
        File dest = new File(destpath);
        if(src.isFile()){
            try {
                copyFile(new FileInputStream(src),new FileOutputStream(dest));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }else if(src.isDirectory()){
            if(!dest.exists()){
                dest.mkdir();
            }
            for(String f: Objects.requireNonNull(src.list())){
                File src1 = new File(src,f);
                File dest1 = new File(destpath,f);

                copy1(src1.getAbsolutePath(),dest1.getAbsolutePath());
            }
        }
    }
}

package com.sxt.io;

import java.io.*;
import java.util.Objects;


public class BufferedTest {
    public static void main(String[] args) {
        copy1("/Users/sunyuqiang/IdeaProjects/SXT_IO/src","/Users/sunyuqiang/IdeaProjects/SXT_IO/ss");
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


    private static void copy1(String srcpath,String destpath){
        File src = new File(srcpath);
        File dest = new File(destpath);
        if(src.isFile()){
            copyFile(srcpath,destpath);
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

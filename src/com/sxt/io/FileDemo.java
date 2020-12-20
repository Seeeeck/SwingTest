package com.sxt.io;

import java.io.File;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args) throws IOException {
        File scr = new File("src/IMG_1349.JPG");
        System.out.println(scr.getName());
        System.out.println(scr.getAbsolutePath());
        System.out.println(scr.getPath());
        System.out.println(scr.getParent());
        System.out.println(scr.getParentFile().getName());

        //文件的状态
        System.out.println(scr.exists());
        System.out.println(scr.isFile());
        System.out.println(scr.isDirectory());
        //バイト数をreturn
        System.out.println(scr.length());
        //新たにファイルを生成する
        File scr2 = new File("src/Io.txt");
        boolean flag = scr2.createNewFile();
        System.out.println(flag);
        scr2.delete();
        System.out.println(scr2.exists());
    }
}

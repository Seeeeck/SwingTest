package com.sxt.io;

import java.io.File;
import java.util.Objects;

public class PrintAllPath {
    public static void main(String[] args) {
        File f = new File("/Users/sunyuqiang/IdeaProjects/SXT_IO");
        printAllPath(f,0);
    }
    public static void printAllPath(File f,int deep){
        for(int i=0;i<deep;i++){
            System.out.print("-");
        }
        System.out.println(f.getAbsolutePath());
        if(f.isDirectory()){
            for(File tf: Objects.requireNonNull(f.listFiles())){
                printAllPath(tf,deep+1);
            }
        }
    }
}

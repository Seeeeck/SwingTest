package com.sxt.io;

import java.io.File;

/**
 * 创建目录
 */
public class DIrDemo {
    public static void main(String[] args) {
        File dir = new File("/Users/sunyuqiang/IdeaProjects/SXT_IO");
        String[] dirs = dir.list();
        for(String dirname:dirs){
            System.out.println(dirname);
        }

        File[] files = dir.listFiles();
        for(File file:files){
            System.out.println(file.getAbsolutePath());
        }


    }
}

package com.sxt.io;

public class ContentEncode {
    public static void main(String[] args) {
        String msg = "俺はお前のことがw";
        byte[] datas = msg.getBytes();
        System.out.println(msg.length());
        System.out.println(datas.length);
        msg = new String(datas);
        System.out.println(msg);
    }
}

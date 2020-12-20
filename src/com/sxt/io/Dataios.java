package com.sxt.io;

import java.io.*;

/**
 * 数据流 DataInputStream DataOutputStream
 * 先写入后读取 写入和读取对顺序需要一致
 *
 */
public class Dataios {
    public static void main(String[] args) throws IOException {
        //写出
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(
                new BufferedOutputStream(baos));
        //操作数据类型+数据
        dos.writeBoolean(false);
        dos.writeInt(52);
        dos.write(222);
        dos.writeBoolean(true);
        dos.writeUTF("sdggsss");
        dos.flush();
        byte[] datas = baos.toByteArray();

        DataInputStream dis = new DataInputStream(
                new BufferedInputStream(new ByteArrayInputStream(datas)));
        boolean a = dis.readBoolean();
        dis.readInt();
        int d = dis.read();
        boolean b = dis.readBoolean();
        String c = dis.readUTF();
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);


    }
}

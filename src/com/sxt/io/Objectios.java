package com.sxt.io;
import java.io.*;
import java.util.ArrayList;

/**
 * 对象流
 * 先写入后读取
 * 读取顺序和写入需保持一致
 * 不是所有对象都可以序列化（Serializable）
 * dataios内的方法也可使用
 */
public class Objectios {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(baos));
        //写入
        oos.close();
        oos.writeObject("dfg");
        oos.writeObject("dfgsagggg");
        Abc a = new Abc(2,"sgh");
        oos.writeObject(a);
        oos.flush();
        byte[] data = baos.toByteArray();
        //读取
        ObjectInputStream ois = new ObjectInputStream(
                new BufferedInputStream(new ByteArrayInputStream(data)));
        Object o1 = ois.readObject();
        Object o2 = ois.readObject();
        Object o3 = ois.readObject();
        ois.close();
        ArrayList<Object> obs = new ArrayList<>();
        obs.add(o1);
        obs.add(o2);
        obs.add(o3);
        for(int i=0;i<3;i++){
            if (obs.get(i) instanceof String){
                String str = (String)obs.get(i);
                System.out.println(str);
            }else if(obs.get(i) instanceof Abc){
                Abc a1 = (Abc)obs.get(i);
                System.out.println("a:"+a1.a+",b:"+a1.b);
            }
        }

    }
}

class Abc implements java.io.Serializable{
    int a;
    transient String b; //改数据不需要序列化
    Abc(int a,String b){
        this.a = a;
        this.b = b;

    }
}
package com.sxt.io;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * 转换流：inputStreamReader OutputStreamWriter
 * 以字符流对形式操作字节流（纯文本）
 * 指定字符集
 */
public class ConvertTest {
    public static void main(String[] args) {
        test2();
    }

    public static void test1(){
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String msg = "";
            while(!msg.equals("exit")){
                msg = br.readLine();
                bw.write(msg);
                bw.newLine();
                bw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void test2(){
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new URL("http://www.baidu.com").openStream(), StandardCharsets.UTF_8));
             BufferedWriter bw = new BufferedWriter(
                     new OutputStreamWriter(
                             new FileOutputStream("baidu.html"), StandardCharsets.UTF_8))) {
            String msg= null;
            while((msg=br.readLine()) != null){
                bw.write(msg);
                bw.newLine();
            }
            bw.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

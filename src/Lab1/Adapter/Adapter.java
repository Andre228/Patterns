package Lab1.Adapter;

import java.io.*;

/**
 * Created by Андрей on 04.03.2020.
 */
public class Adapter {


    public void writeOutputStream(String ...arr) throws IOException {
        OutputStream outputStream = new FileOutputStream("D://JavaSaves//Maga//WriteOutput.txt");

        for (String str: arr) {
            str += " ";
            byte[] buffer = str.getBytes();
            outputStream.write(buffer);
        }
    }


    public void readOutputStream() throws IOException {
        InputStream inputStream = new FileInputStream("D://JavaSaves//Maga//WriteOutput.txt");

        int i=-1;
        while((i=inputStream.read())!=-1){
            System.out.print((char)i);
        }
    }
}

package Lab1.Server;

import org.omg.CORBA.portable.InputStream;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Андрей on 27.03.2020.
 */
public class Server {

    public static void main(String[] args) throws IOException, InterruptedException {

        double a, b, result;
        result = 0;
        System.out.println("Ожидание клиента...");

        ServerSocket serverSocket = new ServerSocket(5000);
        Socket socket = serverSocket.accept();

        System.out.println("Клиент присоединился");


        DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        Scanner sc = new Scanner(System.in);

        String str = "";
        String resp = "response";
        while (!str.equals("quit")) {
           a = in.readDouble();
           b = in.readDouble();
           result = a * b;

            System.out.println("-------------");

            str = in.readUTF();

            System.out.println("<from client>: " + str);

           // str = sc.nextLine();
            if (str.equals("quit")) {
                out.writeUTF("@you result - " + result);
            } else  {
                out.writeUTF("@you message - " + str);
            }
            out.flush();
        }
        System.out.println("Клиент отсоединился");

        socket.close();
        in.close();
        out.close();
        sc.close();

    }
}

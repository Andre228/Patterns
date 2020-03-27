package Lab1.Client;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Андрей on 27.03.2020.
 */
public class ClientCustomer {

    public String toServer( double a, double b) throws IOException {
        Socket socket = new Socket("localhost", 5000);

        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

        Scanner in = new Scanner(System.in);


        String str = "";
        String resp = "";


        while (!str.equals("quit")) {


            out.writeDouble(a);
            out.writeDouble(b);


            str = in.nextLine();
            System.out.println("-------------");
            out.writeUTF(str);

            resp = dis.readUTF();

            if (!resp.contains("@you result")) System.out.println("<from server>: " + resp);
            out.flush();
        }


        socket.close();
        in.close();
        dis.close();
        out.close();


        return resp;
    }
}

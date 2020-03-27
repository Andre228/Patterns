package Lab1.Client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Андрей on 27.03.2020.
 */
public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("<from server>: " + new ProxyClient().send(7, 3));
    }
}

package ch16.assign.client;

import ch16.assign.GlobalScanner;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ProductTCPClient {
    public static void main(String[] args) throws IOException {
        ClientRequest request = ClientRequest.getInstance();
        Scanner sc = GlobalScanner.getInstance().getScanner();
        loop:
        while (true) {
            try (Socket socket = new Socket("localhost", 19999);
                 DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {
                System.out.print("\nEnroll Product : '1', Search Product : '2', Quit : 'q'\n=> ");
                while (true) {
                    String key = sc.next();
                    if (key.equalsIgnoreCase("q")) break loop;
                    if (key.equals("1")) {
                        out.writeUTF(key);
                        request.post(socket);
                        break;
                    }
                    if (key.equals("2")) {
                        out.writeUTF(key);
                        request.get(socket);
                        break;
                    }
                    System.out.println("Enter correct command...\n");
                }
            }
        }
    }
}

package ch16.network.socket.assign;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ProductTCPClient {
    public static void main(String[] args) throws IOException {
        try (Scanner sc = new Scanner(System.in);
             Socket socket = new Socket("localhost", 19999);
             DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {
            ClientRequest request = ClientRequest.getInstance();
            System.out.println("Enroll Product : '1', Search Product : '2', Quit : 'q'");
            while (true) {
                String key = sc.next();
                if (key.equals("q")) break;
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

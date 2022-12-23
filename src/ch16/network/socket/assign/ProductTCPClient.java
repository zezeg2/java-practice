package ch16.network.socket.assign;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ProductTCPClient {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        try(Socket socket = new Socket("localhost", 19999);
            DataOutputStream out = new DataOutputStream(socket.getOutputStream())){
            ClientRequest request = new ClientRequest(socket);
            System.out.println("Enroll Product : '1', Search Product : '2', Quit : 'q'");
            while (true) {
                String key = sc.next();
                if (key.equals("q")) break;
                if (key.equals("1")) {
                    out.writeUTF(key);
                    request.post();
                    break;
                }
                if (key.equals("2")) {
                    out.writeUTF(key);
                    request.get();
                    break;
                }
                System.out.println("Enter correct command...\n");
            }
        }
    }
}

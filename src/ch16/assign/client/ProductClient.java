package ch16.assign.client;

import ch16.assign.GlobalScanner;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ProductClient {
    public static void main(String[] args) throws IOException {
        ClientRequest request = ClientRequest.getInstance();
        GlobalScanner sc = GlobalScanner.getInstance();
        loop:
        while (true) {
            try (Socket socket = new Socket("localhost", 19999);
                 DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {
                while (true) {
                    int key =  sc.nextNumOrCheckReplace("\nEnroll Product : '1', Search Product : '2', Quit : 'q'\n=> ", "q", 0);
                    if (key == 0) break loop;
                    if (key == 1) {
                        out.writeInt(key);
                        request.post(socket);
                        break;
                    }
                    if (key == 2) {
                        out.writeInt(key);
                        request.get(socket);
                        break;
                    }
                    System.out.println("Enter correct command...\n");
                }
            }
        }
    }
}

package ch16.network.socket.assign;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ProductTCPServer {
    public static void main(String[] args) throws IOException {
        ProductService service = ProductService.getInstance();
        try (ServerSocket server = new ServerSocket(19999)) {
            while (true) {
                new Thread(() ->{
                    try(Socket socket = server.accept();
                        DataInputStream in = new DataInputStream(socket.getInputStream())) {
                        int key = Integer.parseInt(in.readUTF());
                        if (key == 1) service.enroll(socket);
                        if (key == 2) service.search(socket);
                    } catch (IOException e) {}
                }).start();
            }
        }
    }
}

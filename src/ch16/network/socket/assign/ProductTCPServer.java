package ch16.network.socket.assign;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ProductTCPServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(19999)) {
            while (true) {
                Socket socket = server.accept();
                DataInputStream in = new DataInputStream(socket.getInputStream());
                ProductService service = new ProductService(socket);
                int key = Integer.parseInt(in.readUTF());
                if (key == 1) service.enroll();
                if (key == 2) service.search();
            }
        }
    }
}

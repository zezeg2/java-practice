package ch16.network.socket.assign;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ProductTCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(19999);
        while (true) {
            Socket socket = server.accept();
            DataInputStream in = new DataInputStream(socket.getInputStream());
            ProductService service = new ProductService(socket);
            Integer key = Integer.valueOf(in.readUTF());
            if (key == 1) service.enroll();
            if (key == 2) service.search();
        }
    }
}

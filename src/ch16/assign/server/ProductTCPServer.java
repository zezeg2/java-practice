package ch16.assign.server;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ProductTCPServer {
    public static void main(String[] args) throws IOException {
        ProductService service = ProductService.getInstance();
        ExecutorService pool = Executors.newFixedThreadPool(1);
        try (ServerSocket server = new ServerSocket(19999)) {
            while (true) {
                pool.execute(() -> {
                    try(Socket socket = server.accept();
                        DataInputStream in = new DataInputStream(socket.getInputStream())) {
                        System.out.printf("%s : Connected with %s:%s\n",Thread.currentThread().getName(), socket.getInetAddress(), socket.getPort());
                        int key = Integer.parseInt(in.readUTF());
                        if (key == 1) service.enroll(socket);
                        if (key == 2) service.search(socket);
                    } catch (IOException e) {
                        System.out.println("IOException invoked");
                    }
                });
            }
        }
    }
}

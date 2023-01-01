package ch16.assign.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProductServerMain {
    public static void main(String[] args) throws IOException {
        ExecutorService pool = Executors.newFixedThreadPool(4);
        try (ServerSocket server = new ServerSocket(19999)) {
            while (true) {
                pool.execute(new ProductServerThread(server.accept()));
            }
        }
    }
}

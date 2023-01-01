package ch16.assign.server;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by jonghyeon on 2023/01/01,
 * Package : ch16.assign.server
 */
public class ProductServerThread extends Thread {

    private final Socket socket;
    private ProductService  service = ProductService.getInstance();

    public ProductServerThread(Socket socket) throws IOException {
        this.socket = socket;
    }

    @Override
    public void run() {
        try(DataInputStream in = new DataInputStream(socket.getInputStream())) {
            System.out.printf("%s : Connected with %s:%s\n",Thread.currentThread().getName(), socket.getInetAddress(), socket.getPort());
            int key = in.readInt();
            if (key == 1) service.enroll(socket);
            if (key == 2) service.search(socket);
        } catch (IOException e) {
        } finally {
            try {
                System.out.printf("%s : Connection to %s:%s is terminated%n", Thread.currentThread().getName(), socket.getInetAddress(), socket.getPort());
                socket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

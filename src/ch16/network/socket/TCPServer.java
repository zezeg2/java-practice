package ch16.network.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(19999)) {
            System.out.println("on port 19999 listening...");
            while (true) {
                Socket accept = server.accept();
                Sender sender = new Sender(accept);
                Receiver receiver = new Receiver(accept);
                sender.start();
                receiver.start();
            }
        }
    }
}

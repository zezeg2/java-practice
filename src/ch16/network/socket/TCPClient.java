package ch16.network.socket;

import java.io.IOException;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        Sender sender;
        Receiver receiver;
        try (Socket socket = new Socket("localhost", 19999)) {
            sender = new Sender(socket);
            receiver = new Receiver(socket);
        }

        sender.start();
        receiver.start();
    }
}

package ch16.network.socket;

import java.io.IOException;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 19999);
        Sender sender = new Sender(socket);
        Receiver receiver = new Receiver(socket);

        sender.start();
        receiver.start();
    }
}

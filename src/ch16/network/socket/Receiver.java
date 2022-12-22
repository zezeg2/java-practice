package ch16.network.socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Receiver extends Thread {
    Socket socket;
    DataInputStream in;
    String name;

    Receiver(Socket socket) {
        this.socket = socket;
        name = "[" + socket.getRemoteSocketAddress() + "]\n";
        try {
            in = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (in != null && !socket.isClosed()) {
            try {
                System.out.println(name + in.readUTF());
            } catch (IOException e) {
                System.out.println("Disconnected with " + name);
                break;
            }
        }
    }
}

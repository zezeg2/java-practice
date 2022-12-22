package ch16.network.socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Sender extends Thread{
    Socket socket;
    DataOutputStream out;
    String name;

    Sender(Socket socket) {
        this.socket = socket;
        try {
            out = new DataOutputStream(socket.getOutputStream());
            name = "[" + socket.getRemoteSocketAddress() + "]\n";
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        System.out.println("Connected with " + name);
        Scanner sc = new Scanner(System.in);
        while (out != null) {
            try {
                out.writeUTF(sc.nextLine());
            } catch (IOException e) {
                break;
            }
        }
    }
}


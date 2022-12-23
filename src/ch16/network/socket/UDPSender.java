package ch16.network.socket;

import java.io.IOException;
import java.net.*;

public class UDPSender {
    public static void main(String[] args) throws IOException {
        DatagramPacket receiveFromReceiver;
        try (DatagramSocket ds = new DatagramSocket()) {
            System.out.println("------- Sender start-------");
            String data = "Message";
            DatagramPacket packet = new DatagramPacket(data.getBytes(), data.length(), new InetSocketAddress("localhost", 8888));
            ds.send(packet);
            receiveFromReceiver = new DatagramPacket(new byte[1000], 1000);
            ds.receive(receiveFromReceiver);
        }
        System.out.println(new String(receiveFromReceiver.getData()).trim());
        System.out.println("------- Sender exit-------");
    }
}

package ch16.network.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UDPReceiver {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(8888);
        System.out.println("------- Receiver start-------");
        DatagramPacket dp = new DatagramPacket(new byte[1000], 1000);
        ds.receive(dp);
        System.out.println(dp.getAddress() + ":" + dp.getPort() + " : Data : " + (new String(dp.getData())).trim());
        String datetime = (new SimpleDateFormat("yyyy:MM:dd - HH:mm:sss")).format(new Date());
        DatagramPacket dtpacket = new DatagramPacket(datetime.getBytes(), datetime.length(), dp.getAddress(), dp.getPort());
        ds.send(dtpacket);
        ds.close();
        System.out.println("------- Receiver exit-------");
    }

}

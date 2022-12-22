package ch16.network.socket.assign;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ProductTCPClient {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 19999);
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        ClientRequest request = new ClientRequest(socket);
        System.out.println("상품등록 : 1, 상품조회 : 2");
        String key;
        while (true) {
            key = sc.next();
            if (key.equals("1")) {
                out.writeUTF(key);
                request.post();
                break;
            }
            if (key.equals("2")) {
                out.writeUTF(key);
                request.get();
                break;
            }
            System.out.println("다시 입력해 주세요");
        }
    }


}

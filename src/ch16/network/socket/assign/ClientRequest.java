package ch16.network.socket.assign;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClientRequest {
    private final Scanner sc = new Scanner(System.in);
    private final DataInputStream in;
    private final DataOutputStream out;

    public ClientRequest(Socket socket) throws IOException {
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
    }

    public void post() throws IOException {
        List<Product> products = new ArrayList<>();
        while (true) {
            products.add(new Product());
            System.out.println("enter the 'y' to add another product");
            if (!sc.next().equals("y")) break;
        }

        out.writeUTF(products.stream()
                .map(product -> String.format("%8s%8s%8s", product.name, product.price, product.stock))
                .reduce("", (s1, s2) -> s1 + s2 + "\n"));
        sc.close();
        System.out.println(in.readUTF());
    }

    public void get() throws IOException {
        System.out.println("조회하실 상품명을 입력해주세요");
        out.writeUTF(sc.next());
        System.out.println("Result : " + in.readUTF());
    }
}

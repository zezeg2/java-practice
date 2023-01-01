package ch16.assign.client;

import ch16.assign.GlobalScanner;
import ch16.assign.Product;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClientRequest {
    private static ClientRequest instance;
    private static final GlobalScanner sc = GlobalScanner.getInstance();

    public static ClientRequest getInstance() {
        if (instance == null) {
            instance = new ClientRequest();
        }
        return instance;
    }

    public ClientRequest() {
    }

    public void post(Socket socket) throws IOException {
        try (DataInputStream in = new DataInputStream(socket.getInputStream());
             DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {
            List<Product> products = new ArrayList<>();
            while (true) {
                products.add(new Product());
                if (!sc.nextStringEqualsWith("enter the 'y' to add another product", "y")) break;
            }
            out.writeUTF(products.stream()
                    .map(product -> String.format("%20s%8s%8s", product.name, product.price, product.stock))
                    .reduce("", (s1, s2) -> s1 + s2 + "\n"));
            System.out.println(in.readUTF());
        }
        socket.close();
    }

    public void get(Socket socket) throws IOException {
        try (DataInputStream in = new DataInputStream(socket.getInputStream());
             DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {
            out.writeUTF(sc.nextString("Enter the Product name : "));
            System.out.println("Result : " + in.readUTF());
        }
        socket.close();
    }
}

package ch16.assign.client;

import ch16.assign.Product;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClientRequest {
    private static ClientRequest instance;
    private static Scanner sc = new Scanner(System.in);

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
                System.out.println("enter the 'y' to add another product");
                if (!sc.next().equalsIgnoreCase("y")) break;
            }
            out.writeUTF(products.stream()
                    .map(product -> String.format("%8s%8s%8s", product.name, product.price, product.stock))
                    .reduce("", (s1, s2) -> s1 + s2 + "\n"));
            System.out.println(in.readUTF());
        }
    }

    public void get(Socket socket) throws IOException {
        try (DataInputStream in = new DataInputStream(socket.getInputStream());
             DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {
            System.out.println("Enter the Product name");
            out.writeUTF(sc.next());
            System.out.println("Result : " + in.readUTF());
        }
    }
}

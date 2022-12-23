package ch16.network.socket.assign;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
    static List<Product> productList = new ArrayList<>();
    private final Socket socket;

    public ProductService(Socket socket) throws IOException {
        this.socket = socket;
        BufferedReader bf = new BufferedReader(new FileReader("C:\\Users\\user\\IdeaProjects\\java-practice\\product.txt"));
        while (true) {
            String data = bf.readLine();
            if (data == null) break;
            String[] element = data.replaceAll("\\s+", " ").split(" ");
            productList.add(new Product(element[1], Integer.parseInt(element[2]), Integer.parseInt(element[3]), socket.getLocalSocketAddress().toString()));
        }
    }
    public void enroll() throws IOException {
        try (DataInputStream in = new DataInputStream(socket.getInputStream());
             DataOutputStream out = new DataOutputStream(socket.getOutputStream());
             FileWriter writer = new FileWriter("product.txt", true)) {
            String productByLine = in.readUTF();
            for (String product : productByLine.split("\n")) {
                writer.write(product + "\n");
            }
            out.writeUTF("Your Product is Successfully Enrolled");
        }
    }
    public void search() throws IOException {
        try (DataInputStream in = new DataInputStream(socket.getInputStream());
             DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {
            String findKeyword = in.readUTF();
            for (Product p : productList.stream().filter(product -> product.name.equals(findKeyword)).toList()) {
                out.writeUTF(p.toString());
            }
        }
    }
}

package ch16.assign.server;

import ch16.assign.Product;

import java.io.*;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ProductService {
    private static ProductService instance;

    public static ProductService getInstance() throws IOException {
        if (instance == null) {
            instance = new ProductService();
        }
        return instance;
    }

    static List<Product> productList = new CopyOnWriteArrayList<>();

    private ProductService() throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("product.txt"));
        while (true) {
            String data = bf.readLine();
            if (data == null) break;
            String[] element = data.replaceAll("\\s+", " ").split(" ");
            productList.add(new Product(element[1], Integer.parseInt(element[2]), Integer.parseInt(element[3])));
        }
    }

    public void enroll(Socket socket) throws IOException {
        try (DataInputStream in = new DataInputStream(socket.getInputStream());
             DataOutputStream out = new DataOutputStream(socket.getOutputStream());
             FileWriter writer = new FileWriter("product.txt", true)) {
            String productByLine = in.readUTF();
            for (String product : productByLine.split("\n")) writer.write(product + "\n");
            out.writeUTF("Your Product is Successfully Enrolled");
        }
    }

    public void search(Socket socket) throws IOException {
        try (DataInputStream in = new DataInputStream(socket.getInputStream());
             DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {
            String findKeyword = in.readUTF();
            String result = "";
            for (Product p : productList.stream().filter(product -> product.name.equals(findKeyword)).toList()) {
                result +=  "\n" + p.toString();
            }
            if (result.equals("")) out.writeUTF("Not Found Product...");
            out.writeUTF(result);
        }
    }
}

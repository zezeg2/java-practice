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
            String line = bf.readLine();
            if (line == null) break;
            productList.add(productFromLine(line));
        }
    }

    public void enroll(Socket socket) throws IOException {
        try (DataInputStream in = new DataInputStream(socket.getInputStream());
             DataOutputStream out = new DataOutputStream(socket.getOutputStream());
             FileWriter writer = new FileWriter("product.txt", true)) {
            String productByLine = in.readUTF();
            for (String line : productByLine.split("\n")) {
                writer.write(line + "\n");
                Product product = productFromLine(line);
                productList.add(product);
                System.out.printf("%s : %s enrolled by %s:%s\n",Thread.currentThread().getName(), product, socket.getInetAddress(), socket.getPort());
            }
            out.writeUTF("Your Product is Successfully Enrolled");
        }
    }

    public void search(Socket socket) throws IOException {
        try (DataInputStream in = new DataInputStream(socket.getInputStream());
             DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {
            String findKeyword = in.readUTF();
            StringBuilder result = new StringBuilder();
            for (Product p : productList.stream().filter(product -> product.name.equals(findKeyword)).toList()) {
                result.append("\n").append(p.toString());
            }
            if (result.toString().equals("")) out.writeUTF("Not Found Product...");
            out.writeUTF(result.toString());
        }
    }

    private Product productFromLine(String line){
        String[] element = line.replaceAll("\\s+", " ").split(" ");
        return new Product(element[1], Integer.parseInt(element[2]), Integer.parseInt(element[3]));
    }
}

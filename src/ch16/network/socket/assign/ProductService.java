package ch16.network.socket.assign;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        FileWriter writer = new FileWriter("product.txt", true);
        try {
            String productByLine = in.readUTF();
            Arrays.stream(productByLine.split("\n")).forEach(product -> {
                product.replaceAll("\\s+", " ").split(" ");
                try {
                    writer.write(product + "\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (Exception e) {
            return;
        }
        out.writeUTF("Your Product is Successfully Enrolled");
        writer.close();
    }

    public void search() throws IOException {
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        String findKeyword = in.readUTF();
        for (Product p : productList.stream().filter(product -> product.name.equals(findKeyword)).toList()){
            out.writeUTF(p.toString());
        }
    }
}

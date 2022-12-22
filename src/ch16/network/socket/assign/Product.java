package ch16.network.socket.assign;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Product implements Serializable {
    String name, seller;
    int price, stock;
    public Product(String name, int price, int stock, String seller) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.seller = seller;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", seller='" + seller + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }

    public Product(String seller) {
        this.seller = seller;
        Scanner sc = new Scanner(System.in);
        List<String> info = Stream.of("상품명", "가격", "재고").map(s -> {
            System.out.print(s + " : ");
            return sc.next();
        }).collect(Collectors.toList());
        name = info.get(0);
        price = Integer.parseInt(info.get(1));
        stock = Integer.parseInt(info.get(2));
    }
}

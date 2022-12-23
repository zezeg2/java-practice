package ch16.assign;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Product implements Serializable {
    public String name;
    public int price, stock;

    public Product(String name, int price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }

    public Product() {
        Scanner sc = new Scanner(System.in);
        List<String> info = Stream.of("상품명", "가격", "재고").map(s -> {
            System.out.print(s + " : ");
            return sc.next();
        }).toList();
        name = info.get(0);
        price = Integer.parseInt(info.get(1));
        stock = Integer.parseInt(info.get(2));
    }
}
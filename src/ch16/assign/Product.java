package ch16.assign;

import java.io.Serializable;

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
        GlobalScanner sc = GlobalScanner.getInstance();
        name = sc.nextString("name : ");
        price = sc.nextNum("price : ");
        stock = sc.nextNum("stock : ");
    }
}

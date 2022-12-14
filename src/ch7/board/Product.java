package ch7.board;

public class Product extends Information{
    private int price;

    public Product(String id, String name, int price) {
        super(id, name);
        this.price = price;
    }

    @Override
    public String print() {
        return super.print() + String.format("%d",price);
    }
}

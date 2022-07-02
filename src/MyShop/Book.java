package MyShop;

public class Book extends Product {
    public Book(String name, int price, int weight) {
        super(name, price, weight);
    }
    public String getCategory () {
        String category = "книга";
        return category;
    }
    @Override
    public int getsLife() {
        int sLife = -1;
        return sLife;
    }
    @Override
    public String toString() {
        return getName() + " " + getPrice() + " " + getWeight() + "гр.";}
    }


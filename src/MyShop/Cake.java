package MyShop;

public class Cake extends Product {
    public Cake(String name, int price, int weight, int sLife) {
        super(name, price, weight, sLife);
    }
    public String getCategory () {
        String category = "торт";
        return category;
    }
    @Override
    public String toString() {
        return getName() + " " + getPrice() + " " + getWeight() + "гр.";
    }
}

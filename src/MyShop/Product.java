package MyShop;

import java.io.Serializable;
import java.util.Objects;

public abstract class Product implements Serializable {
    private String name;
    private int price;
    private int weight;
    private int sLife;

    public Product(String name, int price, int weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }
    public Product(String name, int price, int weight, int sLife) {
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.sLife = sLife;
    }
    public String getName () {
        return name;
    }
    public int getPrice () {
        return price;
    }
    public int getWeight () {
        return weight;
    }
    public int getsLife() {
        return sLife;
    }
    public String toString() {
       return name + " " + price + " " + weight + "гр. ";
}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return price == product.price && weight == product.weight && name.equals(product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, weight);
    }
}

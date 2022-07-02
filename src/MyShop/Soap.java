package MyShop;

public class Soap extends Product {
    public Soap (String name, int price, int weight) {
        super (name, price, weight);
    }
    public String getCategory () {
        String category = "мыло";
        return category;
    }
    @Override
    public int getsLife() {
        int sLife = -1;
        return sLife;
    }
   @Override
   public String toString() {
        return getName() + " " + getPrice() + " " + getWeight() + "гр.";
   }
}




package MyShop;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Store implements Store_cake, Store_book, Story_soap, Product_exp, Serializable {
    private static final long serialVersionUID = 1L;
    Map<String, List<Product>> mapProduct = new HashMap<>();
    int y;
    public Store(int y1) {
        this.y = y1;
    }
    public ArrayList<Product> things = new ArrayList<>();
    @Override
    public void setSoap(String a, int b, int c) {
        try {
            Soap d = new Soap(a, b, c);
            if (things.size() < y) {
                things.add(d);
                for (String word : a.split(" ")) {
                    if (!mapProduct.containsKey(word)) {
                         mapProduct.put(word, new ArrayList<>());
                    }
                    mapProduct.get(word).add(d);
                }
            } else throw new ProductAddException(y);
        } catch (ProductAddException t) {
            System.out.println(t.getMessage());
        }
    }
    @Override
    public void setBook(String a, int b, int c) {
        try {
            Book d = new Book(a, b, c);
            if (things.size() < y) {
                things.add(d);
                for (String word : a.split(" ")) {
                    if (!mapProduct.containsKey(word)) {
                        mapProduct.put(word, new ArrayList<>());
                    }
                    mapProduct.get(word).add(d);
                }
            } else throw new ProductAddException(y);
        } catch (ProductAddException t) {
            System.out.println(t.getMessage());
        }
    }
    @Override
    public void setCake(String a, int b, int c, int m) {
        try {
            Cake d = new Cake(a, b, c, m);
            if (things.size() < y) {
                things.add(d);
                for (String word : a.split(" ")) {
                if (!mapProduct.containsKey(word))
                {
                    mapProduct.put(word, new ArrayList<>());
                }
                mapProduct.get(word).add(d);
            }
            } else throw new ProductAddException(y);
        } catch (ProductAddException t) {
            System.out.println(t.getMessage());
        }
    }
    public void amount() {
        System.out.println("Количество товаров в магазине: " + things.size());
    }
    public void searchPrice(int a) {
        ArrayList<Product> sPrice= new ArrayList<>();
        for (Product s : things) {
            if (s.getPrice() < a) {
                sPrice.add(s);
            }
        }
        System.out.println("Товары с ценой, меньше " + a + ":\n" + sPrice);
    }
    public void searchText(String a) {
        System.out.println("Найдено по соответствию: ");
        List<Product> aw = mapProduct.entrySet().stream()
                .filter(x-> x.getKey().toLowerCase().contains(a.toLowerCase()))
                .map(Map.Entry::getValue)
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println(aw);
//        for (String key: mapProduct.keySet()) {
//           if (key.toLowerCase().contains(a.toLowerCase())) {
//               System.out.println(mapProduct.get(key));
//           }
//        }
    }
    @Override
    public void searchSlife(int w) {
        ArrayList<Product> goods = new ArrayList<>();
        for (Product s : things) {
            if ((s.getsLife() > w) || (s.getsLife() == -1)) {
                goods.add(s);
            }
        }
        System.out.println("Товары с неистекшим сроком годности: \n" + goods);
    }
    @Override
    public void searchBook() {
        ArrayList<Book> books = new ArrayList<>();
        for (Product s : things) {
            if (s instanceof Book)
                books.add((Book) s);
        }
        System.out.println("Книги в магазине: \n" + books);
    }
    @Override
    public void searchSoap() {
        ArrayList<Soap> soaps = new ArrayList<>();
        for (Product s : things) {
            if (s instanceof Soap)
                soaps.add((Soap) s);
        }
        System.out.println("Мыла в магазине: \n" + soaps);
    }
    @Override
    public void searchCake() {
        ArrayList<Cake> cakes = new ArrayList<>();
        for (Product s : things) {
            if (s instanceof Cake)
                cakes.add((Cake) s);
        }
        System.out.println("Торты в магазине: \n" + cakes);
    }
    public void deleteProduct(String a) {
        try {
            Iterator<Product> productIterator = things.iterator();
            int x = 0;
            while (productIterator.hasNext()) {
                Product d = productIterator.next();
                if (d.getName().toLowerCase().contains(a.toLowerCase())) {
                    productIterator.remove();
                    x++;
                    for (List<Product> products : mapProduct.values()) {
                        products.removeIf(i -> (i.equals(d)));
                    }
                }
                mapProduct.entrySet().removeIf(y -> (y.getValue().isEmpty()));
            }
            if (x == 0) {
                throw new DeleteProductException(a);
            }
        } catch (DeleteProductException b) {
            System.out.println(b.getMessage());
        } finally {
            amount();
        }
    }
    public void save() {
        File file = new File("storeFile.txt");
        try {
            ObjectOutputStream st = new ObjectOutputStream(new FileOutputStream(file));
            st.writeObject(this);
            st.close();
            System.out.println("Магазин успешно сохранен");
        } catch (IOException a) {
            System.out.println("Ошибка сохранения магазина" + a.getMessage());
        }

    }
    public static void loadFromFile() {
        try {
            ObjectInputStream obj = new ObjectInputStream(new FileInputStream("storeFile.txt"));
            Store newStore = (Store) obj.readObject();
            obj.close();
            System.out.println("Магазин успешно загружен! \n");
        } catch (IOException | ClassNotFoundException a) {
            a.printStackTrace();
        }
    }
  public void showMap () {
     System.out.println(mapProduct);
  }
    
}















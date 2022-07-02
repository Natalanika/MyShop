package MyShop;

import java.io.IOException;

public class StoreExample {
        public static void main(String[] args) throws IOException, ClassNotFoundException {
            Store Spar = new Store(10);
            Spar.setCake("Трюфа торт", 250, 80, 8);
            Spar.setCake("Трюф торт", 230, 80, 8);
            Spar.setSoap("Абсолют мыло", 100, 50);
            Spar.setSoap("Дегтярное мыло", 110, 50);
            Spar.setBook("Чиполлино", 200, 30);
            Spar.setSoap("Camey мыло", 90, 40);
            Spar.setBook("Война и мир", 200, 30);
            Spar.setCake("Трюфельный торт", 250, 80, 8);
            Spar.setCake("Прага", 350, 70, 5);
            Spar.searchPrice(210);
            Spar.searchSlife(6);
            Spar.searchBook();
            Spar.searchSoap();
            Spar.searchCake();
            Spar.deleteProduct("абс");
            Spar.deleteProduct("rfc");
            Spar.save();
           Store.loadFromFile();
            Spar.searchText ("Мыл");
     //       Spar.showMap();

    }}




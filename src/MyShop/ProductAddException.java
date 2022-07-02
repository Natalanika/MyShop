package MyShop;

public class ProductAddException extends Exception {
    public ProductAddException(int d) {
        super ("Достигнут лимит вместимости магазина в " + d + " штук. Дальнейшее добавление товара невозможно!");
    }

}

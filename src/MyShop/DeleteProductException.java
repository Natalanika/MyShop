package MyShop;

public class DeleteProductException extends Exception {
    public DeleteProductException (String m) {
        super ("В магазине не найдено продуктов, содержащих в названии " + m + " ");
    }


}

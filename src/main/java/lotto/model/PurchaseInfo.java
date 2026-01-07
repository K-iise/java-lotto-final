package lotto.model;

public class PurchaseInfo {

    private final int price;
    private final int quantity;

    private PurchaseInfo(int price, int quantity) {
        this.price = price;
        this.quantity = quantity;
    }

    public static PurchaseInfo priceOf(String input){
        int price = Integer.parseInt(input);
        int quantity = price / 1000;
        return new PurchaseInfo(price, quantity);
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}

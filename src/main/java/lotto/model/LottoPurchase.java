package lotto.model;

public class LottoPurchase {

    private final int price;
    private final int quantity;

    private LottoPurchase(int price, int quantity) {
        this.price = price;
        this.quantity = quantity;
    }

    public static LottoPurchase priceOf(String input){
        int price = Integer.parseInt(input);
        int quantity = price / 1000;
        return new LottoPurchase(price, quantity);
    }
}

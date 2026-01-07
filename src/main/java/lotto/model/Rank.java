package lotto.model;

public enum Rank {
    FIFTH(3, false, 5000),
    FOURTH(4, false, 50000),
    THIRD(5, false, 1500000),
    SECOND(5, true, 30000000),
    FIRST(6, false, 2000000000);

    Rank(int count, boolean bonusCheck, int price) {
        this.count = count;
        this.bonusCheck = bonusCheck;
        this.price = price;
    }

    private final int count;
    private final boolean bonusCheck;
    private final int price;

    public static Rank fromWinning(int count, boolean bonus) {
        if (count == 3){
            return FIFTH;
        }
        if (count == 4) {
            return FOURTH;
        }

        if (count == 5 && !bonus) {
            return THIRD;
        }

        if (count == 5){
            return SECOND;
        }

        if (count == 6) {
            return FIRST;
        }
        return null;
    }

    public int getCount() {
        return count;
    }

    public int getPrice() {
        return price;
    }
}

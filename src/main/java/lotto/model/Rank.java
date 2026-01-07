package lotto.model;

public enum Rank {
    FIFTH(3, false, 5000),
    FOURTH(4, false, 50000),
    THIRD(5, false, 1500000),
    SECOND(5, true, 30000000),
    FIRST(6, false, 2000000000),
    MISS(0, false, 0);

    Rank(int count, boolean bonusCheck, int price) {
        this.count = count;
        this.bonusCheck = bonusCheck;
        this.price = price;
    }

    private final int count;
    private final boolean bonusCheck;
    private final int price;

    public static Rank fromWinning(int count, boolean bonus) {
        if (count == 6) return FIRST;
        if (count == 5 && bonus) return SECOND;
        if (count == 5) return THIRD;
        if (count == 4) return FOURTH;
        if (count == 3) return FIFTH;

        return MISS; // null 대신 MISS 반환
    }

    public int getCount() {
        return count;
    }

    public int getPrice() {
        return price;
    }
}

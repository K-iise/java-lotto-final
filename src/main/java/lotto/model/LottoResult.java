package lotto.model;

import java.util.EnumMap;

public class LottoResult {
    private EnumMap<Rank, Integer> resultMap;
    private int profit;

    public LottoResult(EnumMap<Rank, Integer> resultMap) {
        this.resultMap = resultMap;
    }

    public EnumMap<Rank, Integer> getResultMap() {
        return resultMap;
    }
}

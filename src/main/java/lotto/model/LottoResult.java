package lotto.model;

import java.util.EnumMap;

public class LottoResult {
    private EnumMap<Rank, Integer> resultMap;
    private int profit;

    public LottoResult(EnumMap<Rank, Integer> resultMap) {
        this.resultMap = ensureAllRanksPresent(resultMap);
    }

    private EnumMap<Rank, Integer> ensureAllRanksPresent(EnumMap<Rank, Integer> resultMap) {
        EnumMap<Rank, Integer> completeMap = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            if (rank != Rank.MISS) {
                completeMap.put(rank, resultMap.getOrDefault(rank, 0));
            }
        }
        return completeMap;
    }

    public EnumMap<Rank, Integer> getResultMap() {
        return resultMap;
    }
}

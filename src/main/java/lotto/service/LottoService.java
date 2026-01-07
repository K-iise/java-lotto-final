package lotto.service;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.Lottos;
import lotto.model.PurchaseInfo;
import lotto.model.Rank;
import lotto.model.WinningLotto;

public class LottoService {

    public Lottos purchaseLotto(PurchaseInfo purchaseInfo){
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < purchaseInfo.getQuantity(); i++) {
            lottoList.add(Lotto.generateLotto());
        }
        return new Lottos(lottoList);
    }

    public LottoResult checkResult(Lottos lottos, WinningLotto winningLotto) {

        EnumMap<Rank, Integer> rankMap = new EnumMap<>(Rank.class);
        int profit = 0;
        for (Lotto lotto : lottos.getLottoList()) {
            Rank rank = winningLotto.checkLotto(lotto);
            profit += rank.getPrice();
            rankMap.put(rank, rankMap.getOrDefault(rank , 0) + 1);
        }
        return new LottoResult(rankMap, profit);
    }
}

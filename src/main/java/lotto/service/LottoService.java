package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.PurchaseInfo;

public class LottoService {

    public Lottos purchaseLotto(PurchaseInfo purchaseInfo){
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < purchaseInfo.getQuantity(); i++) {
            lottoList.add(Lotto.generateLotto());
        }
        return new Lottos(lottoList);
    }
}

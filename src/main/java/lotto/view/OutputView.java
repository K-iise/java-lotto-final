package lotto.view;

import java.util.List;
import java.util.StringJoiner;
import lotto.model.Lotto;
import lotto.model.Lottos;

public class OutputView {

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void printPurchaseLotto(Lottos lottos) {
        List<Lotto> lottoList = lottos.getLottoList();

        System.out.println("\n" + lottoList.size() + "개를 구매했습니다.");

        for (Lotto lotto : lottoList) {
            System.out.println(lotto.toString());
        }
    }
}

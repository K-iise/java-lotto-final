package lotto.view;

import java.util.EnumMap;
import java.util.List;
import java.util.StringJoiner;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.Lottos;
import lotto.model.Rank;

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

    public void printLottoResult(LottoResult lottoResult) {
        System.out.println("\n당첨 통계");
        System.out.println("---");

        EnumMap<Rank, Integer> enumMap = lottoResult.getResultMap();

        for (Rank rank : Rank.values()) {
            System.out.println(rank.getCount() + "개 일치 ");
            System.out.println(rank.getPrice() + " - ");
            System.out.println(enumMap.get(rank) + "개");
        }
    }
}

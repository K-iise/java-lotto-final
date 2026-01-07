package lotto.view;

import java.text.DecimalFormat;
import java.util.EnumMap;
import java.util.List;
import java.util.StringJoiner;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.Lottos;
import lotto.model.PurchaseInfo;
import lotto.model.Rank;

public class OutputView {

    private DecimalFormat df = new DecimalFormat("(###,###원)");

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

    public void printLottoResult(LottoResult lottoResult, PurchaseInfo purchaseInfo) {
        System.out.println("\n당첨 통계");
        System.out.println("---");

        EnumMap<Rank, Integer> enumMap = lottoResult.getResultMap();

        for (Rank rank : Rank.values()) {
            if (rank == Rank.MISS)
                continue;

            System.out.print(rank.getCount() + "개 일치");
            if (rank == Rank.SECOND) {
                System.out.print(", 보너스 볼 일치");
            }
            System.out.print(" " + df.format(rank.getPrice()) + " - ");
            System.out.println(enumMap.get(rank) + "개");
        }
        double profit = (double) lottoResult.getProfit() / purchaseInfo.getPrice() * 100;
        String result = String.format("%.1f", profit);
        System.out.println("총 수익률은 " + result + "%입니다.");
    }
}

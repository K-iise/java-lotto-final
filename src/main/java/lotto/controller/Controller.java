package lotto.controller;

import lotto.model.Lottos;
import lotto.model.PurchaseInfo;
import lotto.service.LottoService;
import lotto.service.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final Validator validator;
    private final LottoService lottoService;

    public Controller(InputView inputView, OutputView outputView, Validator validator, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.validator = validator;
        this.lottoService = lottoService;
    }

    public void run() {
        String purchasePrice = loopPrice();
        PurchaseInfo purchaseInfo = PurchaseInfo.priceOf(purchasePrice);

        Lottos lottos = lottoService.purchaseLotto(purchaseInfo);
    }

    public String loopPrice(){
        while (true) {
            try {
                String input = inputView.readPurchase();
                validator.validatePrice(input);
                return input;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}

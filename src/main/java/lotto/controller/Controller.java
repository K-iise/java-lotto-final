package lotto.controller;

import lotto.model.Lottos;
import lotto.model.PurchaseInfo;
import lotto.model.WinningLotto;
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
        // 구입 금액 입력
        String purchasePrice = loopPrice();
        PurchaseInfo purchaseInfo = PurchaseInfo.priceOf(purchasePrice);

        // 로또 구매
        Lottos lottos = lottoService.purchaseLotto(purchaseInfo);
        outputView.printPurchaseLotto(lottos);

        // 당첨 번호 설정
        WinningLotto winningLotto = loopWiningLotto();
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

    public WinningLotto loopWiningLotto(){
        while (true) {
            try {
                String winningNumber = loopWiningNumber();
                String bonusNumber = loopBonusNumber(winningNumber);
                return WinningLotto.winningOfBonus(winningNumber, bonusNumber);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private String loopWiningNumber(){
        while (true) {
            try {
                String winingNumber = inputView.readWiningNumber();
                validator.validateWiningNumber(winingNumber);
                return winingNumber;
            }
            catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private String loopBonusNumber(String winningNumber){
        while (true) {
            try {
                String bonusNumber = inputView.readBonusNumber();
                validator.validateBonusNumber(bonusNumber, winningNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

}

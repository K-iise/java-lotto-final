package lotto.controller;

import lotto.service.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final Validator validator;

    public Controller(InputView inputView, OutputView outputView, Validator validator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.validator = validator;
    }

    public void run() {
        String purchasePrice = loopPrice();
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

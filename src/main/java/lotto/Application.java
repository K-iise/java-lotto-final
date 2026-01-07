package lotto;

import lotto.controller.Controller;
import lotto.service.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Validator validator = new Validator();

        Controller controller = new Controller(inputView, outputView, validator);
        controller.run();
    }
}

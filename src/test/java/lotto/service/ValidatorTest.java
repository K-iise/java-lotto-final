package lotto.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidatorTest {

    @Test
    public void 로또_구입_문자_예외_테스트(){
        String input = "abs";
        Validator validator = new Validator();

        Assertions.assertThatThrownBy(() -> validator.validatePrice(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 로또_구입_숫자_예외_테스트(){
        String input = "1500";
        Validator validator = new Validator();

        Assertions.assertThatThrownBy(() -> validator.validatePrice(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

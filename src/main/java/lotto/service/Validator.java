package lotto.service;

public class Validator {
    public void validatePrice(String input){
        try {
            int price = Integer.parseInt(input);

            if (price % 1000 != 0) {
                throw new IllegalArgumentException("[Error] 로또 구입 금액은 1,000원 단위로 입력해야 합니다.");
            }

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 숫자여야 합니다.");
        }
    }

}

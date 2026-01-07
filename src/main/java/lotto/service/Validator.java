package lotto.service;

import java.util.HashSet;
import java.util.Set;

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

    public void validateWiningNumber(String input) {
        String[] number = input.split(",");

        if (number.length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }

        Set<Integer> fake = new HashSet<>();

        try {
            for (String num : number) {
                int n = Integer.parseInt(num);
                fake.add(n);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자여야 합니다.");
        }


        if (fake.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다.");
        }

    }

    public void validateBonusNumber(String bonus, String winningNumber) {
        try {
            int bonusNumber = Integer.parseInt(bonus);
            String[] numbers = winningNumber.split(",");

            for (String number : numbers) {
                int num = Integer.parseInt(number);
                if (num == bonusNumber) {
                    throw new IllegalArgumentException("[ERROR] 당첨 번호와 보너스 번호는 중복될 수 없습니다.");
                }
            }

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }
    }
}

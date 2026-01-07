package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WinningLotto {
    private final List<Integer> numbers;
    private final int bonusNumber;

    private WinningLotto(List<Integer> numbers, int bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto winningOfBonus(String winningNumber, String bonusNumber){
        String[] numbers = winningNumber.split(",");
        List<Integer> numList = new ArrayList<>();
        for (String number : numbers) {
            int num = Integer.parseInt(number);
            numList.add(num);
        }
        Collections.sort(numList);
        int bonus = Integer.parseInt(bonusNumber);
        return new WinningLotto(numList, bonus);
    }
}

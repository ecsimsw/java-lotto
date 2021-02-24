package view;

import domain.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static Money inputPurchaseMoney() {
        System.out.println("구입 금액을 입력해 주세요.");
        long money = Long.parseLong(SCANNER.nextLine());
        return new Money(money);
    }

    public static WinningLotto inputWinningLotto() {
        return new WinningLotto(inputLotto(), inputBonusBall());
    }

    private static Lotto inputLotto() {
        System.out.println("지난 주 당첨 로또를 입력해주세요.");

        String input = SCANNER.nextLine();
        List<LottoNumber> lottoNumbers = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .map(LottoNumber::from)
                .collect(Collectors.toList());

        return new Lotto(new LottoNumbers(lottoNumbers));
    }

    private static LottoNumber inputBonusBall() {
        System.out.println("보너스 볼을 입력해주세요.");
        return LottoNumber.from(SCANNER.nextInt());
    }
}

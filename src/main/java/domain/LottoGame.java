package domain;

public class LottoGame {
    private static final int PRICE = 1000;

    public LottoGame() {
    }

    public Lottos purchaseLottos(Money amount) {
        int count = amount.divide(PRICE);
        return LottoFactory.generates(new DefaultShuffleStrategy(), count);
    }

    public LottoResult calculateResult(WinningLotto winningLotto, Lottos purchasedLottos) {
        LottoWinningTable winningTable = purchasedLottos.makeWinningTable(winningLotto);
        double earningRate = calculateEarningRate(winningTable, purchasedLottos);

        return new LottoResult(winningTable, earningRate);
    }

    private double calculateEarningRate(LottoWinningTable winningTable, Lottos purchasedLottos) {
        Money revenue = winningTable.getTotalWinningMoney();
        return revenue.calculateEarningRate(findUsedMoney(purchasedLottos));
    }

    private Money findUsedMoney(Lottos purchasedLottos) {
        int count = purchasedLottos.getNumberOfLotto();
        return new Money(count * PRICE);
    }
}
package domain;

import domain.lottoGame.Lotto;
import domain.lottoGame.LottoNumber;
import domain.lottoGame.LottoRank;
import domain.lottoGame.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class WinningLottoTest {

    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = new Lotto(new int[]{1, 2, 3, 4, 5, 6});
    }

    @DisplayName("우승 로또를 생성하는 기능")
    @Test
    void generate() {
        // given
        LottoNumber bonusBall = new LottoNumber(7);

        // when
        WinningLotto winningLotto = new WinningLotto(lotto, bonusBall);

        // then
        assertThat(winningLotto).isNotNull();
    }

    @DisplayName("우승 로또의 당첨번호안에 보너스볼이 포함되는 경우")
    @Test
    void generateWithLottoNumbersContainBonusBall() {
        //given
        LottoNumber bonusBall = new LottoNumber(6);

        //when //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningLotto(lotto, bonusBall));

    }

    @DisplayName("당첨번호와 일치하는 숫자의 개수를 파악하는 기능")
    @Test
    void findMatchCount() {
        //given
        LottoNumber bonusBall = new LottoNumber(7);
        WinningLotto winningLotto = new WinningLotto(lotto, bonusBall);

        Lotto targetLotto = new Lotto(new int[]{1, 2, 3, 4, 5, 6});

        // when
        LottoRank lottoRank = LottoRank.valueOf(winningLotto, targetLotto);

        // then
        assertThat(lottoRank).isEqualTo(LottoRank.FIRST);
    }
}

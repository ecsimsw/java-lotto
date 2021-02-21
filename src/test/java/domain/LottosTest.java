package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    private List<Lotto> lottoGroup;
    private Lottos lottos;

    @BeforeEach
    void setUp() {
        lottoGroup = Arrays.asList(
                new Lotto(new int[]{1, 2, 3, 4, 5, 6}),
                new Lotto(new int[]{7, 8, 9, 10, 11, 12}),
                new Lotto(new int[]{13, 14, 15, 16, 17, 18})
        );

        lottos = new Lottos(lottoGroup);
    }

    @DisplayName("Lottos를 생성하는 기능")
    @Test
    void generate() {
        //when
        Lottos lottos = new Lottos(lottoGroup);

        //then
        assertThat(lottos).isNotNull();
    }

    @DisplayName("로또 당첨 결과를 반환하는 기능")
    @Test
    void getLottoResults() {
        //given
        Lotto lotto = new Lotto(new int[]{1, 2, 3, 4, 5, 6});
        WinningLotto winningLotto = new WinningLotto(lotto, new LottoNumber(7));

        //when
        LottoWinningTable results = lottos.makeWinningTable(winningLotto);

        //then
        assertThat(results.getValues().get(LottoRank.FIRST)).isEqualTo(1L);
        assertThat(results.getValues().get(LottoRank.MISS)).isEqualTo(2L);
    }
}

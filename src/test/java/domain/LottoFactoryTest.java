package domain;

import domain.lottoGame.LottoFactory;
import domain.lottoGame.LottoNumber;
import domain.lottoGame.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LottoFactoryTest {

    @DisplayName("로또 생성")
    @Test
    void generateLotto() {
        //given
        List<LottoNumber> numbers = Arrays.asList(1, 2, 3, 4, 5, 6).stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        int lottoCount = 3;

        //when
        Lottos lottos = LottoFactory.generates(lottoNumbers -> numbers, lottoCount);

        //then
        assertThat(lottos).isNotNull();
    }
}
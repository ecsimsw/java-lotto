package domain;

import domain.lottoGame.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class LottoNumberTest {

    @DisplayName("LottoNumber를 생성하는 기능")
    @Test
    void generate() {
        //given
        int bonusBallValue = 7;

        //when
        LottoNumber lottoNumber = new LottoNumber(bonusBallValue);

        //then
        assertThat(lottoNumber).isNotNull();
    }

    @DisplayName("LottoNumber가 유효 범위의 숫자가 아닌 경우")
    @ParameterizedTest
    @ValueSource(ints = {
            -1, 0, 46
    })
    void generateWithLottoNumberNotInRange(int lottoNumberValue) {
        //when //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumber(lottoNumberValue));
    }
}
package lotto.exceptions;

public class LottoNumberException extends IllegalArgumentException {
    public LottoNumberException() {
    }

    public LottoNumberException(String message) {
        super(message);
    }

    public LottoNumberException(String message, Throwable cause) {
        super(message, cause);
    }

    public LottoNumberException(Throwable cause) {
        super(cause);
    }
}
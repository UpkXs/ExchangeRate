package aro.exchangeRate.error;

public class CurrencyApiException extends RuntimeException {

    public CurrencyApiException(String message, Throwable cause) {
        super(message, cause);
    }

}

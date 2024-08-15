package aro.exchangeRate.register;

import aro.exchangeRate.enums.Currency;
import aro.exchangeRate.model.ExchangeRateResult;

public interface ExchangeRateRegister {

    ExchangeRateResult getLast10DaysRatesToKZT(Currency baseCurrency);

}

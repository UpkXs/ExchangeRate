package aro.exchangeRate.impl;

import aro.exchangeRate.enums.Currency;
import aro.exchangeRate.inService.CurrencyApiInService;
import aro.exchangeRate.model.ExchangeRateResult;
import aro.exchangeRate.model.Rates;
import aro.exchangeRate.model.request.CurrencyApiRequest;
import aro.exchangeRate.model.response.CurrencyApiResponse;
import aro.exchangeRate.register.ExchangeRateRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;

import static aro.exchangeRate.enums.Currency.KZT;

@Component
public class ExchangeRateRegisterImpl implements ExchangeRateRegister {

    @Autowired
    private CurrencyApiInService currencyApiInService;

    @Override
    public ExchangeRateResult getLast10DaysRatesToKZT(Currency baseCurrency) {
        LocalDate lastUpdatedAt = currencyApiInService.getLastUpdatedAt();

        CurrencyApiRequest currencyApiRequest = CurrencyApiRequest.of(baseCurrency, KZT, lastUpdatedAt);

        ExchangeRateResult result = ExchangeRateResult.of(baseCurrency, KZT, new ArrayList<>());

        for (int i = 1; i <= 10; i++) {
            lastUpdatedAt = lastUpdatedAt.minusDays(1);

            currencyApiRequest.setDate(lastUpdatedAt);

            CurrencyApiResponse currencyRate = currencyApiInService.getCurrencyRateForDate(currencyApiRequest);

            if (currencyRate != null) {
                Rates rates = Rates.of(lastUpdatedAt, currencyRate.data().get(KZT).value());

                result.rates.add(rates);
            }
        }

        return result;
    }


}

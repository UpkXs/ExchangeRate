package aro.exchangeRate.inService;

import aro.exchangeRate.model.request.CurrencyApiRequest;
import aro.exchangeRate.model.response.CurrencyApiResponse;

import java.time.LocalDate;

public interface CurrencyApiInService {

    CurrencyApiResponse getCurrencyRateForDate(CurrencyApiRequest currencyApiRequest);

    LocalDate getLastUpdatedAt();

}

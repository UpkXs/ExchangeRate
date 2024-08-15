package aro.exchangeRate.inService;

import aro.exchangeRate.model.request.CurrencyApiRequest;
import aro.exchangeRate.model.response.CurrencyApiResponse;
import aro.exchangeRate.model.response.Meta;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;

public class CurrencyApiInServiceFake implements CurrencyApiInService {

    @Override
    public CurrencyApiResponse getCurrencyRateForDate(CurrencyApiRequest currencyApiRequest) {
        Meta meta = new Meta(new Date());

        return new CurrencyApiResponse(meta, Collections.emptyMap());
    }

    @Override
    public LocalDate getLastUpdatedAt() {
        return LocalDate.now();
    }

}

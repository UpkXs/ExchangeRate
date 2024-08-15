package aro.exchangeRate.model.response;

import aro.exchangeRate.enums.Currency;

import java.util.Map;

public record CurrencyApiResponse(
        Meta meta,
        Map<Currency, Data> data
) {
}

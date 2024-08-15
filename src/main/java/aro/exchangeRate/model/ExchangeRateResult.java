package aro.exchangeRate.model;

import aro.exchangeRate.enums.Currency;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor(staticName = "of")
public class ExchangeRateResult {

    public Currency from;
    public Currency to;
    public List<Rates> rates;

}

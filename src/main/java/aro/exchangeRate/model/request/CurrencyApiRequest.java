package aro.exchangeRate.model.request;

import aro.exchangeRate.enums.Currency;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor(staticName = "of")
@Data
public class CurrencyApiRequest {

    private Currency baseCurrency;
    private Currency exchangeTo;
    private LocalDate date;

}

package aro.exchangeRate.controller;

import aro.exchangeRate.enums.Currency;
import aro.exchangeRate.error.InvalidCurrencyException;
import aro.exchangeRate.model.ExchangeRateResult;
import aro.exchangeRate.register.ExchangeRateRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/exchange-rate/api/v1")
public class ExchangeRateController {

    @Autowired
    private ExchangeRateRegister exchangeRateRegister;

    @GetMapping("/to-kzt/history")
    public ResponseEntity<ExchangeRateResult> getLast10DaysRatesToKZT(@RequestParam("baseCurrency") String baseCurrency) {
        // Проверяем, является ли baseCurrency допустимым значением
        Currency currency;
        try {
            currency = Currency.valueOf(baseCurrency);
        } catch (IllegalArgumentException e) {
            throw new InvalidCurrencyException("M6rV8XcOL :: Invalid base currency `" + baseCurrency + "`.\n" +
                    "Supported currencies: " + Arrays.toString(Currency.values()), e);
        }

        ExchangeRateResult result = exchangeRateRegister.getLast10DaysRatesToKZT(currency);
        return ResponseEntity.ok(result);
    }

}

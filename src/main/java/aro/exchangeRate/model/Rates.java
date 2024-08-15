package aro.exchangeRate.model;

import lombok.AllArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor(staticName = "of")
public class Rates {

    public LocalDate date;
    public String value;

}

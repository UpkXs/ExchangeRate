package aro.exchangeRate.config;

import aro.exchangeRate.inService.CurrencyApiConstants;
import aro.exchangeRate.inService.CurrencyApiInService;
import aro.exchangeRate.inService.CurrencyApiInServiceFake;
import aro.exchangeRate.inService.CurrencyApiInServiceReal;
import com.squareup.okhttp.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExchangeRateConfig {

    @Bean
    public OkHttpClient okHttpClient() {
        return new OkHttpClient();
    }

    @Bean
    public CurrencyApiInService currencyApiInService() {
        return CurrencyApiConstants.useFake ? new CurrencyApiInServiceFake() : new CurrencyApiInServiceReal(okHttpClient());
    }

}

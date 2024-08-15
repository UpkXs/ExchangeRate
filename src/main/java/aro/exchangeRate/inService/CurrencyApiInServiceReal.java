package aro.exchangeRate.inService;

import aro.exchangeRate.error.CurrencyApiException;
import aro.exchangeRate.model.request.CurrencyApiRequest;
import aro.exchangeRate.model.response.CurrencyApiResponse;
import aro.exchangeRate.model.response.LatestApiResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Component
public class CurrencyApiInServiceReal implements CurrencyApiInService {

    private final OkHttpClient okHttpClient;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public CurrencyApiInServiceReal(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
    }

    @Override
    public CurrencyApiResponse getCurrencyRateForDate(CurrencyApiRequest currencyApiRequest) {
        HttpUrl url = baseApiUrl()
                .addPathSegment(CurrencyApiConstants.HISTORICAL_PATH)
                .addQueryParameter(CurrencyApiConstants.DATE, currencyApiRequest.getDate().toString())
                .addQueryParameter(CurrencyApiConstants.BASE_CURRENCY, currencyApiRequest.getBaseCurrency().name())
                .addQueryParameter(CurrencyApiConstants.CURRENCIES, currencyApiRequest.getExchangeTo().name())
                .build();

        Request request = createRequest(url);

        return executeRequest(request, CurrencyApiResponse.class);
    }

    @Override
    public LocalDate getLastUpdatedAt() {
        HttpUrl url = baseApiUrl()
                .addPathSegment(CurrencyApiConstants.LATEST_PATH)
                .build();

        Request request = createRequest(url);

        LatestApiResponse latestApiResponse = executeRequest(request, LatestApiResponse.class);

        return latestApiResponse != null ? convertToLocalDate(latestApiResponse.meta().lastUpdatedAt()) : LocalDate.now();
    }

    private <T> T executeRequest(Request request, Class<T> valueType) {
        try {
            Response response = okHttpClient.newCall(request).execute();

            if (response.isSuccessful() && response.body() != null) {
                return objectMapper.readValue(response.body().string(), valueType);
            }
        } catch (IOException e) {
            throw new CurrencyApiException("7Q9VzXvPs :: error while executing request", e);
        }

        return null;
    }

    private Request createRequest(HttpUrl url) {
        return new Request.Builder()
                .url(url)
                .get()
                .header(CurrencyApiConstants.API_KEY, CurrencyApiConstants.API_KEY_VALUE)
                .build();
    }

    private HttpUrl.Builder baseApiUrl() {
        return HttpUrl.parse(CurrencyApiConstants.BASE_API_URL).newBuilder();
    }

    private static LocalDate convertToLocalDate(Date date) {
        Instant instant = date.toInstant();

        return instant.atZone(ZoneId.systemDefault()).toLocalDate();
    }

}

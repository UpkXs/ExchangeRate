package aro.exchangeRate.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LatestApiResponse(
        Meta meta
) {
}

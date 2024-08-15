package aro.exchangeRate.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public record Meta(
        @JsonProperty("last_updated_at")
        Date lastUpdatedAt) {
}

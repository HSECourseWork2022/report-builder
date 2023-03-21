package dev.hse.template.cryptocurrency.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PriceStatsDTO {

    @JsonProperty("minimum_price")
    private Double minimumPrice;
    @JsonProperty("maximum_price")
    private Double maximumPrice;
    @JsonProperty("median_price")
    private Double medianPrice;
}
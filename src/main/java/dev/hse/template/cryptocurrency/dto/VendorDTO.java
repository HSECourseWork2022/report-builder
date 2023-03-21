package dev.hse.template.cryptocurrency.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VendorDTO {

    @JsonProperty("vendor_id")
    private Long vendorId;
    @JsonProperty("vendor_name")
    private String vendorName;
}

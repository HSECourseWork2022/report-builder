package dev.hse.template.cryptocurrency.service.mapper;

import dev.hse.template.cryptocurrency.dto.VendorDTO;
import dev.hse.template.cryptocurrency.persistence.entity.Vendor;

public class VendorMapper {

    private VendorMapper() {}

    public static VendorDTO toDTO(Vendor vendor) {
        return VendorDTO.builder()
                .vendorId(vendor.getId())
                .vendorName(vendor.getVendorName())
                .build();
    }
}

package dev.hse.template.cryptocurrency.service.mapper;

import dev.hse.template.cryptocurrency.dto.CryptocurrencyDTO;
import dev.hse.template.cryptocurrency.persistence.entity.CryptocurrencyRecord;

public class CryptocurrencyMapper {

    private CryptocurrencyMapper() {}

    public static CryptocurrencyDTO toDTO(CryptocurrencyRecord cryptocurrencyRecord) {
        return CryptocurrencyDTO.builder()
                .cryptocurrencySymbol(cryptocurrencyRecord.getSymbol())
                .build();
    }
}

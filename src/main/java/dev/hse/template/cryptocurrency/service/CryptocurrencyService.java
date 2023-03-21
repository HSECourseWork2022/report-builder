package dev.hse.template.cryptocurrency.service;

import dev.hse.template.cryptocurrency.dto.CryptocurrencyDTO;
import dev.hse.template.cryptocurrency.dto.PriceStatsDTO;
import dev.hse.template.cryptocurrency.dto.VendorDTO;
import dev.hse.template.cryptocurrency.persistence.entity.CryptocurrencyRecord;
import dev.hse.template.cryptocurrency.persistence.entity.Vendor;
import dev.hse.template.cryptocurrency.persistence.repository.CryptocurrencyRepository;
import dev.hse.template.cryptocurrency.persistence.repository.VendorRepository;
import dev.hse.template.cryptocurrency.service.mapper.CryptocurrencyMapper;
import dev.hse.template.cryptocurrency.service.mapper.VendorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CryptocurrencyService {

    private final CryptocurrencyRepository cryptocurrencyRepository;
    private final VendorRepository vendorRepository;

    public List<VendorDTO> getAllVendors() {
        List<Vendor> vendors = vendorRepository.findAll();
        return vendors.stream().map(VendorMapper::toDTO).collect(Collectors.toList());
    }

    public List<CryptocurrencyDTO> getAllCryptocurrencies() {
        List<CryptocurrencyRecord> cryptocurrencyRecords = cryptocurrencyRepository.findAll();
        return cryptocurrencyRecords.stream().map(CryptocurrencyMapper::toDTO).collect(Collectors.toList());
    }

    public PriceStatsDTO getCryptocurrencyPriceStats(Long vendorId, String symbol, LocalDateTime fromDateTime, LocalDateTime toDateTime) {
        var statistics = cryptocurrencyRepository.findAllBySymbolAndVendorAndObservedAtBetween(symbol, vendorId, fromDateTime, toDateTime)
                .stream()
                .mapToDouble(CryptocurrencyRecord::getPriceUSD)
                .summaryStatistics();
        return new PriceStatsDTO(
                statistics.getMin(),
                statistics.getMax(),
                statistics.getAverage()
        );
    }
}

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
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CryptocurrencyService {

    private final CryptocurrencyRepository cryptocurrencyRepository;
    private final VendorRepository vendorRepository;

    public CryptocurrencyService(CryptocurrencyRepository cryptocurrencyRepository, VendorRepository vendorRepository) {
        this.cryptocurrencyRepository = cryptocurrencyRepository;
        this.vendorRepository = vendorRepository;
    }

    public List<VendorDTO> getAllVendors() {
        List<Vendor> vendors = vendorRepository.findAll();
        return vendors.stream().map(VendorMapper::toDTO).collect(Collectors.toList());
    }

    public List<CryptocurrencyDTO> getAllCryptocurrencies() {
        List<CryptocurrencyRecord> cryptocurrencyRecords = cryptocurrencyRepository.findAll();
        return cryptocurrencyRecords.stream().map(CryptocurrencyMapper::toDTO).collect(Collectors.toList());
    }

    public PriceStatsDTO getCryptocurrencyPriceStats(Long vendorId, String symbol, LocalDateTime fromDateTime, LocalDateTime toDateTime) {
        var records = cryptocurrencyRepository.findAllBySymbolAndVendorAndObservedAtBetween(symbol, vendorId, fromDateTime, toDateTime);
        var stats = records
                .stream()
                .map(rec -> PriceStatsDTO.builder()
                        .minimumPrice(rec.getPriceUSD())
                        .medianPrice(rec.getPriceUSD())
                        .maximumPrice(rec.getPriceUSD())
                        .build())
                .reduce((acc, rec) -> PriceStatsDTO.builder()
                        .minimumPrice(Math.min(acc.getMinimumPrice(), rec.getMinimumPrice()))
                        .medianPrice(acc.getMedianPrice() + rec.getMedianPrice())
                        .maximumPrice(Math.max(acc.getMaximumPrice(), rec.getMaximumPrice()))
                        .build())
                .orElse(PriceStatsDTO.builder()
                        .minimumPrice(null)
                        .medianPrice(null)
                        .maximumPrice(null)
                        .build());
        if (stats.getMedianPrice() != null) {
            stats.setMedianPrice(stats.getMedianPrice() / records.size());
        }
        return stats;
    }
}

package dev.hse.template.cryptocurrency.persistence.repository;

import dev.hse.template.cryptocurrency.persistence.entity.CryptocurrencyRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface CryptocurrencyRepository extends JpaRepository<CryptocurrencyRecord, Long> {

    List<CryptocurrencyRecord> findAllBySymbolAndVendorAndObservedAtBetween(
            String symbol,
            Long vendor,
            LocalDateTime fromDate,
            LocalDateTime toDate);
}

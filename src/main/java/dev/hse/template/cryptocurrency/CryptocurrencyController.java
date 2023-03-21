package dev.hse.template.cryptocurrency;

import dev.hse.template.cryptocurrency.dto.CryptocurrencyDTO;
import dev.hse.template.cryptocurrency.dto.PriceStatsDTO;
import dev.hse.template.cryptocurrency.dto.VendorDTO;
import dev.hse.template.cryptocurrency.service.CryptocurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class CryptocurrencyController {

    private final CryptocurrencyService cryptocurrencyService;

    @GetMapping("/vendors")
    public List<VendorDTO> getAllVendors() {
        return cryptocurrencyService.getAllVendors();
    }

    @GetMapping("/cryptocurrencies")
    public List<CryptocurrencyDTO> getAllCryptocurrencies() {
        return cryptocurrencyService.getAllCryptocurrencies();
    }

    @GetMapping("/vendors/{vendorId}/cryptocurrencies/{symbol}/prices")
    public PriceStatsDTO getCryptocurrencyPriceStats(
            @PathVariable Long vendorId,
            @PathVariable String symbol,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fromDateTime,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime toDateTime
    ) {
        return cryptocurrencyService.getCryptocurrencyPriceStats(vendorId, symbol, fromDateTime, toDateTime);
    }
}

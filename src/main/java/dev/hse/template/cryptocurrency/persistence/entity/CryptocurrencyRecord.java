package dev.hse.template.cryptocurrency.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@Entity(name = "cryptocurrency_record")
@NoArgsConstructor
@AllArgsConstructor
public class CryptocurrencyRecord {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "observed_at")
    LocalDateTime observedAt;
    @Column(name = "symbol")
    String symbol;
    @Column(name = "vendor")
    Long vendor;
    @Column(name = "max_supply")
    Long maxSupply;
    @Column(name = "circulating_supply")
    Long circulatingSupply;
    @Column(name = "total_supply")
    Long totalSupply;
    @Column(name = "price_usd")
    Double priceUSD;
    @Column(name = "volume_24h")
    Double volume24h;
    @Column(name = "market_cap")
    Double marketCap;
}
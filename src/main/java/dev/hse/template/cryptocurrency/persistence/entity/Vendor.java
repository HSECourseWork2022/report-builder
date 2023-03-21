package dev.hse.template.cryptocurrency.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@Entity(name = "cryptocurrency_vendor")
@NoArgsConstructor
@AllArgsConstructor
public class Vendor {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "vendor_name")
    String vendorName;
}

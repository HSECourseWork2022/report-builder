package dev.hse.template.cryptocurrency.persistence.repository;

import dev.hse.template.cryptocurrency.persistence.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository<Vendor, Long> {
}

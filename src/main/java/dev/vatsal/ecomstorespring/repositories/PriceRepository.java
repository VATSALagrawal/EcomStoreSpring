package dev.vatsal.ecomstorespring.repositories;

import dev.vatsal.ecomstorespring.models.Price;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PriceRepository extends JpaRepository<Price, UUID> {
    @Override
    <S extends Price> S save(S entity);

    Optional<Price> findByPrice(double price);
}

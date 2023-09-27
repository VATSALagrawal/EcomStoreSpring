package dev.vatsal.ecomstorespring.repositories;

import dev.vatsal.ecomstorespring.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    @Override
    <S extends Product> S save(S entity);
}

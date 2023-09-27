package dev.vatsal.ecomstorespring.repositories;

import dev.vatsal.ecomstorespring.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
    @Override
    <S extends Category> S save(S entity);
}

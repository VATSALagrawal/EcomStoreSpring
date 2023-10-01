package dev.vatsal.ecomstorespring.repositories;

import dev.vatsal.ecomstorespring.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    @Override
    <S extends Product> S save(S entity);

    List<Product> findAllByPrice_CurrencyEquals(String currency);

    @Query(value = CustomQueries.FIND_ALL_BY_TITLE,nativeQuery = true) // Native SQL query
    List<Product> findAllByTitle(String parameter);

//    @Query("select Product from Product where Product.price.currency = :currency") // Hibernate Query
//    List<Product> readAllByTitleHibernateQuery(String title , String currency);
}

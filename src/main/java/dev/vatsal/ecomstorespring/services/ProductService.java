package dev.vatsal.ecomstorespring.services;

import dev.vatsal.ecomstorespring.dtos.GenericProductDTO;
import dev.vatsal.ecomstorespring.models.Product;

public interface ProductService {
    GenericProductDTO getProductById(Long id);
}

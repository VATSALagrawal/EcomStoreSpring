package dev.vatsal.ecomstorespring.services;

import dev.vatsal.ecomstorespring.dtos.GenericProductDTO;
import dev.vatsal.ecomstorespring.models.Product;

import java.util.List;

public interface ProductService {
    GenericProductDTO getProductById(Long id);

    GenericProductDTO createProduct(GenericProductDTO genericProductDTO);

    List<GenericProductDTO> getAllProducts();

    GenericProductDTO deleteProductById(Long id);

    GenericProductDTO updateProductById(Long id,GenericProductDTO genericProductDTO);

}

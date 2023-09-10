package dev.vatsal.ecomstorespring.services;

import dev.vatsal.ecomstorespring.Exceptions.NotFoundException;
import dev.vatsal.ecomstorespring.dtos.GenericProductDTO;
import dev.vatsal.ecomstorespring.models.Product;

import java.util.List;

public interface ProductService {
    GenericProductDTO getProductById(Long id) throws NotFoundException;

    GenericProductDTO createProduct(GenericProductDTO genericProductDTO);

    List<GenericProductDTO> getAllProducts() throws NotFoundException;

    GenericProductDTO deleteProductById(Long id) throws NotFoundException;

    GenericProductDTO updateProductById(Long id,GenericProductDTO genericProductDTO) throws NotFoundException;

}

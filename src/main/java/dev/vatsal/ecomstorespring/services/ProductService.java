package dev.vatsal.ecomstorespring.services;

import dev.vatsal.ecomstorespring.Exceptions.NotFoundException;
import dev.vatsal.ecomstorespring.dtos.GenericProductDTO;
import dev.vatsal.ecomstorespring.models.Category;

import java.util.List;
import java.util.UUID;

// Created seperate ProductServicewithUUID since ProductService is being used with FakeStoreService

public interface ProductService {
    GenericProductDTO getProductById(UUID id) throws NotFoundException;

    GenericProductDTO createProduct(GenericProductDTO genericProductDTO);

    List<GenericProductDTO> getAllProducts() throws NotFoundException;

    GenericProductDTO deleteProductById(UUID id) throws NotFoundException;

    GenericProductDTO updateProductById(UUID id,GenericProductDTO genericProductDTO) throws NotFoundException;

    List<GenericProductDTO> getAllProductsWithCategory(UUID category_id) throws NotFoundException;
}

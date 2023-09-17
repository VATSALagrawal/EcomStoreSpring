package dev.vatsal.ecomstorespring.thirdpartyclients.productservice;

import dev.vatsal.ecomstorespring.Exceptions.NotFoundException;
import dev.vatsal.ecomstorespring.dtos.GenericProductDTO;

import java.util.List;

public interface ThirdPartyServiceClient {
    GenericProductDTO getProductById(Long id) throws NotFoundException;

    GenericProductDTO createProduct(GenericProductDTO genericProductDTO);

    List<GenericProductDTO> getAllProducts() throws NotFoundException;

    GenericProductDTO deleteProductById(Long id) throws NotFoundException;

    GenericProductDTO updateProductById(Long id,GenericProductDTO genericProductDTO) throws NotFoundException;

}

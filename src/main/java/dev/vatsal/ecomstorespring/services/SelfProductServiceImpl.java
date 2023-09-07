package dev.vatsal.ecomstorespring.services;

import dev.vatsal.ecomstorespring.dtos.GenericProductDTO;
import dev.vatsal.ecomstorespring.models.Product;
import org.springframework.stereotype.Service;

@Service("selfProductServiceImpl")
public class SelfProductServiceImpl implements ProductService{

    @Override
    public GenericProductDTO getProductById(Long id) {
        return new GenericProductDTO();
    }
}

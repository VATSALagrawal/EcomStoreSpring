package dev.vatsal.ecomstorespring.services;

import dev.vatsal.ecomstorespring.Exceptions.NotFoundException;
import dev.vatsal.ecomstorespring.dtos.FakeStoreProductDTO;
import dev.vatsal.ecomstorespring.dtos.GenericProductDTO;
import dev.vatsal.ecomstorespring.models.Product;
import dev.vatsal.ecomstorespring.thirdpartyclients.productservice.fakestoreapi.FakeStoreApiAdaptor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductServiceForFakeStore{

    private FakeStoreApiAdaptor fakeStoreApiAdaptor;

    public FakeStoreProductService(FakeStoreApiAdaptor fakeStoreApiAdaptor){
        this.fakeStoreApiAdaptor = fakeStoreApiAdaptor;
    }
    @Override
    public GenericProductDTO getProductById(Long id) throws NotFoundException {

        return fakeStoreApiAdaptor.getProductById(id);
    }

    @Override
    public GenericProductDTO createProduct(GenericProductDTO genericProductDTO) {
        return fakeStoreApiAdaptor.createProduct(genericProductDTO);
    }

    @Override
    public List<GenericProductDTO> getAllProducts() throws NotFoundException {
        return fakeStoreApiAdaptor.getAllProducts();
    }

    @Override
    public GenericProductDTO deleteProductById(Long id) throws NotFoundException {
       return fakeStoreApiAdaptor.deleteProductById(id);
    }

    @Override
    public GenericProductDTO updateProductById(Long id ,GenericProductDTO genericProductDTO) throws NotFoundException {
       return fakeStoreApiAdaptor.updateProductById(id,genericProductDTO);
    }
}

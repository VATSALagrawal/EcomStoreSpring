package dev.vatsal.ecomstorespring.services;

import dev.vatsal.ecomstorespring.dtos.FakeStoreProductDTO;
import dev.vatsal.ecomstorespring.dtos.GenericProductDTO;
import dev.vatsal.ecomstorespring.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{
    private String getProductRequestUrl = "https://fakestoreapi.com/products/{id}";
    private String createProductRequestUrl = "https://fakestoreapi.com/products";

    private RestTemplateBuilder restTemplateBuilder;
    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder = restTemplateBuilder;
    }
    @Override
    public GenericProductDTO getProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTO> responseEntity = restTemplate.getForEntity(getProductRequestUrl, FakeStoreProductDTO.class,id);

        FakeStoreProductDTO fakeStoreProductDTO = responseEntity.getBody();
        GenericProductDTO product = new GenericProductDTO();
        product.setImage(fakeStoreProductDTO.getImage());
        product.setDescription(fakeStoreProductDTO.getDescription());
        product.setTitle(fakeStoreProductDTO.getTitle());
        product.setPrice(fakeStoreProductDTO.getPrice());
        product.setCategory(fakeStoreProductDTO.getCategory());
        return product;
    }

    @Override
    public GenericProductDTO createProduct(GenericProductDTO genericProductDTO) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<GenericProductDTO> responseEntity = restTemplate.postForEntity(createProductRequestUrl,genericProductDTO, GenericProductDTO.class);
        return responseEntity.getBody();
    }
}

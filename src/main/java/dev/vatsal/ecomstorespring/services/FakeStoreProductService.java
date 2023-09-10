package dev.vatsal.ecomstorespring.services;

import dev.vatsal.ecomstorespring.Exceptions.NotFoundException;
import dev.vatsal.ecomstorespring.dtos.FakeStoreProductDTO;
import dev.vatsal.ecomstorespring.dtos.GenericProductDTO;
import dev.vatsal.ecomstorespring.models.Product;
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
public class FakeStoreProductService implements ProductService{
    private String specificProductRequestUrl = "https://fakestoreapi.com/products/{id}";
    private String createProductRequestUrl = "https://fakestoreapi.com/products";
    private String getAllProductsRequestUrl = "https://fakestoreapi.com/products";

    private RestTemplateBuilder restTemplateBuilder;
    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder = restTemplateBuilder;
    }

    public GenericProductDTO convertFakeStoreProductDTOtoGenericProductDTO(FakeStoreProductDTO fakeStoreProductDTO) throws NotFoundException {
        if(fakeStoreProductDTO==null)
            throw new NotFoundException("Product with given id not found");

        GenericProductDTO product = new GenericProductDTO();
        product.setId(fakeStoreProductDTO.getId());
        product.setImage(fakeStoreProductDTO.getImage());
        product.setDescription(fakeStoreProductDTO.getDescription());
        product.setTitle(fakeStoreProductDTO.getTitle());
        product.setPrice(fakeStoreProductDTO.getPrice());
        product.setCategory(fakeStoreProductDTO.getCategory());
        return product;
    }
    @Override
    public GenericProductDTO getProductById(Long id) throws NotFoundException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTO> responseEntity = restTemplate.getForEntity(specificProductRequestUrl, FakeStoreProductDTO.class,id);

        FakeStoreProductDTO fakeStoreProductDTO = responseEntity.getBody();

        return convertFakeStoreProductDTOtoGenericProductDTO(fakeStoreProductDTO);
    }

    @Override
    public GenericProductDTO createProduct(GenericProductDTO genericProductDTO) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<GenericProductDTO> responseEntity = restTemplate.postForEntity(createProductRequestUrl,genericProductDTO, GenericProductDTO.class);
        return responseEntity.getBody();
    }

    @Override
    public List<GenericProductDTO> getAllProducts() throws NotFoundException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        // Method 1
//        ResponseEntity<List> response = restTemplate.getForEntity(getAllProductsRequestUrl,List.class);
//        // returns a response of List type due to Java erasures not of List<FakeStoreProductDTO> type
//        // Does Not Work Gives Class Cast Exception and also not ideal way to implement
//        List<GenericProductDTO> products = new ArrayList<>();
//        for(Object obj: response.getBody()){
//            products.add(convertFakeStoreProductDTOtoGenericProductDTO(((FakeStoreProductDTO)obj)));
//        }

        // Method 2 : use Array of FakeStoreProductDTO instead of List
        ResponseEntity<FakeStoreProductDTO[]> response = restTemplate.getForEntity(getAllProductsRequestUrl,FakeStoreProductDTO[].class);
        List<GenericProductDTO> products = new ArrayList<>();
        for(FakeStoreProductDTO fakeStoreProductDTO: response.getBody()){
            products.add(convertFakeStoreProductDTOtoGenericProductDTO((fakeStoreProductDTO)));
        }
        return products;
    }

    @Override
    public GenericProductDTO deleteProductById(Long id) throws NotFoundException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDTO.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDTO>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDTO.class);
        ResponseEntity<FakeStoreProductDTO> response = restTemplate.execute(specificProductRequestUrl, HttpMethod.DELETE, requestCallback, responseExtractor, id);
        return convertFakeStoreProductDTOtoGenericProductDTO(response.getBody());
    }

    @Override
    public GenericProductDTO updateProductById(Long id ,GenericProductDTO genericProductDTO) throws NotFoundException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.httpEntityCallback(genericProductDTO, FakeStoreProductDTO.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDTO>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDTO.class);
        ResponseEntity<FakeStoreProductDTO> response = restTemplate.execute(specificProductRequestUrl, HttpMethod.PUT, requestCallback, responseExtractor, id);
        return convertFakeStoreProductDTOtoGenericProductDTO(response.getBody());
    }
}

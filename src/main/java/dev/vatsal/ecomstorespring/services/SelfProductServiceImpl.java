package dev.vatsal.ecomstorespring.services;

import dev.vatsal.ecomstorespring.Exceptions.NotFoundException;
import dev.vatsal.ecomstorespring.dtos.GenericProductDTO;
import dev.vatsal.ecomstorespring.models.Category;
import dev.vatsal.ecomstorespring.models.Price;
import dev.vatsal.ecomstorespring.models.Product;
import dev.vatsal.ecomstorespring.repositories.CategoryRepository;
import dev.vatsal.ecomstorespring.repositories.PriceRepository;
import dev.vatsal.ecomstorespring.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service("selfProductServiceImpl")
public class SelfProductServiceImpl implements ProductService{

    ProductRepository productRepository ;
    private final CategoryRepository categoryRepository;
    private final PriceRepository priceRepository;

    public SelfProductServiceImpl(ProductRepository productRepository,
                                  CategoryRepository categoryRepository,
                                  PriceRepository priceRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.priceRepository = priceRepository;
    }

    public GenericProductDTO convertProductToGenericProductDTO(Product product) {

        GenericProductDTO genericProductDTO = new GenericProductDTO();
        genericProductDTO.setImage(product.getImage());
        genericProductDTO.setDescription(product.getDescription());
        genericProductDTO.setTitle(product.getTitle());
        genericProductDTO.setPrice(product.getPrice().getPrice());
        genericProductDTO.setCategory(product.getCategory().getName());
        return genericProductDTO;
    }
    @Override
    public GenericProductDTO getProductById(UUID id) throws NotFoundException {

        Optional<Product> product = productRepository.findById(id);
        if(product.isEmpty())
            throw new NotFoundException("Product with given id not found");

        return convertProductToGenericProductDTO(product.get());
    }

    @Override
    public GenericProductDTO createProduct(GenericProductDTO genericProductDTO) {

        Product product = new Product();
        Optional<Category> category = categoryRepository.findDistinctByNameEquals(genericProductDTO.getCategory());
        Category categoryToSet = new Category();
        if(category.isEmpty()){
                categoryToSet.setName(genericProductDTO.getCategory());
        }
        else{
            categoryToSet = category.get();
        }
        product.setCategory(categoryToSet);
        product.setTitle(genericProductDTO.getTitle());
        product.setImage(genericProductDTO.getImage());
        product.setDescription(genericProductDTO.getDescription());
        Optional<Price> price = priceRepository.findByPrice(genericProductDTO.getPrice());
        Price priceToSet = new Price();
        if(price.isEmpty()){
            priceToSet.setPrice(genericProductDTO.getPrice());
            priceToSet.setCurrency("Rupee");
        }
        else {
            priceToSet = price.get();
        }
        product.setPrice(priceToSet);
        Product product1 = productRepository.save(product);
        return convertProductToGenericProductDTO(product1);
    }

    @Override
    public List<GenericProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<GenericProductDTO> genericProductDTOS = new ArrayList<>();
        for(Product product : products){
            genericProductDTOS.add(convertProductToGenericProductDTO(product));
        }
        return genericProductDTOS;
    }

    @Override
    public GenericProductDTO deleteProductById(UUID id) throws NotFoundException {
        Optional<Product> product = productRepository.findById(id);
        if(product.isEmpty())
            throw new NotFoundException("Product with given id not found");

        productRepository.delete(product.get());
        return convertProductToGenericProductDTO(product.get());
    }

    @Override
    public GenericProductDTO updateProductById(UUID id, GenericProductDTO genericProductDTO) throws NotFoundException {

        Optional<Product> product = productRepository.findById(id);
        if(product.isEmpty())
            throw new NotFoundException("Product with given id not found");

        Product updatedproduct = product.get();
        Category category = new Category();
        category.setName(genericProductDTO.getCategory());
        updatedproduct.setCategory(category);
        updatedproduct.setTitle(genericProductDTO.getTitle());
        updatedproduct.setImage(genericProductDTO.getImage());
        updatedproduct.setDescription(genericProductDTO.getDescription());
        Price price = new Price("Rupee", genericProductDTO.getPrice());
        updatedproduct.setPrice(price);
        Product product1 = productRepository.save(updatedproduct);
        return convertProductToGenericProductDTO(product1);
    }

    @Override
    public List<GenericProductDTO> getAllProductsWithCategory(UUID category_id) throws NotFoundException {
        List<GenericProductDTO> genericProductDTOS = new ArrayList<>();
        Optional<Category> category = categoryRepository.findById(category_id);
        if(category.isEmpty())
            throw new NotFoundException("Category with given id not found");

        List<Product> products = productRepository.findAllByCategoryEquals(category.get());
        for(Product product:products){
            genericProductDTOS.add(convertProductToGenericProductDTO(product));
        }
        return genericProductDTOS;
    }
}

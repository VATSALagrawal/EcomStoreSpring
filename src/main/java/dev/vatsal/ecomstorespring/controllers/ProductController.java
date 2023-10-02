package dev.vatsal.ecomstorespring.controllers;

import dev.vatsal.ecomstorespring.Exceptions.NotFoundException;
import dev.vatsal.ecomstorespring.dtos.GenericProductDTO;
import dev.vatsal.ecomstorespring.models.Product;
import dev.vatsal.ecomstorespring.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    // field injection
    // @Autowired
    // private ProductService productService;

    // constructor Injection
    private ProductService productService;
    @Autowired
    public ProductController(@Qualifier("selfProductServiceImpl") ProductService productService){
        this.productService = productService;
    }

    // Setter Injection
//    @Autowired
//    public void setProductService(ProductService productService){
//        this.productService = productService;
//    }
    @GetMapping
    public List<GenericProductDTO> getAllProducts() throws NotFoundException {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public GenericProductDTO getProductById(@PathVariable("id") UUID id) throws NotFoundException {

        return productService.getProductById(id);
    }
    @PostMapping
    public GenericProductDTO createProduct(@RequestBody GenericProductDTO genericProductDTO){
        return productService.createProduct(genericProductDTO);
    }
    @PutMapping("/{id}")
    public GenericProductDTO updateProductById(@PathVariable("id") UUID id,@RequestBody GenericProductDTO genericProductDTO) throws NotFoundException {
        return productService.updateProductById(id,genericProductDTO);
    }
    @DeleteMapping("/{id}")
    public GenericProductDTO deleteProductById(@PathVariable("id") UUID id) throws NotFoundException {
        return productService.deleteProductById(id);
    }

    @GetMapping("/category/{id}")
    public List<GenericProductDTO> getProductsWithCategory(@PathVariable("id") UUID id) throws NotFoundException {
        return productService.getAllProductsWithCategory(id);
    }
}

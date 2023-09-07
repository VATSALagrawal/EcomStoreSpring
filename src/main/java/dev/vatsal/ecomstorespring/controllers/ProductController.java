package dev.vatsal.ecomstorespring.controllers;

import dev.vatsal.ecomstorespring.dtos.GenericProductDTO;
import dev.vatsal.ecomstorespring.models.Product;
import dev.vatsal.ecomstorespring.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    // field injection
    // @Autowired
    // private ProductService productService;

    // constructor Injection
    private ProductService productService;
    @Autowired
    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService){
        this.productService = productService;
    }

    // Setter Injection
//    @Autowired
//    public void setProductService(ProductService productService){
//        this.productService = productService;
//    }
    @GetMapping
    public void getAllProducts(){

    }

    @GetMapping("/{id}")
    public GenericProductDTO getProductById(@PathVariable("id") Long id){

        return productService.getProductById(id);
    }
    @PostMapping
    public void createProduct(){

    }
    @PutMapping("/{id}")
    public void updateProductById(){

    }
    @DeleteMapping("/{id}")
    public void deleteProductById(){

    }
}

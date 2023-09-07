package dev.vatsal.ecomstorespring.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    @GetMapping
    public void getAllProducts(){

    }

    @GetMapping("/{id}")
    public String getProductById(@PathVariable("id") Long id){
        return "Here is Product with ID"+id;
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

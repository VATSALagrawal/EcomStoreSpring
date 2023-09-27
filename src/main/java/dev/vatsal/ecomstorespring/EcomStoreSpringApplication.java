package dev.vatsal.ecomstorespring;

import dev.vatsal.ecomstorespring.models.Category;
import dev.vatsal.ecomstorespring.models.Product;
import dev.vatsal.ecomstorespring.repositories.CategoryRepository;
import dev.vatsal.ecomstorespring.repositories.ProductRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class EcomStoreSpringApplication {

    private static ProductRepository productRepository;
    private static CategoryRepository categoryRepository;

    public EcomStoreSpringApplication(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public static void main(String[] args) {

        SpringApplication.run(EcomStoreSpringApplication.class, args);

        Category category = new Category();
        category.setName("Electronics");

        Category savedCategory = categoryRepository.save(category);

        Product product = new Product();
        product.setTitle("Apple Iphone 15");
        product.setDescription("Apple Phone");
        product.setPrice(100.00);
        product.setImage("image-url");
        product.setCategory(category);

        productRepository.save(product);

        Category category1 = categoryRepository.findById(UUID.fromString("9f40ce41-06f6-4763-b67e-2c23915a6cea")).get();
        for(Product product1 : category1.getProducts()){
            System.out.println(product1.getTitle());
        }

    }

}

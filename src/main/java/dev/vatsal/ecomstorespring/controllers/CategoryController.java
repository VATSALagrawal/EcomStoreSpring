package dev.vatsal.ecomstorespring.controllers;

import dev.vatsal.ecomstorespring.dtos.GenericCategoryDTO;
import dev.vatsal.ecomstorespring.models.Category;
import dev.vatsal.ecomstorespring.repositories.CategoryRepository;
import dev.vatsal.ecomstorespring.services.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/all")
    public List<GenericCategoryDTO> getAllCategories(){
        return categoryService.getAllCategories();
    }

}

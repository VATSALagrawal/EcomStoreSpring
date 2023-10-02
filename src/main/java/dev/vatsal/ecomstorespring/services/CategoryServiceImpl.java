package dev.vatsal.ecomstorespring.services;

import dev.vatsal.ecomstorespring.dtos.GenericCategoryDTO;
import dev.vatsal.ecomstorespring.models.Category;
import dev.vatsal.ecomstorespring.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("CategoryServiceImpl")
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public GenericCategoryDTO convertCategoryToGenericCategoryDTO(Category category){
        GenericCategoryDTO genericCategoryDTO = new GenericCategoryDTO();
        genericCategoryDTO.setName(category.getName());
        return genericCategoryDTO;
    }
    @Override
    public List<GenericCategoryDTO> getAllCategories() {

        List<Category> categories = categoryRepository.findAll();
        List<GenericCategoryDTO> genericCategoryDTOS = new ArrayList<>();
        for(Category category : categories){
            genericCategoryDTOS.add(convertCategoryToGenericCategoryDTO(category));
        }
        return genericCategoryDTOS;
    }
}

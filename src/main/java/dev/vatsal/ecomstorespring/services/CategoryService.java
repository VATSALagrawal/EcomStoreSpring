package dev.vatsal.ecomstorespring.services;

import dev.vatsal.ecomstorespring.dtos.GenericCategoryDTO;
import dev.vatsal.ecomstorespring.models.Category;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CategoryService {
    List<GenericCategoryDTO> getAllCategories();
}

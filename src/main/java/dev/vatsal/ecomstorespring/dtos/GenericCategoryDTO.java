package dev.vatsal.ecomstorespring.dtos;

import dev.vatsal.ecomstorespring.models.Product;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GenericCategoryDTO {
    private String name;
}

package dev.vatsal.ecomstorespring.dtos;

import dev.vatsal.ecomstorespring.models.BaseModel;
import dev.vatsal.ecomstorespring.models.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenericProductDTO {
    private String title;
    private String description;
    private String image;
    private String category;
    private double price;
}

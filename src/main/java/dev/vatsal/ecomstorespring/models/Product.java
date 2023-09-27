package dev.vatsal.ecomstorespring.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product extends BaseModel{
    private String title;
    private String description;
    private String image;

    @ManyToOne
    private Category category;

    private double price;
}

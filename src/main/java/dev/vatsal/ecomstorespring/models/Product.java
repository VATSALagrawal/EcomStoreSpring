package dev.vatsal.ecomstorespring.models;

import jakarta.persistence.*;
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

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name="category") // name the column in table
    private Category category;

    @OneToOne(cascade = {CascadeType.PERSIST , CascadeType.REMOVE})
    private Price price;
}

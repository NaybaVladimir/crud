package org.example.dto.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Purchases {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Client client;

    private Date purchaseDate;

    @ManyToMany
    private List<Product> product;

    public List<Product> getProduct() {
        if (product == null) {
            product = new ArrayList<>();
        }

        return product;
    }
}

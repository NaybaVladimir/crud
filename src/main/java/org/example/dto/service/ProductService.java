package org.example.dto.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.dto.model.Product;
import org.example.dto.repos.ProductRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class ProductService {
    private ProductRepository productRepository;

    @Transactional
    public void save(Product product) {
        productRepository.save(product);
    }
}
